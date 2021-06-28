package com.cts.quotesmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.quotesmicroservice.models.QuotesMaster;

@Repository
public interface QuotesMasterRepository extends JpaRepository<QuotesMaster, Long> {

	QuotesMaster findByBusinessValueAndPropertyValueAndPropertyType(Long businessValue,Long propertyValue,String propertyType);
}
