/* 
 * ===========================================================================
 * File Name PayrollInputType.java
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
 * $Log: PayrollInputType.java,v $
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
@Table(name = "payroll_input_type")
public class PayrollInputType implements java.io.Serializable {

	private static final long serialVersionUID = 2203133892864065506L;
	private Long id;
	private String type;


	/**Default constructor to the class
	 * 
	 */
	public PayrollInputType() {
		
	}
	

	/**Parameterized constructor to the class
	 * 
	 * @param id
	 * @param name
	 */
	public PayrollInputType(Long id, String type) {
		
		this.id = id;
		this.type = type;
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

	/**Getter function to get the type
	 * 
	 * @return type							type
	 */
	@Column(name="TYPE")
	public String getType() {
		return type;
	}

	/**Setter function to set the type field
	 * 
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
