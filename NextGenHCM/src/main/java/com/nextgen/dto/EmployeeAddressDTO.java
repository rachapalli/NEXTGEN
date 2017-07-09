/* 
 * ===========================================================================
 * File Name EmployeeAddressDTO.java
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
 * $Log: EmployeeAddressDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

/**
 * This class is used to carry the information for the employee address
 * 
 * @author umamaheswarar
 *
 */
public class EmployeeAddressDTO implements Serializable {

	private static final long serialVersionUID = 7106027660544294908L;
	private Long employeeId;
	private AddressBaseDTO address;

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @return the address
	 */
	public AddressBaseDTO getAddress() {
		return address;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(AddressBaseDTO address) {
		this.address = address;
	}


}
