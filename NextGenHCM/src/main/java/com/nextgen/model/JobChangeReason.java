/* 
 * ===========================================================================
 * File Name JobChangeReason.java
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
 * $Log: JobChangeReason.java,v $
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
@Table(name = "job_change_reason")
public class JobChangeReason implements java.io.Serializable {

	private static final long serialVersionUID = -5377873949674092983L;
	private Long id;
	private String reason;


	/**Default constructor to the class
	 * 
	 */
	public JobChangeReason() {
		super();
	}
	

	/**Parameterized constructor to the class
	 * 
	 * @param id
	 * @param name
	 */
	public JobChangeReason(Long id, String reason) {
		super();
		this.id = id;
		this.reason = reason;
	}

	/**Identifier of the class
	 * 
	 * @return id 							id of the object from database
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
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

	/**Getter function to get the name
	 * 
	 * @return name							name
	 */
	@Column(name="REASON")
	public String getReason() {
		return reason;
	}

	/**Setter function to set the name field
	 * 
	 * @param name the name to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
