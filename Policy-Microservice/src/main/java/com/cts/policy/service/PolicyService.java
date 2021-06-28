package com.cts.policy.service;

import java.util.List;

import com.cts.common.exception.ConsumerNotFoundException;
import com.cts.common.exception.PolicyNotFoundException;
import com.cts.policy.model.ConsumerDetails;
import com.cts.policy.model.ConsumerPolicy;
import com.cts.policy.model.PolicyMaster;

public interface PolicyService {

	Boolean checkPolicy(ConsumerDetails consumerDetails) throws Exception;

	ConsumerDetails issuePolicy(ConsumerDetails consumerDetails);

	PolicyMaster savePolicy(PolicyMaster policyMaster);

	List<ConsumerPolicy> viewPolicy(Long cid, Long pid) throws ConsumerNotFoundException,PolicyNotFoundException;

}
