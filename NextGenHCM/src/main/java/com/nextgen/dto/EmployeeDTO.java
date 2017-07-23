/* 
 * ===========================================================================
 * File Name EmployeeDTO.java
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
 * $Log: EmployeeDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

/**
 * This class is used to carry the information for the employee
 * 
 * @author umamaheswarar
 *
 */
public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 7106027660544294908L;
	private String addressLineOne;
	private String addressLineTwo;
	private BaseAppDTO city;
	private BaseAppDTO country;
	private String dob;
	private String email;
	private String firstName;
	private String gender;
	private String hireDate;
	private Long id;
	private String lastName;
	private String middleName;
	private String nationalId;
	private String phone;
	private BaseAppDTO state;

	private String zip;

	/**
	 * @return the addressLineOne
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}

	/**
	 * @return the addressLineTwo
	 */
	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	/**
	 * @return the city
	 */
	public BaseAppDTO getCity() {
		return city;
	}

	/**
	 * @return the country
	 */
	public BaseAppDTO getCountry() {
		return country;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return the hireDate
	 */
	public String getHireDate() {
		return hireDate;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the nationalId
	 */
	public String getNationalId() {
		return nationalId;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the state
	 */
	public BaseAppDTO getState() {
		return state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param addressLineOne
	 *            the addressLineOne to set
	 */
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	/**
	 * @param addressLineTwo
	 *            the addressLineTwo to set
	 */
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(BaseAppDTO city) {
		this.city = city;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(BaseAppDTO country) {
		this.country = country;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param hireDate
	 *            the hireDate to set
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @param nationalId
	 *            the nationalId to set
	 */
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(BaseAppDTO state) {
		this.state = state;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

}
