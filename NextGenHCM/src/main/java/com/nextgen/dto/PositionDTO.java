/* 
 * ===========================================================================
 * File Name PositionDTO.java
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
 * $Log: PositionDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

/**
 * This classs is used to carry the information for the position
 * 
 * @author umamaheswarar
 *
 */
public class PositionDTO implements Serializable {

	private static final long serialVersionUID = 7203588174401954066L;
	private Long id;
	private String positionName;
	private String positionCode;
	private BaseAppDTO organization;
	private String positionRequestReason;
	private BaseAppDTO jobPostingTitle;
	private String availabilityDate;
	private JobProfileDTO jobProfile;
	private TimeTypeDTO timeType;
	private BaseAppDTO location;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the positionName
	 */
	public String getPositionName() {
		return positionName;
	}
	/**
	 * @return the positionCode
	 */
	public String getPositionCode() {
		return positionCode;
	}
	/**
	 * @return the organization
	 */
	public BaseAppDTO getOrganization() {
		return organization;
	}
	/**
	 * @return the positionRequestReason
	 */
	public String getPositionRequestReason() {
		return positionRequestReason;
	}
	/**
	 * @return the jobPostingTitle
	 */
	public BaseAppDTO getJobPostingTitle() {
		return jobPostingTitle;
	}
	/**
	 * @return the availabilityDate
	 */
	public String getAvailabilityDate() {
		return availabilityDate;
	}
	/**
	 * @return the jobProfile
	 */
	public JobProfileDTO getJobProfile() {
		return jobProfile;
	}
	/**
	 * @return the timeType
	 */
	public TimeTypeDTO getTimeType() {
		return timeType;
	}
	/**
	 * @return the location
	 */
	public BaseAppDTO getLocation() {
		return location;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param positionName the positionName to set
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	/**
	 * @param positionCode the positionCode to set
	 */
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}
	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(BaseAppDTO organization) {
		this.organization = organization;
	}
	/**
	 * @param positionRequestReason the positionRequestReason to set
	 */
	public void setPositionRequestReason(String positionRequestReason) {
		this.positionRequestReason = positionRequestReason;
	}
	/**
	 * @param jobPostingTitle the jobPostingTitle to set
	 */
	public void setJobPostingTitle(BaseAppDTO jobPostingTitle) {
		this.jobPostingTitle = jobPostingTitle;
	}
	/**
	 * @param availabilityDate the availabilityDate to set
	 */
	public void setAvailabilityDate(String availabilityDate) {
		this.availabilityDate = availabilityDate;
	}
	/**
	 * @param jobProfile the jobProfile to set
	 */
	public void setJobProfile(JobProfileDTO jobProfile) {
		this.jobProfile = jobProfile;
	}
	/**
	 * @param timeType the timeType to set
	 */
	public void setTimeType(TimeTypeDTO timeType) {
		this.timeType = timeType;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(BaseAppDTO location) {
		this.location = location;
	}
	

}
