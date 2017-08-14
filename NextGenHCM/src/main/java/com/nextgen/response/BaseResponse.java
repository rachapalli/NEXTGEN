/* 
 * ===========================================================================
 * File Name ResponseObj.java
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
 * $Log: ResponseObj.java,v $
 * ===========================================================================
 */
package com.nextgen.response;

/**
 * Using to create a custom response to support API consumer.
 * 
 * @author umamaheswarar 
 * @version 1.0 - Jul 21, 2016
 */

public class BaseResponse {

	private Object data;
	private int status;
	private String message;
	private Integer errorCode;
	private String errorMessage;

	public BaseResponse(int status, String message, Object data) {
		this.data = data;
		this.message = message;
		this.status = status;
	}

	public BaseResponse(int status, String message) {
		this.message = message;
		this.status = status;
	}

	public BaseResponse(int status, Integer errorCode, String errorMessage) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public BaseResponse() {

	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseObj [data=" + data + ", status=" + status + ", message=" + message + ", errorCode=" + errorCode
				+ ", errorMessage=" + errorMessage + "]";
	}

}
