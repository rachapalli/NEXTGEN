/* 
 * ===========================================================================
 * File Name TestController.java
 * 
 * Created on Feb 27, 2017
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2017
 * All rights reserved.
 *
 * Modification history:
 * $Log: TestController.java,v $
 * ===========================================================================
 */
/**
* This Controller is used to test the server is up or not.
* 
* @author umamaheswarar - Chetu
* @version 1.0 - Feb 27, 2017
*/
package com.nextgen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextgen.response.BaseResponse;

@RestController
@RequestMapping("/api")
public class TestController {
	@Autowired
	private MessageSource source;

	@RequestMapping(value = "/server/check", method = RequestMethod.GET)
	public ResponseEntity<?> serverInfo() throws Exception {
		return new ResponseEntity<Object>(
				new BaseResponse(HttpStatus.OK.value(), source.getMessage("server.check.message", null, null)),
				HttpStatus.OK);
	}
}
