package com.comopt.touchpoint.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.comopt.touchpoint.AppConstant;
import com.comopt.touchpoint.model.TouchPointActor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomItemWriter implements ItemWriter<TouchPointActor> {
	
	private static final Logger log = LoggerFactory.getLogger(CustomItemWriter.class);
	
	


	@Override
	public void write(List<? extends TouchPointActor> arg0) throws Exception {
		// TODO Auto-generated method stub
		AppConstant.isReadComplete = true;
		ObjectMapper mapper = new ObjectMapper();
    	String json;
		try {
			json = mapper.writeValueAsString(arg0);
			log.info("Touch Point JSON String "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	
}
