package com.cts.policy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.common.exception.AuthorizationException;
import com.cts.common.exception.ConsumerNotFoundException;
import com.cts.common.exception.NotEligibleException;
import com.cts.common.exception.PolicyNotFoundException;
import com.cts.policy.feign.AuthClient;
import com.cts.policy.feign.ConsumerClient;
import com.cts.policy.model.ConsumerDetails;
import com.cts.policy.model.ConsumerPolicy;
import com.cts.policy.model.PolicyMaster;
import com.cts.policy.request.ConsumerPolicyRequest;
import com.cts.policy.service.PolicyService;

@RestController
public class PolicyController {

	@Autowired
	ConsumerClient consumerClient;

	@Autowired
	AuthClient authClient;

	@Autowired
	PolicyService policyService;
	
	@PostMapping("/createPolicy")
	public ResponseEntity<PolicyMaster> createPolicy(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody PolicyMaster policyMaster) throws AuthorizationException{
		if (authClient.authorizeTheRequest(requestTokenHeader)) {
			PolicyMaster pol = policyService.savePolicy(policyMaster);
			return new ResponseEntity<PolicyMaster>(pol,HttpStatus.CREATED);
		}else {
			throw new AuthorizationException("Not allowed");
		}
	
	}

	@PostMapping("/issuePolicy")
	public ConsumerDetails issuePolicy(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody ConsumerPolicyRequest consumerPolicyRequest) throws Exception {

		if (authClient.authorizeTheRequest(requestTokenHeader)) {
			Long cid = consumerPolicyRequest.getConsumerid();
			ConsumerDetails consumerDetails = consumerClient.viewConsumer(requestTokenHeader, cid);
			if (!policyService.checkPolicy(consumerDetails)) {
				throw new NotEligibleException("Not Eligible");
			}
			ConsumerDetails con = policyService.issuePolicy(consumerDetails);
			return con;
		} else {
			throw new AuthorizationException("Not allowed");
		}
	}
	
	@GetMapping("/viewPolicy/{cid}/{pid}")
	public List<ConsumerPolicy> viewPolicyCon(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader, @PathVariable Long cid,
			@PathVariable Long pid) throws ConsumerNotFoundException, AuthorizationException, PolicyNotFoundException {
		
		if(authClient.authorizeTheRequest(requestTokenHeader)) {
			List<ConsumerPolicy> policyDetails = policyService.viewPolicy(cid,pid);
			if(policyDetails == null) {
				throw new PolicyNotFoundException("Notfound");
			}
			return policyDetails;
		}else {
			throw new AuthorizationException("Not allowed");
		}
	}
}
