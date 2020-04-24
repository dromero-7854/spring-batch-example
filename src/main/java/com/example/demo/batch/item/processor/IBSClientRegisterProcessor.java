package com.example.demo.batch.item.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.domain.FTDepositRequest;

public class IBSClientRegisterProcessor implements ItemProcessor<FTDepositRequest, FTDepositRequest> {

	@Override
	public FTDepositRequest process(FTDepositRequest item) throws Exception {
		item.setClientID("7834264-89");
		item.setState("registered_customer");
		return item;
	}

}
