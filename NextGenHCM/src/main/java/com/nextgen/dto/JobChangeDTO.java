/* 
 * ===========================================================================
 * File Name JobChangeDTO.java
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
 * $Log: JobChangeDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

/**
 * This classs is used to carry the information for the job chnage for the
 * employee
 * 
 * @author umamaheswarar
 *
 */
public class JobChangeDTO implements Serializable {

	private static final long serialVersionUID = 7203588174401954066L;
	private Long id;
	private BaseAppDTO employee;
	private BaseAppDTO proposedManager;
	private String effectiveDate;
	private JobReasonDTO reason;
	private BaseAppDTO proposedLocation;
	private String jobChangeEventId;
	
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
	 * @return the proposedManager
	 */
	public BaseAppDTO getProposedManager() {
		return proposedManager;
	}
	/**
	 * @return the effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * @return the reason
	 */
	public JobReasonDTO getReason() {
		return reason;
	}
	/**
	 * @return the jobChangeEventId
	 */
	public String getJobChangeEventId() {
		return jobChangeEventId;
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
	public void setEmployee(BaseAppDTO employee) {
		this.employee = employee;
	}
	/**
	 * @param proposedManager the proposedManager to set
	 */
	public void setProposedManager(BaseAppDTO proposedManager) {
		this.proposedManager = proposedManager;
	}
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(JobReasonDTO reason) {
		this.reason = reason;
	}
	/**
	 * @param jobChangeEventId the jobChangeEventId to set
	 */
	public void setJobChangeEventId(String jobChangeEventId) {
		this.jobChangeEventId = jobChangeEventId;
	}
	/**
	 * @return the proposedLocation
	 */
	public BaseAppDTO getProposedLocation() {
		return proposedLocation;
	}
	/**
	 * @param proposedLocation the proposedLocation to set
	 */
	public void setProposedLocation(BaseAppDTO proposedLocation) {
		this.proposedLocation = proposedLocation;
	}

}
