package com.example.demo.batch.item.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.domain.FTDepositRequest;

public class AccountItemProcessor implements ItemProcessor<FTDepositRequest, FTDepositRequest> {

	@Override
	public FTDepositRequest process(FTDepositRequest item) throws Exception {
		item.setAccount("78534-781453669000212-21");
		return item;
	}

}
