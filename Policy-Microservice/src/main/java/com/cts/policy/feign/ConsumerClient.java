package com.cts.policy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.common.exception.AuthorizationException;
import com.cts.common.exception.ConsumerNotFoundException;
import com.cts.policy.model.ConsumerDetails;

@FeignClient(name = "Consumer-Microservice", url = "http://localhost:8100/consumerservice")
public interface ConsumerClient {

	@GetMapping("/getconsumers/{cid}")
	public ConsumerDetails viewConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader, @PathVariable Long cid)
			throws ConsumerNotFoundException, AuthorizationException;
}
