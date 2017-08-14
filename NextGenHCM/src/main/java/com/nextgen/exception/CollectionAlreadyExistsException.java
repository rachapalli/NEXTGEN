/* 
 * ===========================================================================
 * File Name CollectionAlreadyExistsException.java
 * 
 * Created on Jul 21, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: CollectionAlreadyExistsException.java,v $
 * ===========================================================================
 */

package com.nextgen.exception;

/**
 * This class is created for handle exception when collection is already exist
 * 
 * @author umamaheswarar 
 * @version 1.0 - Jul 21, 2016
 */

public class CollectionAlreadyExistsException extends Exception {
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

	public CollectionAlreadyExistsException() {
		super();
	}

	/**
	 * @param errorMessage  
	 * @description 
	 */
	public CollectionAlreadyExistsException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
}
