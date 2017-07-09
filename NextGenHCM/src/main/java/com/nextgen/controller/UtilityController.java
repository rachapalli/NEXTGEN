/* 
 * ===========================================================================
 * File Name UtilityController.java
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
 * $Log: UtilityController.java,v $
 * ===========================================================================
 */
/**
* This Controller is used to test the server is up or not.
* 
* @author umamaheswarar - Chetu
* @version 1.0 - Feb 27, 2017
*/
package com.nextgen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextgen.dto.CitiesDTO;
import com.nextgen.dto.CountriesDTO;
import com.nextgen.dto.StatesDTO;
import com.nextgen.enums.SecurityError;
import com.nextgen.response.BaseResponse;
import com.nextgen.service.UtilityService;

@RestController
@RequestMapping("/api")
public class UtilityController {
	@Autowired
	private MessageSource source;

	@Autowired
	private UtilityService utilityService;

	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity<?> countries() throws Exception {
		final List<CountriesDTO> countries = utilityService.countries();
		if (countries != null) {
			return new ResponseEntity<Object>(
					new BaseResponse(HttpStatus.OK.value(),
							source.getMessage("employee.create.success.details.message", null, null), countries),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/states", method = RequestMethod.POST)
	public ResponseEntity<?> states(@RequestBody StatesDTO statesDTO) throws Exception {
		final List<StatesDTO> states = utilityService.states(statesDTO);
		if (states != null) {
			return new ResponseEntity<Object>(
					new BaseResponse(HttpStatus.OK.value(),
							source.getMessage("employee.create.success.details.message", null, null), states),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/cities", method = RequestMethod.POST)
	public ResponseEntity<?> cities(@RequestBody CitiesDTO citiesDTO) throws Exception {
		final List<CitiesDTO> cities = utilityService.cities(citiesDTO);
		if (cities != null) {
			return new ResponseEntity<Object>(
					new BaseResponse(HttpStatus.OK.value(),
							source.getMessage("employee.create.success.details.message", null, null), cities),
					HttpStatus.OK);
		}
		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}
}
