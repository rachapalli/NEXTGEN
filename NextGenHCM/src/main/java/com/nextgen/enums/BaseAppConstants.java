/* 
 * ===========================================================================
 * File Name BaseAppConstants.java
 * 
 * Created on Oct 11, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: BaseAppConstants.java,v $
 * ===========================================================================
 */

package com.nextgen.enums;

/**
 * Enum for used in application
 * 
 * @author vikashk3 - Chetu
 * @version 1.0 - Oct 11, 2016
 */

public enum BaseAppConstants {
	
	ACCEPT("Accept"),
	ACCESS_CONTROL_ALLOW_CREDENTIALS("Access-Control-Allow-Credentials"),
	ACCESS_CONTROL_ALLOW_HEADERS("Access-Control-Allow-Headers"),
	ACCESS_CONTROL_ALLOW_METHODS("Access-Control-Allow-Methods"),
	ACCESS_CONTROL_ALLOW_ORIGIN("Access-Control-Allow-Origin"),
	ACCESS_CONTROL_EXPOSE_HEADERS("Access-Control-Expose-Headers"),
	ACCESS_CONTROL_MAX_AGE("Access-Control-Max-Age"),
	ACCESS_CONTROL_REQUEST_HEADERS("Access-Control-Request-Headers"),
	ACCESS_CONTROL_REQUEST_METHODS("Access-Control-Request-Methods"),
	ADDRESS("Address"),
	ADDRESS_CHANGE("ADDRESS_CHANGE"),
	ADMIN("ADMIN"),
	AES("AES"),
	APPLICATION_JSON("application/json"),
	AUDIENCE("audience"),
	AUTHORITY_USER("USER"),
	BLANK(""),
	COLLON(":"),
	COMMA(","),
	CONTACT("CONTACT"),
	CORPORATE_USER("CORPORATE USER"),
	DOLLAR_SIGN("$"),
	DOT("."),
	ENCRYPTION_KEY("1Hbfh667adfDEJ78"),
	HEX_CHAR("SHA1PRNG"),
	JOB_CHANGE("JOB_CHANGE"),
	KEY("1Hbfh667adfDEJ78"),
	LOCAL_DATE_FORMAT("dd-MM-yyyy HH:mm:ss"),
	MOBILE("mobile"),
	NO_DATA("No Data"),
	OS_NAME("os.name"),
	OS_WINDOW("win"),
	PAYROLL_INPUT("PAYROLL_INPUT"),
	SECRET("sssshhhh!"),
	SHA_256("SHA-256"),
	SUB("sub"),
	TABLET("Tablet"),
	TIME_OFF("TIME OFF"),
	TOKEN_CREATED("created"),
	TOKEN_HEADER("X-Auth-Token"),
	TRUE("TRUE"),
	UNDERSCORE("_"),
	UTC_DATE_FORMATTER("yyyy-MM-dd HH:mm:ss"),
	UTF_8("UTF-8"),
	WEB("web"),
	ZERO("0"),
	ZERO_CHARACTER("'0'");
	
	private String value;

	BaseAppConstants(String value) {
		this.value = value;

	}

	public String getValue() {
		return value;
	}

}
