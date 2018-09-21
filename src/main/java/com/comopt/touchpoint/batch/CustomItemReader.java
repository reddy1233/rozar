package com.comopt.touchpoint.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.comopt.touchpoint.model.TouchPointActor;

public class CustomItemReader implements ItemReader<TouchPointActor> {

	@Override
	public TouchPointActor read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	
}