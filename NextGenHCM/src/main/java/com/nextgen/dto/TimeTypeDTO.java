/* 
 * ===========================================================================
 * File Name TimeTypeDTO.java
 * 
 * Created on Jul 14, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: TimeTypeDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

/**
 * This class contains the details of application time type select menu data.
 * 
 * @author umamaheswarar 
 * @version 1.0 - Jul 14, 2016
 */

public class TimeTypeDTO implements Serializable {

	private static final long serialVersionUID = 8260923036454345537L;
	private Long id;
	private String timeType;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the timeType
	 */
	public String getTimeType() {
		return timeType;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param timeType the timeType to set
	 */
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
}
