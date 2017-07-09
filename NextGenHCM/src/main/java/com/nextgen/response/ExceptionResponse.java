/* 
 * ===========================================================================
 * File Name ExceptionObj.java
 * 
 * Created on Jul 30, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: ExceptionObj.java,v $
 * ===========================================================================
 */
/**
* Class Information
* @author umamaheswarar - Chetu
* @version 1.0 - Jul 30, 2016
*/
package com.nextgen.response;

public class ExceptionResponse {
	private Object data;
	private String message;
	private String errorMessage;
	private int errorCode;
	private int status;

	/**
	 * @param errorMessage
	 * @param errorCode
	 * @param status
	 * @description
	 */
	public ExceptionResponse(String errorMessage, int errorCode, int status) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.status = status;
	}

	public ExceptionResponse() {

	}

	/**
	 * @return data of Object Type
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @return message of String Type
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return errorMessage of String Type
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @return errorCode of int Type
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @return status of int Type
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param Object
	 *            type set into data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @param String
	 *            type set into message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param String
	 *            type set into errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @param int
	 *            type set into errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @param int
	 *            type set into status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

}
