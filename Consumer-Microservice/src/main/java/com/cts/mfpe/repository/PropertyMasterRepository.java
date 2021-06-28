package com.cts.mfpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.mfpe.model.BusinessMaster;
import com.cts.mfpe.model.PropertyMaster;

@Repository
public interface PropertyMasterRepository extends JpaRepository<PropertyMaster,Long> {
	PropertyMaster findByBuildingtypeAndPropertytype(String buildingtype, String propertytype);
}
