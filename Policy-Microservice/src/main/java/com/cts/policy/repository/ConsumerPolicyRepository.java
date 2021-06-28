package com.cts.policy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.policy.model.ConsumerPolicy;

@Repository
public interface ConsumerPolicyRepository extends JpaRepository<ConsumerPolicy,Long> {
	public Optional<ConsumerPolicy> findByPid(Long pid);
}
