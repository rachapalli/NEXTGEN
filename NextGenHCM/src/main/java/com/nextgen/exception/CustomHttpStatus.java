/* 
 * ===========================================================================
 * File Name CustomHttpStatus.java
 * 
 * Created on Jul 13, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: CustomHttpStatus.java,v $
 * ===========================================================================
 */
 
 package com.nextgen.exception;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * This class is created for handle the http status exception
 * @author umamaheswarar 
 * @version 1.0 - Jul 13, 2016
 */

public class CustomHttpStatus extends HttpStatusCodeException {

	/** long Short Description */
	private static final long serialVersionUID = 6173897063582151105L;

	/**
	 * @param statusCode
	 * @param statusText
	 * @param responseBody
	 * @param responseCharset  
	 * @description 
	 */
	public CustomHttpStatus(HttpStatus statusCode, String statusText, byte[] responseBody, Charset responseCharset) {
		super(statusCode, statusText, responseBody, responseCharset);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param statusCode
	 * @param statusText
	 * @param responseHeaders
	 * @param responseBody
	 * @param responseCharset  
	 * @description 
	 */
	public CustomHttpStatus(HttpStatus statusCode, String statusText, HttpHeaders responseHeaders, byte[] responseBody,
			Charset responseCharset) {
		super(statusCode, statusText, responseHeaders, responseBody, responseCharset);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param statusCode
	 * @param statusText  
	 * @description 
	 */
	public CustomHttpStatus(HttpStatus statusCode, String statusText) {
		super(statusCode, statusText);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param statusCode  
	 * @description 
	 */
	public CustomHttpStatus(HttpStatus statusCode) {
		super(statusCode);
		// TODO Auto-generated constructor stub
	}
}
