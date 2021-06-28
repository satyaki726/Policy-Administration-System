package com.cts.portal.service;

import com.cts.portal.model.ConsumerDetails;
import com.cts.portal.model.ConsumerRequest;
import com.cts.portal.model.UpdateConsumer;

public interface InsureityService {

	ConsumerDetails getConsumerDetails(ConsumerRequest consumerRequest);
	
	ConsumerDetails updateConsumerDetails(UpdateConsumer updateConsumer);

}
