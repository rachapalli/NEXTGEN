/* 
 * ===========================================================================
 * File Name AddressUsage.java
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
 * $Log: AddressUsage.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address_types")
public class AddressTypes implements java.io.Serializable {

	private static final long serialVersionUID = 5442515639825190834L;
	private Set<Address> addresses = new HashSet<Address>(0);
	private Long id;
	private String purpouse;

	/**
	 * Default constructor to the class
	 * 
	 */
	public AddressTypes() {
		super();
	}

	/**
	 * Parameterized constructor to the class
	 * 
	 * @param id
	 * @param name
	 */
	public AddressTypes(Long id, String purpouse) {
		super();
		this.id = id;
		this.purpouse = purpouse;
	}

	/**
	 * @return the addresses
	 */
	@OneToMany(mappedBy = "addresTypes")
	public Set<Address> getAddresses() {
		return addresses;
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
	 * Getter function to get the usage
	 * 
	 * @return usage usage
	 */
	@Column(name = "Type_address")
	public String getPurpouse() {
		return purpouse;
	}

	/**
	 * @param addresses
	 *            the addresses to set
	 */
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
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
	 * Setter function to set the usage field
	 * 
	 * @param usage
	 *            the usage to set
	 */
	public void setPurpouse(String purpouse) {
		this.purpouse = purpouse;
	}

}
