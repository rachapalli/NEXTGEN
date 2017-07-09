/* 
 * ===========================================================================
 * File Name WorkerController.java
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
 * $Log: WorkerController.java,v $
 * ===========================================================================
 */
package com.nextgen.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextgen.dto.EmployeeAddressDTO;
import com.nextgen.dto.EmployeeDTO;
import com.nextgen.dto.JobChangeDTO;
import com.nextgen.dto.PayrollDTO;
import com.nextgen.dto.PositionDTO;
import com.nextgen.dto.TimeOffDTO;
import com.nextgen.enums.SecurityError;
import com.nextgen.exception.ApplicationCustomException;
import com.nextgen.response.BaseResponse;
import com.nextgen.service.UserService;

/**
 * This Controller class created for to handle worker related tasks.
 * 
 * @author umamaheswarar
 * @version 1.0 - Feb 27, 2017
 */

@RestController
@RequestMapping("/api/admin")
public class EmployeeController {
	private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource source;

	/**
	 * This method is used to create an employee into the system.
	 * 
	 * @author umamaheswarar
	 * @param createWorkerDTO
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/create/employee", method = RequestMethod.POST)
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO createWorkerDTO) {
		LOGGER.info("CONTROLLER : Inside the create employee on controller...");
		try {
			final EmployeeDTO createdWorkerDetails = userService.createEmployee(createWorkerDTO);
			if (createdWorkerDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("employee.create.success.details.message", null, null), createdWorkerDetails),
						HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is used to create an employee into the system.
	 * 
	 * @author umamaheswarar
	 * @param createWorkerDTO
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/update/employee", method = RequestMethod.POST)
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO createWorkerDTO) {
		LOGGER.info("CONTROLLER : Inside the update employee on controller...");
		try {
			final EmployeeDTO createdWorkerDetails = userService.updateEmployee(createWorkerDTO);
			if (createdWorkerDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("employee.update.success.details.message", null, null), createdWorkerDetails),
						HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is used to create a job position into the system.
	 * 
	 * @author umamaheswarar
	 * @param positionDTO
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/create/position", method = RequestMethod.POST)
	public ResponseEntity<?> createJobPosition(@RequestBody PositionDTO positionDTO) {
		LOGGER.info("CONTROLLER : Inside the create position on controller...");
		try {
			final PositionDTO createdPositionDetails = userService.createJobPosition(positionDTO);
			if (createdPositionDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("position.create.success.details.message", null, null),
						createdPositionDetails), HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is used to update a job position into the system.
	 * 
	 * @author umamaheswarar
	 * @param positionDTO
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/update/position", method = RequestMethod.POST)
	public ResponseEntity<?> updateJobPosition(@RequestBody PositionDTO positionDTO) {
		LOGGER.info("CONTROLLER : Inside the update position on controller...");
		try {
			final PositionDTO createdPositionDetails = userService.updateJobPosition(positionDTO);
			if (createdPositionDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("position.update.success.details.message", null, null),
						createdPositionDetails), HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is used to manage the timeoff for the employees
	 * 
	 * @author umamaheswarar
	 * @param timeOffDTO
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/manage/timeoff", method = RequestMethod.POST)
	public ResponseEntity<?> manageTimeOff(@RequestBody TimeOffDTO timeOffDTO) {
		LOGGER.info("CONTROLLER : Inside the manage time off on controller...");
		try {
			final TimeOffDTO timeOffDetails = userService.manageTimeOff(timeOffDTO);
			if (timeOffDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("timeoff.submit.success.details.message", null, null), timeOffDetails),
						HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is used to chnage the job of the employee
	 * 
	 * @author umamaheswarar
	 * @param jobChangeDTO
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/change/job", method = RequestMethod.POST)
	public ResponseEntity<?> jobChange(@RequestBody JobChangeDTO jobChangeDTO) {
		LOGGER.info("CONTROLLER : Inside the Job Change on controller...");
		try {
			final JobChangeDTO jobChangeDetails = userService.jobChange(jobChangeDTO);
			if (jobChangeDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("jobchange.submit.success.details.message", null, null), jobChangeDetails),
						HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is used to change the contact and address of the employee
	 * 
	 * @author umamaheswarar
	 * @param jobChangeDTO
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/change/contactdetails", method = RequestMethod.POST)
	public ResponseEntity<?> changeContactDetails(@RequestBody EmployeeAddressDTO employeeAddressDTO) {
		LOGGER.info("CONTROLLER : Inside the employee address change on controller...");
		try {
			final String addressChangeEventId = userService.changeContactDetails(employeeAddressDTO);
			if (addressChangeEventId != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("employee.address.details.update.message", null, null), addressChangeEventId),
						HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is used to manage the payroll for the employees
	 * 
	 * @author umamaheswarar
	 * @param payrollDTO
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/manage/payroll", method = RequestMethod.POST)
	public ResponseEntity<?> managePayroll(@RequestBody PayrollDTO payrollDTO) {
		LOGGER.info("CONTROLLER : Inside the manage payroll on controller...");
		try {
			final PayrollDTO payrollDetails = userService.managePayroll(payrollDTO);
			if (payrollDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("payroll.submit.success.details.message", null, null), payrollDetails),
						HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method is used to create an employee into the system.
	 * 
	 * @author umamaheswarar
	 * @param createWorkerDTO
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/create/employee", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
		LOGGER.info("CONTROLLER : Inside the create employee on controller...");
		try {
			final EmployeeDTO createdWorkerDetails = userService.createEmployee(createWorkerDTO);
			if (createdWorkerDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("employee.create.success.details.message", null, null), createdWorkerDetails),
						HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
				SecurityError.INVALID_DATA.getCode(), SecurityError.INVALID_DATA.getDescription()),
				HttpStatus.BAD_REQUEST);
	}
}