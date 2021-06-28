package com.cts.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateConsumer {
	
	private Long id;
	private String name;
	private String dob;      
	private String pandetails;
	private String email;
	private String phone;
	private String agentname;
	private Long agentid;
	private String businesscategory;
	private String businesstype;
	private Long businessturnover;
	private Long capitalinvested;
	private Long totalemployees;
	private Long businessvalue;
	private Long businessage;
	private String propertytype;
	private String buildingsqft;
	private String buildingtype;
	private String buildingstoreys;
	private Long buildingage;
	private Long propertyvalue;
	private Long costoftheasset;
	private Long usefullifeoftheAsset;
	private Long salvagevalue;
}
