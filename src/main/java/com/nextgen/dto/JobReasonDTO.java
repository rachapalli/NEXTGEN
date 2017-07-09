/* 
 * ===========================================================================
 * File Name JobReasonDTO.java
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
 * $Log: JobReasonDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

/**
 * This classs is used to carry the information for the job chnage reason for the
 * employee
 * 
 * @author umamaheswarar
 *
 */
public class JobReasonDTO implements Serializable {

	private static final long serialVersionUID = 7203588174401954066L;
	private Long id;
	private String reason;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
