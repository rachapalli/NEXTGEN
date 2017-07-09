/* 
 * ===========================================================================
 * File Name AddressBaseDTO.java
 * 
 * Created on Aug 10, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: AddressBaseDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

/**
 * This classs is used to carry the basic address details.
 * 
 * @author umamaheswarar
 *
 */
public class AddressBaseDTO implements Serializable{

	private static final long serialVersionUID = 4708628014489741094L;
	private String addressLineOne;
	private String addressLineTwo;
	private BaseAppDTO city;
	private BaseAppDTO country;
	private String effectiveDate;
	private Long id;
	private BaseAppDTO state;
	private BaseAppDTO type;
	private BaseAppDTO usage;
	private BaseAppDTO visibility;
	private String addressChangeEventId;
	
	private String zip;
	/**
	 * @return the addressLineOne
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}
	/**
	 * @return the addressLineTwo
	 */
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	/**
	 * @return the city
	 */
	public BaseAppDTO getCity() {
		return city;
	}
	/**
	 * @return the country
	 */
	public BaseAppDTO getCountry() {
		return country;
	}
	/**
	 * @return the effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the state
	 */
	public BaseAppDTO getState() {
		return state;
	}
	/**
	 * @return the type
	 */
	public BaseAppDTO getType() {
		return type;
	}
	/**
	 * @return the usage
	 */
	public BaseAppDTO getUsage() {
		return usage;
	}
	/**
	 * @return the visibility
	 */
	public BaseAppDTO getVisibility() {
		return visibility;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param addressLineOne the addressLineOne to set
	 */
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	/**
	 * @param addressLineTwo the addressLineTwo to set
	 */
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(BaseAppDTO city) {
		this.city = city;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(BaseAppDTO country) {
		this.country = country;
	}
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(BaseAppDTO state) {
		this.state = state;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(BaseAppDTO type) {
		this.type = type;
	}
	/**
	 * @param usage the usage to set
	 */
	public void setUsage(BaseAppDTO usage) {
		this.usage = usage;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(BaseAppDTO visibility) {
		this.visibility = visibility;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the addressChangeEventId
	 */
	public String getAddressChangeEventId() {
		return addressChangeEventId;
	}
	/**
	 * @param addressChangeEventId the addressChangeEventId to set
	 */
	public void setAddressChangeEventId(String addressChangeEventId) {
		this.addressChangeEventId = addressChangeEventId;
	}

}
