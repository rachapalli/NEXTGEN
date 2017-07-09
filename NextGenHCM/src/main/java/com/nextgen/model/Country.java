/* 
 * ===========================================================================
 * File Name Country.java
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
 * $Log: Country.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
public class Country implements java.io.Serializable {

	private static final long serialVersionUID = -5377873949674092983L;
	private Long id;
	private String country_name;
	private String country_code;
	private String phone_code;
	private List<State> states;

	/**
	 * Default constructor to the class
	 * 
	 */
	public Country() {
		super();
	}

	public Country(Long id, String country_name, String country_code) {
		super();
		this.id = id;
		this.country_name = country_name;
		this.country_code = country_code;
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

	@Column(name = "COUNTRY_NAME")
	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	@Column(name = "COUNTRY_CODE")
	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
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

	@Column(name = "PHONE_CODE")
	public String getPhone_code() {
		return phone_code;
	}

	public void setPhone_code(String phone_code) {
		this.phone_code = phone_code;
	}

	@OneToMany(mappedBy="country", cascade=CascadeType.ALL)
	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	

}
