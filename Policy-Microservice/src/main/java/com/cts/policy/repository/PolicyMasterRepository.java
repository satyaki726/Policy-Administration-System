package com.cts.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.policy.model.PolicyMaster;

@Repository
public interface PolicyMasterRepository extends JpaRepository<PolicyMaster,Long>{
	public PolicyMaster findByBusinessValueAndPropertyValue(Long businessValue,Long propertyValue);
}
