/* 
 * ===========================================================================
 * File Name ContactDTO.java
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
 * $Log: ContactDTO.java,v $
 * ===========================================================================
 */
/**
* Class Information
* @author vikashk3 - Chetu
* @version 1.0 - Aug 10, 2016
*/
package com.nextgen.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This classs is used to carry the information for the contact
 * 
 * @author umamaheswarar
 *
 */
public class ContactDTO {

    private long userId;
    @JsonInclude(Include.NON_NULL)
    private String authorities;
    @JsonInclude(Include.NON_NULL)
    private Long companyId;
    @JsonInclude(Include.NON_NULL)
    private String companyName;
    @JsonInclude(Include.NON_NULL)
    private String designation;
    private Long designationId;
    @JsonInclude(Include.NON_NULL)
    private String dob;
    private String email;
    private String firstName;
    private String lastName;
    @JsonInclude(Include.NON_NULL)
    private String insuranceNumber;
    @JsonInclude(Include.NON_NULL)
    private String password;
    private String cellPhone;
    private String eveningTimePhone;
    private String dayTimePhone;
    private Long reportingManagerId;
    private String reportingManager;
    @JsonInclude(Include.NON_NULL)
    private Long roleId;
    @JsonInclude(Include.NON_NULL)
    private String token;

    /**
     * @return userId of long Type
     */
    public long getUserId() {
	return userId;
    }

    /**
     * @param long
     *            type set into userId
     */
    public void setUserId(long userId) {
	this.userId = userId;
    }

    /**
     * @return authorities of String Type
     */
    public String getAuthorities() {
	return authorities;
    }

    /**
     * @param String
     *            type set into authorities
     */
    public void setAuthorities(String authorities) {
	this.authorities = authorities;
    }

    /**
     * @return companyId of Long Type
     */
    public Long getCompanyId() {
	return companyId;
    }

    /**
     * @param Long
     *            type set into companyId
     */
    public void setCompanyId(Long companyId) {
	this.companyId = companyId;
    }

    /**
     * @return companyName of String Type
     */
    public String getCompanyName() {
	return companyName;
    }

    /**
     * @param String
     *            type set into companyName
     */
    public void setCompanyName(String companyName) {
	this.companyName = companyName;
    }

    /**
     * @return designation of String Type
     */
    public String getDesignation() {
	return designation;
    }

    /**
     * @param String
     *            type set into designation
     */
    public void setDesignation(String designation) {
	this.designation = designation;
    }

    /**
     * @return designationId of Long Type
     */
    public Long getDesignationId() {
	return designationId;
    }

    /**
     * @param Long
     *            type set into designationId
     */
    public void setDesignationId(Long designationId) {
	this.designationId = designationId;
    }

    /**
     * @return dob of String Type
     */
    public String getDob() {
	return dob;
    }

    /**
     * @param String
     *            type set into dob
     */
    public void setDob(String dob) {
	this.dob = dob;
    }

    /**
     * @return email of String Type
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param String
     *            type set into email
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * @return firstName of String Type
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * @param String
     *            type set into firstName
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /**
     * @return lastName of String Type
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * @param String
     *            type set into lastName
     */
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    /**
     * @return insuranceNumber of String Type
     */
    public String getInsuranceNumber() {
	return insuranceNumber;
    }

    /**
     * @param String
     *            type set into insuranceNumber
     */
    public void setInsuranceNumber(String insuranceNumber) {
	this.insuranceNumber = insuranceNumber;
    }

    /**
     * @return password of String Type
     */
    public String getPassword() {
	return password;
    }

    /**
     * @param String
     *            type set into password
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * @return reportingManagerId of Long Type
     */
    public Long getReportingManagerId() {
	return reportingManagerId;
    }

    /**
     * @param Long
     *            type set into reportingManagerId
     */
    public void setReportingManagerId(Long reportingManagerId) {
	this.reportingManagerId = reportingManagerId;
    }

    /**
     * @return reportingManager of String Type
     */
    public String getReportingManager() {
	return reportingManager;
    }

    /**
     * @param String
     *            type set into reportingManager
     */
    public void setReportingManager(String reportingManager) {
	this.reportingManager = reportingManager;
    }

    /**
     * @return roleId of Long Type
     */
    public Long getRoleId() {
	return roleId;
    }

    /**
     * @param Long
     *            type set into roleId
     */
    public void setRoleId(Long roleId) {
	this.roleId = roleId;
    }

    /**
     * @return token of String Type
     */
    public String getToken() {
	return token;
    }

    /**
     * @param String
     *            type set into token
     */
    public void setToken(String token) {
	this.token = token;
    }

    /**
     * @return cellPhone of String Type
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * @param String type set into cellPhone 
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * @return eveningTimePhone of String Type
     */
    public String getEveningTimePhone() {
        return eveningTimePhone;
    }

    /**
     * @param String type set into eveningTimePhone 
     */
    public void setEveningTimePhone(String eveningTimePhone) {
        this.eveningTimePhone = eveningTimePhone;
    }

    /**
     * @return dayTimePhone of String Type
     */
    public String getDayTimePhone() {
        return dayTimePhone;
    }

    /**
     * @param String type set into dayTimePhone 
     */
    public void setDayTimePhone(String dayTimePhone) {
        this.dayTimePhone = dayTimePhone;
    }

}
