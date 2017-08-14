/* 
 * ===========================================================================
 * File Name AuthenticationResponse.java
 * 
 * Created on Aug 4, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: AuthenticationResponse.java,v $
 * ===========================================================================
 */
package com.nextgen.model;

/**
 * This Model class created for hold the token 
 * 
 * @author umamaheswarar 
 * @version 1.0 - Aug 4, 2016
 */
public class AuthenticationResponse {

	private String token;

	/**Default constructor
	 * 
	 */
	public AuthenticationResponse() {
		super();
	}

	/**Parameterized constructor to initialized the token field
	 * @param token 				accepts token to initialized the token filed
	 */
	public AuthenticationResponse(String token) {
		this.token=token;
	}

	/**
	 * @return token 				return the value of the token field
	 */
	public String getToken() {
		return this.token;
	}

	/**
	 * @param token 				accepts token to initialized the token filed
	 */
	public void setToken(String token) {
		this.token = token;
	}
}
