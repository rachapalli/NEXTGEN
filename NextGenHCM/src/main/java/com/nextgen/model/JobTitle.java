/* 
 * ===========================================================================
 * File Name JobTitle.java
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
 * $Log: JobTitle.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_title")
public class JobTitle implements java.io.Serializable {

	private static final long serialVersionUID = -5377873949674092983L;
	private Long id;
	private String name;

	/**
	 * Default constructor to the class
	 * 
	 */
	public JobTitle() {
		super();
	}

	/**
	 * Parameterized constructor to the class
	 * 
	 * @param id
	 * @param name
	 * @param description
	 */
	public JobTitle(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * 
	 * /** Identifier of the class
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
	 * Getter function to get the name
	 * 
	 * @return name name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
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
	 * Setter function to set the name field
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
