/* 
 * ===========================================================================
 * File Name JobChangeDetail.java
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
 * $Log: JobChangeDetail.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "job_change_detail")
public class JobChangeDetail implements java.io.Serializable {

	private static final long serialVersionUID = -5377873949674092983L;
	private Date changeDate;
	private Date effectiveDate;
	private Employee employee;
	private Long id;
	private String jobChangeEventId;
	private Location proposedLocation;
	private Employee proposedManager;
	private JobChangeReason reason;

	/**
	 * @return the changeDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CHANGE_DATE", length = 19)
	public Date getChangeDate() {
		return changeDate;
	}

	/**
	 * @return the effectiveDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFFECTIVE_DATE", length = 19)
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @return the employee
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE")
	public Employee getEmployee() {
		return employee;
	}

	/**Identifier of the class
	 * 
	 * @return id 							id of the object from database
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	/**
	 * @return the jobChangeEventId
	 */
	@Column(name="JOB_CHANGE_EVENT_ID")
	public String getJobChangeEventId() {
		return jobChangeEventId;
	}

	/**
	 * @return the proposedLocation
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROPOSED_LOCATION")
	public Location getProposedLocation() {
		return proposedLocation;
	}

	/**
	 * @return the proposedManager
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROPOSED_MANAGER")
	public Employee getProposedManager() {
		return proposedManager;
	}

	/**
	 * @return the reason
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REASON")
	public JobChangeReason getReason() {
		return reason;
	}

	/**
	 * @param changeDate the changeDate to set
	 */
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**Setter function to set the id 
	 * 
	 * @param id							id for the object.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param jobChangeEventId the jobChangeEventId to set
	 */
	public void setJobChangeEventId(String jobChangeEventId) {
		this.jobChangeEventId = jobChangeEventId;
	}

	/**
	 * @param proposedLocation the proposedLocation to set
	 */
	public void setProposedLocation(Location proposedLocation) {
		this.proposedLocation = proposedLocation;
	}

	/**
	 * @param proposedManager the proposedManager to set
	 */
	public void setProposedManager(Employee proposedManager) {
		this.proposedManager = proposedManager;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(JobChangeReason reason) {
		this.reason = reason;
	}

}
