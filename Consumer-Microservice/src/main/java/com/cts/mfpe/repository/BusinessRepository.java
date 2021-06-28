package com.cts.mfpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.mfpe.model.BusinessDetails;

public interface BusinessRepository extends JpaRepository<BusinessDetails,Long>{

}
