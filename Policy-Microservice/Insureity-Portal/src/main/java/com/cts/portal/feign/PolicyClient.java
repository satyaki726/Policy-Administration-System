package com.cts.portal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.common.exception.AuthorizationException;
import com.cts.common.exception.ConsumerNotFoundException;
import com.cts.common.exception.PolicyNotFoundException;
import com.cts.portal.policymodel.ConsumerPolicy;
import com.cts.portal.policymodel.ConsumerDetails;
import com.cts.portal.policymodel.ConsumerPolicyRequest;
import com.cts.portal.policymodel.PolicyMaster;

@FeignClient(name = "Policy-Microservice", url = "http://localhost:8200/policyservice")
public interface PolicyClient {

	@PostMapping("/createPolicy")
	public ResponseEntity<PolicyMaster> createPolicy(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody PolicyMaster policyMaster) throws AuthorizationException;

	@PostMapping("/issuePolicy")
	public ConsumerDetails issuePolicy(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@RequestBody ConsumerPolicyRequest consumerPolicyRequest) throws Exception;

	@GetMapping("/viewPolicy/{cid}/{pid}")
	public List<ConsumerPolicy> viewPolicyCon(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader, @PathVariable Long cid,
			@PathVariable Long pid) throws ConsumerNotFoundException, AuthorizationException, PolicyNotFoundException;
}
