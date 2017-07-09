/* 
 * ===========================================================================
 * File Name Position.java
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
 * $Log: Position.java,v $
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
@Table(name = "position")
public class Position implements java.io.Serializable {

	private static final long serialVersionUID = -5377873949674092983L;
	private Long id;
	private String name;
	private String positionCode;
	private Organization organization;
	private String positionRequestReason;
	private JobTitle jobPostingTitle;
	private Date availabilityDate;
	private Date createDate;
	private JobProfile jobProfile;
	private TimeType timeType;
	private Location location;

	/**
	 * Default constructor to the class
	 * 
	 */
	public Position() {
		super();
	}

	/**
	 * Parameterized constructor to the class
	 * 
	 * @param id
	 * @param name
	 */
	public Position(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param name
	 * @param positionCode
	 * @param organization
	 * @param positionRequestReason
	 * @param jobPostingTitle
	 * @param availabilityDate
	 * @param jobProfile
	 */
	public Position(Long id, String name, String positionCode, Organization organization, String positionRequestReason,
			JobTitle jobPostingTitle, Date availabilityDate, JobProfile jobProfile, TimeType timeType,
			Location location) {
		super();
		this.id = id;
		this.name = name;
		this.positionCode = positionCode;
		this.organization = organization;
		this.positionRequestReason = positionRequestReason;
		this.jobPostingTitle = jobPostingTitle;
		this.availabilityDate = availabilityDate;
		this.jobProfile = jobProfile;
		this.timeType = timeType;
		this.location = location;
	}

	/**
	 * Identifier of the class
	 * 
	 * @return id id of the object from database
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	/**
	 * Setter function to set the id
	 * 
	 * @param id
	 *            id for the object.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter function to get the name
	 * 
	 * @return name name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Setter function to set the name field
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the positionCode
	 */
	@Column(name = "POSITION_CODE")
	public String getPositionCode() {
		return positionCode;
	}

	/**
	 * @return the organization
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZATION")
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * @return the positionRequestReason
	 */
	@Column(name = "REQUEST_REASON")
	public String getPositionRequestReason() {
		return positionRequestReason;
	}

	/**
	 * @return the jobPostingTitle
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_TITLE")
	public JobTitle getJobPostingTitle() {
		return jobPostingTitle;
	}

	/**
	 * @return the availabilityDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AVAILABILITY_DATE", length = 19)
	public Date getAvailabilityDate() {
		return availabilityDate;
	}

	/**
	 * @return the jobProfile
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_PROFILE")
	public JobProfile getJobProfile() {
		return jobProfile;
	}

	/**
	 * @param positionCode
	 *            the positionCode to set
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	/**
	 * @param organization
	 *            the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * @param positionRequestReason
	 *            the positionRequestReason to set
	 */
	public void setPositionRequestReason(String positionRequestReason) {
		this.positionRequestReason = positionRequestReason;
	}

	/**
	 * @param jobPostingTitle
	 *            the jobPostingTitle to set
	 */
	public void setJobPostingTitle(JobTitle jobPostingTitle) {
		this.jobPostingTitle = jobPostingTitle;
	}

	/**
	 * @param availabilityDate
	 *            the availabilityDate to set
	 */
	public void setAvailabilityDate(Date availabilityDate) {
		this.availabilityDate = availabilityDate;
	}

	/**
	 * @param jobProfile
	 *            the jobProfile to set
	 */
	public void setJobProfile(JobProfile jobProfile) {
		this.jobProfile = jobProfile;
	}

	/**
	 * @return the timeType
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIME_TYPE")
	public TimeType getTimeType() {
		return timeType;
	}

	/**
	 * @param timeType
	 *            the timeType to set
	 */
	public void setTimeType(TimeType timeType) {
		this.timeType = timeType;
	}

	/**
	 * @return the location
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION")
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
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
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
