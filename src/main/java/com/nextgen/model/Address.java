/* 
 * ===========================================================================
 * File Name Address.java
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
 * $Log: Address.java,v $
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
@Table(name = "address")
public class Address implements java.io.Serializable {

	private static final long serialVersionUID = 8071039262234478883L;
	private String addressChangeEventId;
	private String addressLineOne;
	private String addressLineTwo;
	private City city;
	private Country country;
	private Date createDate;
	private Date effectiveDate;
	private Employee employee;
	private Long id;
	private State state;
	private AddressType type;
	private AddressTypes addresTypes;
	private AddressVisibility visibility;
	private String zip;

	/**
	 * 
	 */
	public Address() {

	}

	/**
	 * @param addressChangeEventId
	 * @param addressLineOne
	 * @param addressLineTwo
	 * @param city
	 * @param country
	 * @param createDate
	 * @param effectiveDate
	 * @param employee
	 * @param id
	 * @param state
	 * @param type
	 * @param visibility
	 * @param zip
	 */
	public Address(String addressChangeEventId, String addressLineOne, String addressLineTwo, City city,
			Country country, Date createDate, Date effectiveDate, Employee employee, Long id, State state,
			AddressType type, AddressVisibility visibility, String zip) {
		super();
		this.addressChangeEventId = addressChangeEventId;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.country = country;
		this.createDate = createDate;
		this.effectiveDate = effectiveDate;
		this.employee = employee;
		this.id = id;
		this.state = state;
		this.type = type;
		this.visibility = visibility;
		this.zip = zip;
	}

	/**
	 * @param addressChangeEventId
	 * @param addressLineOne
	 * @param addressLineTwo
	 * @param city
	 * @param country
	 * @param createDate
	 * @param effectiveDate
	 * @param employee
	 * @param id
	 * @param state
	 * @param type
	 * @param addressUsage
	 * @param visibility
	 * @param zip
	 */
	public Address(String addressChangeEventId, String addressLineOne, String addressLineTwo, City city,
			Country country, Date createDate, Date effectiveDate, Employee employee, Long id, State state,
			AddressType type, AddressTypes addresTypes, AddressVisibility visibility, String zip) {
		super();
		this.addressChangeEventId = addressChangeEventId;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.country = country;
		this.createDate = createDate;
		this.effectiveDate = effectiveDate;
		this.employee = employee;
		this.id = id;
		this.state = state;
		this.type = type;
		this.addresTypes = addresTypes;
		this.visibility = visibility;
		this.zip = zip;
	}

	/**
	 * @return the addressChangeEventId
	 */
	@Column(name = "CHANGE_EVENT_ID")
	public String getAddressChangeEventId() {
		return addressChangeEventId;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE")
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Identifier of the class
	 * 
	 * @return id id of the object from database
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	/**
	 * @return the state
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE")
	public State getState() {
		return state;
	}

	/**
	 * @return the type
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE")
	public AddressType getType() {
		return type;
	}

	/**
	 * @return the visibility
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VISIBILITY")
	public AddressVisibility getVisibility() {
		return visibility;
	}

	/**
	 * @return the zip
	 */
	@Column(name = "ZIP")
	public String getZip() {
		return zip;
	}

	/**
	 * @param addressChangeEventId
	 *            the addressChangeEventId to set
	 */
	public void setAddressChangeEventId(String addressChangeEventId) {
		this.addressChangeEventId = addressChangeEventId;
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

	/**
	 * @param effectiveDate
	 *            the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(AddressType type) {
		this.type = type;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPES")
	public AddressTypes getAddresTypes() {
		return addresTypes;
	}

	public void setAddresTypes(AddressTypes addresTypes) {
		this.addresTypes = addresTypes;
	}

	/**
	 * @param visibility
	 *            the visibility to set
	 */
	public void setVisibility(AddressVisibility visibility) {
		this.visibility = visibility;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

}
