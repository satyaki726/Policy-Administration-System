package com.cts.portal.policymodel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerDetails {


	private Long id;
	private String name;
	private String dob;
	private String pandetails;
	private String email;
	private String phone;
	private String agentname;
	private Long agentid;
	private List<BusinessDetails> business;
}

