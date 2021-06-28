package com.cts.portal.model;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDetails {
	
	private Long id;
	private String businesscategory;
	private String businesstype;
	private Long businessturnover;
	private Long capitalinvested;
	private Long totalemployees;
	private Long businessvalue;
	private Long businessage;
	private List<PropertyDetails> property;
}
