/* 
 * ===========================================================================
 * File Name Employee.java
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
 * $Log: Employee.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = -5377873949674092983L;
	private Set<Address> addresses = new HashSet<Address>(0);
	private String addressLineOne;
	private String addressLineTwo;
	private String authorities;
	private City city;
	private Country country;
	private Date createDate;
	private Date dob;
	private String firstname;
	private String gender;
	private Date hiredate;
	private Long id;
	private Set<JobChangeDetail> jobChangeDetails = new HashSet<JobChangeDetail>(0);
	private Date lastLogin;
	private String lastname;
	private String middlename;
	private String nationalId;
	private String password;
	private Set<EmployeePayroll> payrollDetails = new HashSet<EmployeePayroll>(0);
	private String phone;
	private String secretKey;
	private Date secretKeyExpiry;
	private State state;
	private String username;
	private String zip;

	public Employee() {
		super();
	}

	public Employee(Long id, String firstname, String middlename, String lastname, String phone, String username,
			String password, Date dob, String authorities, String gender, Date hiredate, String nationalId,
			String addressLineOne, String addressLineTwo, City city, Country country, String zip, State state,
			Date lastLogin, String secretKey, Date secretKeyExpiry) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.authorities = authorities;
		this.gender = gender;
		this.hiredate = hiredate;
		this.nationalId = nationalId;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.state = state;
		this.lastLogin = lastLogin;
		this.secretKey = secretKey;
		this.secretKeyExpiry = secretKeyExpiry;
	}

	/**
	 * @return the addresses
	 */
	@OneToMany(mappedBy = "employee")
	public Set<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @return the addressLineOne
	 */
	@Column(name = "STREET_ADDRESS_LINE")
	public String getAddressLineOne() {
		return addressLineOne;
	}

	/**
	 * @return the addressLineTwo
	 */
	@Column(name = "ADDRESS_LINE")
	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	@Column(name = "AUTHORITIES")
	public String getAuthorities() {
		return this.authorities;
	}

	/**
	 * @return the city
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY")
	public City getCity() {
		return city;
	}

	/**
	 * @return the country
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY")
	public Country getCountry() {
		return country;
	}

	/**
	 * @return the createDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 19)
	public Date getCreateDate() {
		return createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DOB", length = 19)
	public Date getDob() {
		return this.dob;
	}

	@Column(name = "FIRSTNAME")
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * @return the gender
	 */
	@Column(name = "GENDER")
	public String getGender() {
		return gender;
	}

	/**
	 * @return the hiredate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HIRE_DATE", length = 19)
	public Date getHiredate() {
		return hiredate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	/**
	 * @return the jobChangeDetail
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<JobChangeDetail> getJobChangeDetails() {
		return jobChangeDetails;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_LOGIN", length = 19)
	public Date getLastLogin() {
		return this.lastLogin;
	}

	@Column(name = "LASTNAME")
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * @return the middlename
	 */
	@Column(name = "MIDDILE_NAME")
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * @return the nationalId
	 */
	@Column(name = "NATIONAL_ID")
	public String getNationalId() {
		return nationalId;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	/**
	 * @return the payrollDetails
	 */
	@OneToMany(mappedBy="employee")
	public Set<EmployeePayroll> getPayrollDetails() {
		return payrollDetails;
	}

	/**
	 * @return the phone
	 */
	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}

	@Column(name = "SECRET_KEY")
	public String getSecretKey() {
		return this.secretKey;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SECRET_KEY_EXPIRY", length = 19)
	public Date getSecretKeyExpiry() {
		return this.secretKeyExpiry;
	}

	/**
	 * @return the state
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE")
	public State getState() {
		return state;
	}

	@Column(name = "USERNAME", unique = true, length = 45)
	public String getUsername() {
		return this.username;
	}

	/**
	 * @return the zip
	 */
	@Column(name = "ZIP")
	public String getZip() {
		return zip;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
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

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @param hiredate
	 *            the hiredate to set
	 */
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param jobChangeDetail
	 *            the jobChangeDetail to set
	 */
	public void setJobChangeDetails(Set<JobChangeDetail> jobChangeDetails) {
		this.jobChangeDetails = jobChangeDetails;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param middlename
	 *            the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * @param nationalId
	 *            the nationalId to set
	 */
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param payrollDetails the payrollDetails to set
	 */
	public void setPayrollDetails(Set<EmployeePayroll> payrollDetails) {
		this.payrollDetails = payrollDetails;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public void setSecretKeyExpiry(Date secretKeyExpiry) {
		this.secretKeyExpiry = secretKeyExpiry;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

}
