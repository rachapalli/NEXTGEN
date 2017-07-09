/* 
 * ===========================================================================
 * File Name EmployeePayroll.java
 * 
 * Created on Jul 22, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: EmployeePayroll.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payroll")
public class EmployeePayroll implements java.io.Serializable {

	private static final long serialVersionUID = -1107993320150451752L;
	private Date createDate;
	private Employee employee;
	private Date endDate;
	private Long id;
	private PayrollInputType inputType;
	private Double inputValue;
	private String payComponentCode;
	private String payrollInputEventId;
	private PayrollRunType runType;
	private Date startDate;

	/**
	 * @return the createDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 19)
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @return the employee
	 */
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE")
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @return the endDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", length = 19)
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	/**
	 * @return the inputType
	 */
	@ManyToOne
	@JoinColumn(name = "INPUT_TYPE")
	public PayrollInputType getInputType() {
		return inputType;
	}

	/**
	 * @return the inputValue
	 */
	@Column(name = "INPUT_VALUE")
	public Double getInputValue() {
		return inputValue;
	}

	/**
	 * @return the payComponentCode
	 */
	@Column(name = "PAY_COMPONENT_CODE")
	public String getPayComponentCode() {
		return payComponentCode;
	}

	/**
	 * @return the payrollInputEventId
	 */
	@Column(name = "INPUT_EVENT_ID")
	public String getPayrollInputEventId() {
		return payrollInputEventId;
	}

	/**
	 * @return the runType
	 */
	@ManyToOne
	@JoinColumn(name = "RUN_TYPE")
	public PayrollRunType getRunType() {
		return runType;
	}

	/**
	 * @return the startDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", length = 19)
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
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
	public void setInputType(PayrollInputType inputType) {
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
	public void setRunType(PayrollRunType runType) {
		this.runType = runType;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
