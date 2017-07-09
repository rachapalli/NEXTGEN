/* 
 * ===========================================================================
 * File Name AddressVisibility.java
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
 * $Log: AddressVisibility.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_visibility")
public class AddressVisibility implements java.io.Serializable {

	private static final long serialVersionUID = -7919342469883952865L;
	private Long id;
	private String visibility;


	/**Default constructor to the class
	 * 
	 */
	public AddressVisibility() {
	}
	

	/**Parameterized constructor to the class
	 * 
	 * @param id
	 * @param name
	 */
	public AddressVisibility(Long id, String visibility) {
		super();
		this.id = id;
		this.visibility = visibility;
	}

	/**Identifier of the class
	 * 
	 * @return id 							id of the object from database
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	/**Setter function to set the id 
	 * 
	 * @param id							id for the object.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**Getter function to get the visibility
	 * 
	 * @return visibility							visibility
	 */
	@Column(name="VISIBILITY")
	public String getVisibility() {
		return visibility;
	}

	/**Setter function to set the visibility field
	 * 
	 * @param visibility the visibility to set
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

}
