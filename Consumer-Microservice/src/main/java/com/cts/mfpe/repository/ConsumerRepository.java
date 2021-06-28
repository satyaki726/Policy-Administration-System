package com.cts.mfpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.mfpe.model.ConsumerDetails;

@Repository
public interface ConsumerRepository extends JpaRepository<ConsumerDetails,Long> {

}
