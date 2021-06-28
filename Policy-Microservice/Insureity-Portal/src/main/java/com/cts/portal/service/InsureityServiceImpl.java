package com.cts.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.portal.model.BusinessDetails;
import com.cts.portal.model.ConsumerDetails;
import com.cts.portal.model.ConsumerRequest;
import com.cts.portal.model.PropertyDetails;
import com.cts.portal.model.UpdateConsumer;

@Service
public class InsureityServiceImpl implements InsureityService {

	@Override
	public ConsumerDetails getConsumerDetails(ConsumerRequest consumerRequest) {
		// TODO Auto-generated method stub
		ConsumerDetails con = new ConsumerDetails();
		con.setAgentid(consumerRequest.getAgentid());
		con.setAgentname(consumerRequest.getAgentname());
		con.setDob(consumerRequest.getDob());
		con.setEmail(consumerRequest.getEmail());
		con.setPandetails(consumerRequest.getPandetails());
		con.setPhone(consumerRequest.getPhone());
		con.setName(consumerRequest.getName());
		
		List<BusinessDetails> list1 = new ArrayList<>();
		BusinessDetails bon = new BusinessDetails();
		bon.setBusinessage(consumerRequest.getBusinessage());
		bon.setBusinesscategory(consumerRequest.getBusinesscategory());
		bon.setBusinessturnover(consumerRequest.getBusinessturnover());
		bon.setBusinesstype(consumerRequest.getBusinesstype());
		bon.setCapitalinvested(consumerRequest.getCapitalinvested());
		bon.setTotalemployees(consumerRequest.getTotalemployees());

		List<PropertyDetails> list = new ArrayList<>(); 
		PropertyDetails por = new PropertyDetails();
		por.setPropertytype(consumerRequest.getPropertytype());
		por.setBuildingsqft(consumerRequest.getBuildingsqft());
		por.setBuildingtype(consumerRequest.getBuildingtype());
		por.setBuildingstoreys(consumerRequest.getBuildingstoreys());
		por.setBuildingage(consumerRequest.getBuildingage());
		por.setCostoftheasset(consumerRequest.getCostoftheasset());
		por.setUsefullifeoftheAsset(consumerRequest.getUsefullifeoftheAsset());
		por.setSalvagevalue(consumerRequest.getSalvagevalue());
		
		list.add(por);
		bon.setProperty(list);
		
		list1.add(bon);
		con.setBusiness(list1);
		
		return con;
	}

	@Override
	public ConsumerDetails updateConsumerDetails(UpdateConsumer updateConsumer) {
		// TODO Auto-generated method stub
		ConsumerDetails con = new ConsumerDetails();
		con.setId(updateConsumer.getId());
		con.setAgentid(updateConsumer.getAgentid());
		con.setAgentname(updateConsumer.getAgentname());
		con.setDob(updateConsumer.getDob());
		con.setEmail(updateConsumer.getEmail());
		con.setPandetails(updateConsumer.getPandetails());
		con.setPhone(updateConsumer.getPhone());
		con.setName(updateConsumer.getName());
		
		List<BusinessDetails> list1 = new ArrayList<>();
		BusinessDetails bon = new BusinessDetails();
		bon.setBusinessage(updateConsumer.getBusinessage());
		bon.setBusinesscategory(updateConsumer.getBusinesscategory());
		bon.setBusinessturnover(updateConsumer.getBusinessturnover());
		bon.setBusinesstype(updateConsumer.getBusinesstype());
		bon.setCapitalinvested(updateConsumer.getCapitalinvested());
		bon.setTotalemployees(updateConsumer.getTotalemployees());

		List<PropertyDetails> list = new ArrayList<>(); 
		PropertyDetails por = new PropertyDetails();
		por.setPropertytype(updateConsumer.getPropertytype());
		por.setBuildingsqft(updateConsumer.getBuildingsqft());
		por.setBuildingtype(updateConsumer.getBuildingtype());
		por.setBuildingstoreys(updateConsumer.getBuildingstoreys());
		por.setBuildingage(updateConsumer.getBuildingage());
		por.setCostoftheasset(updateConsumer.getCostoftheasset());
		por.setUsefullifeoftheAsset(updateConsumer.getUsefullifeoftheAsset());
		por.setSalvagevalue(updateConsumer.getSalvagevalue());
		
		list.add(por);
		bon.setProperty(list);
		
		list1.add(bon);
		con.setBusiness(list1);
		
		return con;
	}
}
