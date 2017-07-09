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
public class PayrollDTO implements Serializable {

	private static final long serialVersionUID = 7106027660544294908L;
	private Long employeeId;
	private String endDate;
	private Long id;
	private BaseAppDTO inputType;
	private Double inputValue;
	private String payComponentCode;
	private String payrollInputEventId;
	private BaseAppDTO runType;
	private String startDate;

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the inputType
	 */
	public BaseAppDTO getInputType() {
		return inputType;
	}

	/**
	 * @return the inputValue
	 */
	public Double getInputValue() {
		return inputValue;
	}

	/**
	 * @return the payComponentCode
	 */
	public String getPayComponentCode() {
		return payComponentCode;
	}

	/**
	 * @return the payrollInputEventId
	 */
	public String getPayrollInputEventId() {
		return payrollInputEventId;
	}

	/**
	 * @return the runType
	 */
	public BaseAppDTO getRunType() {
		return runType;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param inputType
	 *            the inputType to set
	 */
	public void setInputType(BaseAppDTO inputType) {
		this.inputType = inputType;
	}

	/**
	 * @param inputValue
	 *            the inputValue to set
	 */
	public void setInputValue(Double inputValue) {
		this.inputValue = inputValue;
	}

	/**
	 * @param payComponentCode
	 *            the payComponentCode to set
	 */
	public void setPayComponentCode(String payComponentCode) {
		this.payComponentCode = payComponentCode;
	}

	/**
	 * @param payrollInputEventId
	 *            the payrollInputEventId to set
	 */
	public void setPayrollInputEventId(String payrollInputEventId) {
		this.payrollInputEventId = payrollInputEventId;
	}

	/**
	 * @param runType
	 *            the runType to set
	 */
	public void setRunType(BaseAppDTO runType) {
		this.runType = runType;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
