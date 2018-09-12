package com.comopt.touchpoint.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.comopt.touchpoint.AppConstant;
import com.comopt.touchpoint.model.TouchPointActor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomItemWriter implements ItemWriter<TouchPointActor> {
	
	private static final Logger log = LoggerFactory.getLogger(CustomItemWriter.class);
	
	@Autowired
    private JmsTemplate jmsTemplate;


	@Override
	public void write(List<? extends TouchPointActor> data) throws Exception {
		// TODO Auto-generated method stub
		AppConstant.isReadComplete = true;
		//ObjectMapper mapper = new ObjectMapper();
    	String json;
		try {
			//json = mapper.writeValueAsString(data);
			jmsTemplate.convertAndSend("DEV.QUEUE.1", data);
		    
			log.info("Touch Point JSON Strings send to queue "+data);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	

	
}
