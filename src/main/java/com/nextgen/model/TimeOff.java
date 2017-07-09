/* 
 * ===========================================================================
 * File Name TimeOff.java
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
 * $Log: TimeOff.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "time_off")
public class TimeOff implements java.io.Serializable {

	private static final long serialVersionUID = -5377873949674092983L;
	private Long id;
	private Employee employee;
	private TimeOffType timeOffType;
	private Date createDate;
	private Date fromDate;
	private Date toDate;
	private String reason;
	private Long dailyQuantity;
	private String timeOffEventId;

	/**Identifier of the class
	 * 
	 * @return id 							id of the object from database
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	/**
	 * @return the employee
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE")
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @return the timeOffType
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIME_OFF_TYPE")
	public TimeOffType getTimeOffType() {
		return timeOffType;
	}

	/**
	 * @return the createDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 19)
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @return the fromDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FROM_DATE", length = 19)
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @return the toDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TO_DATE", length = 19)
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @return the reason
	 */
	@Column(name="REASON")
	public String getReason() {
		return reason;
	}

	/**
	 * @return the dailyQuantity
	 */
	@Column(name="DAILY_QUANTITY")
	public Long getDailyQuantity() {
		return dailyQuantity;
	}

	/**
	 * @return the timeOffEventId
	 */
	@Column(name="TIME_OFF_EVENT_ID")
	public String getTimeOffEventId() {
		return timeOffEventId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @param timeOffType the timeOffType to set
	 */
	public void setTimeOffType(TimeOffType timeOffType) {
		this.timeOffType = timeOffType;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @param dailyQuantity the dailyQuantity to set
	 */
	public void setDailyQuantity(Long dailyQuantity) {
		this.dailyQuantity = dailyQuantity;
	}

	/**
	 * @param timeOffEventId the timeOffEventId to set
	 */
	public void setTimeOffEventId(String timeOffEventId) {
		this.timeOffEventId = timeOffEventId;
	}

}
