/* 
 * ===========================================================================
 * File Name MediaLocationMisMatchException.java
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
 * $Log: MediaLocationMisMatchException.java,v $
 * ===========================================================================
 */

package com.nextgen.exception;

/**
 * This class handles the media file geo-coordinate mismatch Exception.
 * 
 * @author umamaheswarar - Chetu
 * @version 1.0 - Jul 21, 2016
 */

public class MediaLocationMisMatchException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	

	/**
	 * @param message
	 */
	public MediaLocationMisMatchException(String message) {
		this.message = message;
	}
	
	/**
	 * @param message
	 */
	public MediaLocationMisMatchException() {
		
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}	
}
