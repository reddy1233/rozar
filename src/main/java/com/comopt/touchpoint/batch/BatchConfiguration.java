package com.comopt.touchpoint.batch;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.comopt.touchpoint.AppConstant;
import com.comopt.touchpoint.model.TouchPointActor;


@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfiguration extends DefaultBatchConfigurer{
	
	private final String QUERY ="select * from ccm_trans_audit ta, ccm_trans_dtls_audit tda, ccm_trans_dtls_strg_pfm_status_audit tdsps, ccm_trans_comm_chnl_status_audit tccsa, " + 
			"ccm_trans_dtls_comm_chnl_status_audit tdcsa where " + 
			" ta.trans_id = tda.trans_id  " + 
			"and tda.trns_dtls_seq_id  = tdsps.trns_dtls_seq_id   " + 
			"and ta.trans_id =tccsa.trans_id   " + 
			"and tda.trns_dtls_seq_id =tdcsa.trns_dtls_seq_id   " + 
			"and tdsps.strg_pfm_status= 'Accepted' " + 
			"and tdcsa.comm_chnl_status_cd ='0'  ";

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    private JobCompletionNotificationListener listener;
    
    @Autowired
    private DataSource dataSource; 
    
    
    
    @Override
    public void setDataSource(DataSource dataSource) {
    	//donot write spring batch metadata to database
        // override to do not set datasource even if a datasource exist.
        // initialize will use a Map based JobRepository (instead of database)
    }
   
    @Bean(destroyMethod = "")
    public JdbcCursorItemReader<TouchPointActor> reader(){
    	
    	System.out.println("dataSource>>>>>>"+dataSource);
    	
     JdbcCursorItemReader<TouchPointActor> reader = new JdbcCursorItemReader<TouchPointActor>();
     reader.setDataSource(dataSource);
     reader.setSql(QUERY);
     reader.setVerifyCursorPosition(false);
     reader.setRowMapper(new TouchPointActorRowMapper());
     
     return reader;
    }

    
    public class TouchPointActorRowMapper implements RowMapper<TouchPointActor>{

     @Override
     public TouchPointActor mapRow(ResultSet rs, int rowNum) throws SQLException {
    	 
    	
    	 TouchPointActor tpa = new TouchPointActor();
    	 tpa.setAppId(rs.getString("file_nm"));
    	 tpa.setTransId(rs.getString("trans_id"));
      
      return tpa;
     }
     
    }
 
    @Bean
    public TPAItemProcessor processor() {
        return new TPAItemProcessor();
    }
    
    @Bean(destroyMethod="")
    public Step step1() {
    	  return stepBuilderFactory.get("chunkStep")
    		        .<TouchPointActor, TouchPointActor>chunk(10)
    		        .reader(reader())
    		        .processor(processor())
    		        .writer(writer())
    		        .build();
    }
    
    @Bean
    public Job testJob() {
     return jobBuilderFactory.get("testJob")
       .incrementer(new RunIdIncrementer())
       .listener(listener)
       .flow(step1())
       .end()
       .build();
    }

   

    @Bean
    public CustomItemWriter writer() {
    	System.out.println("writer.....");
     return new CustomItemWriter();
    }
   

 /** Job launcher and scheduler integration code..**/
    
    @Autowired
    private SimpleJobLauncher jobLauncher;
    
    @Bean
    public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository(jobRepository);
        return launcher;
    }
    
   // @Scheduled(cron = "*/50 * * * * *")
    @Scheduled(fixedRate = 60000)
   // @Scheduled(cron = "${scheduling.job.cron}")
  	public void perform() throws Exception {

    	
  		System.out.println("Job Started at :" + new Date());
  		
  		AppConstant.isReadComplete = false;

  		JobParameters param = new JobParametersBuilder().addString("TPA batch JobID", String.valueOf(System.currentTimeMillis()))
  				.toJobParameters();

  		JobExecution execution = jobLauncher.run(testJob(), param);

  		System.out.println("Job finished with status :" + execution.getStatus());
  	}
}