package com.cts.mfpe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.common.exception.AuthorizationException;
import com.cts.common.exception.ConsumerNotFoundException;
import com.cts.common.exception.NotEligibleException;
import com.cts.common.handler.ResponseHandlers;
import com.cts.common.model.ServiceResponse;
import com.cts.mfpe.feign.AuthClient;
import com.cts.mfpe.model.BusinessDetails;
import com.cts.mfpe.model.ConsumerDetails;
import com.cts.mfpe.model.PropertyDetails;
import com.cts.mfpe.service.ConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;

	@Autowired
	private AuthClient authClient;

	@PostMapping("/consumers")
	public ResponseEntity<ServiceResponse<ConsumerDetails>> createConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody ConsumerDetails consumerDetails) throws Exception {
		if (authClient.authorizeTheRequest(requestTokenHeader)) {
			if (!consumerService.checkEligibility(consumerDetails)) {
				throw new NotEligibleException("Not Eligible");
			}
			ConsumerDetails consumer = consumerService.saveConsumer(consumerDetails);
			return new ResponseHandlers<ConsumerDetails>().defaultResponse(consumer, "Consumer Added",
					HttpStatus.CREATED);
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}

	@PutMapping("/consumers/{consumer_id}")
	public ResponseEntity<ServiceResponse<ConsumerDetails>> updateConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@PathVariable Long consumer_id, @RequestBody ConsumerDetails consumerDetails)
			throws NotEligibleException, Exception {
		if (authClient.authorizeTheRequest(requestTokenHeader)) {
			if (!consumerService.checkEligibility(consumerDetails)) {
				throw new NotEligibleException("Not Eligible");
			}
			ConsumerDetails consumer = consumerService.findConsumerById(consumer_id);

			consumer.setAgentid(consumerDetails.getAgentid());
			consumer.setAgentname(consumerDetails.getAgentname());
			consumer.setDob(consumerDetails.getDob());
			consumer.setEmail(consumerDetails.getEmail());
			consumer.setName(consumerDetails.getName());
			consumer.setPandetails(consumerDetails.getPandetails());
			consumer.setPhone(consumerDetails.getPhone());

			List<BusinessDetails> businessDetails = consumer.getBusiness();
			List<BusinessDetails> business = consumerDetails.getBusiness();
			List<BusinessDetails> b2 = new ArrayList<>();
			for (int i = 0; i < business.size(); i++) {
				BusinessDetails b1 = businessDetails.get(i);
				BusinessDetails b = business.get(i);
				Long businessVal = consumerService.calBusinessValue(b.getBusinessturnover(), b.getCapitalinvested());
				b.setBusinessvalue(businessVal);
				b.setId(b1.getId());
				List<PropertyDetails> propertyDetails = b1.getProperty();
				List<PropertyDetails> property = b.getProperty();
				List<PropertyDetails> p2 = new ArrayList<>();
				for (int j = 0; j < property.size(); j++) {
					PropertyDetails p1 = propertyDetails.get(j);
					PropertyDetails p = property.get(j);
					Long propertyVal = consumerService.calPropertyValue(p.getCostoftheasset(), p.getSalvagevalue(),
							p.getUsefullifeoftheAsset());
					p.setPropertyvalue(propertyVal);
					p.setId(p1.getId());
					p2.add(p);
				}
				b2.add(b);
			}

			consumer.setBusiness(b2);
			ConsumerDetails con = consumerService.saveConsumer(consumer);

			return new ResponseHandlers<ConsumerDetails>().defaultResponse(con, "Consumer Updtaed", HttpStatus.OK);
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}

	@DeleteMapping("/consumers/{cid}")
	public ResponseEntity<ConsumerDetails> deleteConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader, @PathVariable Long cid)
			throws ConsumerNotFoundException, AuthorizationException {
		if (authClient.authorizeTheRequest(requestTokenHeader)) {
			ConsumerDetails con = consumerService.findConsumerById(cid);
			consumerService.deleteConsumer(con.getId());
			return new ResponseEntity<ConsumerDetails>(con, HttpStatus.OK);
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}

	@GetMapping("/getconsumers/{cid}")
	public ConsumerDetails viewConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader, @PathVariable Long cid)
			throws ConsumerNotFoundException, AuthorizationException {
		if (authClient.authorizeTheRequest(requestTokenHeader)) {
			ConsumerDetails con = consumerService.findConsumerById(cid);
			return con;
		}else {
			throw new AuthorizationException("Not allowed");
		}

	}

	@GetMapping("/getallconsumers")
	public List<ConsumerDetails> viewAllConsumer(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
			throws AuthorizationException {
		if (authClient.authorizeTheRequest(requestTokenHeader)) {
			List<ConsumerDetails> list = consumerService.findAllConsumers();
			return list;
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}
}