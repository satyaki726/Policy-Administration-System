package com.cts.portal.policymodel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDetails {

	
	private Long id;
	private String propertytype;
	private String buildingsqft;
	private String buildingtype;
	private String buildingstoreys;
	private Long buildingage;
	private Long propertyvalue;
	private Long costoftheasset;
	private Long usefullifeoftheAsset;
	private Long salvagevalue;
	private ConsumerPolicy consumerPolicy;
}
