package com.cts.mfpe.service;

import java.util.List;

import com.cts.common.exception.ConsumerNotFoundException;
import com.cts.mfpe.model.ConsumerDetails;

public interface ConsumerService {
	
	ConsumerDetails saveConsumer(ConsumerDetails consumerDetails);

	void deleteConsumer(Long cid);

	ConsumerDetails findConsumerById(Long cid) throws ConsumerNotFoundException;

	List<ConsumerDetails> findAllConsumers();

	Boolean checkEligibility(ConsumerDetails consumerDetails) throws Exception;
	
	public Long calBusinessValue(Long businessturnover, Long capitalinvested);
	
	public Long calPropertyValue(Long costoftheasset, Long salvagevalue, Long usefullifeoftheAsset);
}
