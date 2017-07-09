/* 
 * ===========================================================================
 * File Name ContactDataDTO.java
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
 * $Log: ContactDataDTO.java,v $
 * ===========================================================================
 */
package com.nextgen.dto;

/**
 * This classs is used to carry the information for the contact data
 * 
 * @author umamaheswarar
 *
 */
public class ContactDataDTO {

	private Long id;
	private BaseAppDTO employee;
	private String effectiveDate;
	private BaseAppDTO addressType; // ( possible values - Home or Work)
	private BaseAppDTO usage; // ( possible values –Mailing, Shipping,
								// Permanat,Paycheck)
	private AddressBaseDTO address;
	private BaseAppDTO visibilty;// (possible values – Public , Private)

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the employee
	 */
	public BaseAppDTO getEmployee() {
		return employee;
	}

	/**
	 * @return the effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @return the addressType
	 */
	public BaseAppDTO getAddressType() {
		return addressType;
	}

	/**
	 * @return the usage
	 */
	public BaseAppDTO getUsage() {
		return usage;
	}

	/**
	 * @return the address
	 */
	public AddressBaseDTO getAddress() {
		return address;
	}

	/**
	 * @return the visibilty
	 */
	public BaseAppDTO getVisibilty() {
		return visibilty;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(BaseAppDTO employee) {
		this.employee = employee;
	}

	/**
	 * @param effectiveDate
	 *            the effectiveDate to set
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @param addressType
	 *            the addressType to set
	 */
	public void setAddressType(BaseAppDTO addressType) {
		this.addressType = addressType;
	}

	/**
	 * @param usage
	 *            the usage to set
	 */
	public void setUsage(BaseAppDTO usage) {
		this.usage = usage;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(AddressBaseDTO address) {
		this.address = address;
	}

	/**
	 * @param visibilty
	 *            the visibilty to set
	 */
	public void setVisibilty(BaseAppDTO visibilty) {
		this.visibilty = visibilty;
	}

}
