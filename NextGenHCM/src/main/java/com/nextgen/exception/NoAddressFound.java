/* 
 * ===========================================================================
 * File Name AlreadyExistsException.java
 * 
 * Created on Aug 5, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: AlreadyExistsException.java,v $
 * ===========================================================================
 */

package com.nextgen.exception;

/**
 * This class is created for handle exception when some thing is already presents.
 * 
 * @author umamaheswarar 
 * @version 1.0 - Aug 5, 2016
 */

public class NoAddressFound extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	/**
	 * @return errorMessage of String Type
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param String type set into errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public NoAddressFound() {
		super();
	}

	/**
	 * @param errorMessage
	 * @description
	 */
	public NoAddressFound(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}
