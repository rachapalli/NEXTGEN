/* 
 * ===========================================================================
 * File Name TimeOffDTO.java
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
 * $Log: TimeOffDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

/**
 * This classs is used to carry the information for the time off for the
 * emplotyee
 * 
 * @author umamaheswarar
 *
 */
public class TimeOffDTO implements Serializable {

	private static final long serialVersionUID = 7203588174401954066L;
	private Long id;
	private BaseAppDTO employee;
	private String fromDate;
	private String toDate;
	private BaseAppDTO timeOffType;
	private Long dailyQuantity;
	private String reason;
	private String timeOffEventId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * @return the timeOffType
	 */
	public BaseAppDTO getTimeOffType() {
		return timeOffType;
	}

	/**
	 * @return the dailyQuantity
	 */
	public Long getDailyQuantity() {
		return dailyQuantity;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param fromDate
	 *            the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * @param timeOffType
	 *            the timeOffType to set
	 */
	public void setTimeOffType(BaseAppDTO timeOffType) {
		this.timeOffType = timeOffType;
	}

	/**
	 * @param dailyQuantity
	 *            the dailyQuantity to set
	 */
	public void setDailyQuantity(Long dailyQuantity) {
		this.dailyQuantity = dailyQuantity;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the employee
	 */
	public BaseAppDTO getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(BaseAppDTO employee) {
		this.employee = employee;
	}

	/**
	 * @return the timeOffEventId
	 */
	public String getTimeOffEventId() {
		return timeOffEventId;
	}

	/**
	 * @param timeOffEventId
	 *            the timeOffEventId to set
	 */
	public void setTimeOffEventId(String timeOffEventId) {
		this.timeOffEventId = timeOffEventId;
	}

}
