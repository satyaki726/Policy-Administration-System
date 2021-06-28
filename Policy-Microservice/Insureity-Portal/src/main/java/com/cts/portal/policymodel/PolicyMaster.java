package com.cts.portal.policymodel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyMaster {
	
	private Long id;
	private String property_type;
	private String consumer_type;
	private String assured_sum;
	private String tenure;
	private Long businessValue;
	private Long propertyValue;
	private String base_location;
	private String type;

}
