/* 
 * ===========================================================================
 * File Name City.java
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
 * $Log: City.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITIES")
public class City implements java.io.Serializable {

	private static final long serialVersionUID = -5377873949674092983L;
	private Long id;
	private String name;
	private State state;

	/**
	 * Default constructor to the class
	 * 
	 */
	public City() {
		super();
	}

	/**
	 * Parameterized constructor to the class
	 * 
	 * @param id
	 * @param name
	 */
	public City(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@ManyToOne
	@JoinColumn(name = "STATE_ID")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
