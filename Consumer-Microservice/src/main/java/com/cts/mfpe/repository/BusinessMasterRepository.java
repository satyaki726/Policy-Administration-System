package com.cts.mfpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.mfpe.model.BusinessMaster;

public interface BusinessMasterRepository extends JpaRepository<BusinessMaster,Long> {
	BusinessMaster findByBusinesscategoryAndBusinesstype(String businesscategory, String businesstype);
}
