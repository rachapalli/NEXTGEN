/* 
 * ===========================================================================
 * File Name ErrorResponse.java
 * 
 * Created on Jul 29, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: ErrorResponse.java,v $
 * ===========================================================================
 */

package com.nextgen.response;

import org.springframework.http.HttpStatus;

/**
 * This class properties will use while returning error message and code. 
 * 
 * @author umamaheswarar 
 * @version 1.0 - Jul 29, 2016
 */

public class ErrorResponse {
	private int errorCode;
	private HttpStatus code;
	private String message;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}
	
}
