package com.cts.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.policy.model.ConsumerDetails;

@Repository
public interface ConsumerRepository extends JpaRepository<ConsumerDetails,Long> {

}
