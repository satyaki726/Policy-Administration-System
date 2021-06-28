package com.cts.portal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.common.exception.AuthorizationException;
import com.cts.common.exception.ConsumerNotFoundException;
import com.cts.common.exception.NotEligibleException;
import com.cts.common.model.ServiceResponse;
import com.cts.portal.model.ConsumerDetails;

@FeignClient(name="CONSUMER-MICROSERVICE",url="http://localhost:8100/consumerservice")
public interface Consumerclient {
	
	@PostMapping("/consumers")
	public ResponseEntity<ServiceResponse<ConsumerDetails>> createConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody ConsumerDetails consumerDetails) throws Exception;
	
	@PutMapping("/consumers/{consumer_id}")
	public ResponseEntity<ServiceResponse<ConsumerDetails>> updateConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@PathVariable Long consumer_id, @RequestBody ConsumerDetails consumerDetails)
			throws NotEligibleException,Exception;
	
	@DeleteMapping("/consumers/{cid}")
	public ResponseEntity<ConsumerDetails> deleteConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader, @PathVariable Long cid)
			throws ConsumerNotFoundException, AuthorizationException;
	
	@GetMapping("/getconsumers/{cid}")
	public ConsumerDetails viewConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader, @PathVariable Long cid)
			throws ConsumerNotFoundException, AuthorizationException;
	
	@GetMapping("/getallconsumers")
	public List<ConsumerDetails> viewAllConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException;
}
