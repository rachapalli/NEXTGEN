/* 
 * ===========================================================================
 * File Name ExceptionController.java
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
 * $Log: ExceptionController.java,v $
 * ===========================================================================
 */

package com.nextgen.exception;

import java.sql.SQLException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nextgen.enums.SecurityError;
import com.nextgen.response.ExceptionResponse;

/**
 * Class is to handle all the exception which are raising in any layer, acts as
 * a global exception.
 * 
 * @author umamaheswarar - Chetu
 * @version 1.0 - Jul 29, 2016
 */

@ControllerAdvice
public class ExceptionController {
	private static final Logger LOGGER = Logger.getLogger(ExceptionController.class);
	/**
	 * This handler method will use to handle all the exceptions which are going
	 * to raise in any layer of the application.
	 * 
	 * @author umamaheswarar
	 * @date Jul 29, 2016
	 * @return <code>ResponseEntity<ExceptionResponse></code> In the form of JSON.
	 * @param ex
	 *            Type of exception we are passing.
	 */
	/*@ExceptionHandler(HibernateException.class)
	public ResponseEntity<ExceptionResponse> exceptionHandler(HibernateException ex) {
		LOGGER.error("HibernateException ", ex);
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getMessage());
		error.setErrorCode(SecurityError.DATABASE_ERROR.getCode());
		error.setStatus(SecurityError.DATABASE_ERROR.getHttpStatus().value());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	@ExceptionHandler(ServletException.class)
	public ResponseEntity<ExceptionResponse> servletExceptionHandler(ServletException ex) {
	    LOGGER.error("Servlet Exception ", ex);
	    ExceptionResponse error = new ExceptionResponse();
	    error.setErrorMessage(ex.getMessage());
	    error.setErrorCode(SecurityError.TOKEN_EXPIRED.getCode());
	    error.setStatus(SecurityError.TOKEN_EXPIRED.getHttpStatus().value());
	    return new ResponseEntity<ExceptionResponse>(error, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(ItemAlreadyScheduledException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(ItemAlreadyScheduledException ex) {
		LOGGER.error("ItemAlreadyScheduledException ", ex);		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorCode(SecurityError.ALREADY_SCHEDULED.getCode());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<ExceptionResponse> AlreadyExistsExceptionHandler(AlreadyExistsException ex) {
		LOGGER.error("AlreadyExistsException ", ex);		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorCode(SecurityError.ALREADY_EXIST.getCode());
		error.setStatus(SecurityError.ALREADY_EXIST.getHttpStatus().value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ExceptionResponse> SQLExceptionHandler(SQLException ex) {
		LOGGER.error("SQLException ", ex);		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorCode(SecurityError.DATABASE_ERROR.getCode());
		error.setStatus(SecurityError.DATABASE_ERROR.getHttpStatus().value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(FileNotExistException.class)
	public ResponseEntity<ExceptionResponse> fileNotFoundException(FileNotExistException ex) {
		LOGGER.error("FileNotExistException ", ex);		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorCode(SecurityError.FILE_NOT_FOUND.getCode());
		error.setStatus(SecurityError.FILE_NOT_FOUND.getHttpStatus().value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IOFileException.class)
	public ResponseEntity<ExceptionResponse> iOException(IOFileException ex) {
		LOGGER.error("IOFileException ", ex);		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorCode(SecurityError.IO_EXCEPTION.getCode());
		error.setStatus(SecurityError.IO_EXCEPTION.getHttpStatus().value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(ItemNotExistException.class)
	public ResponseEntity<ExceptionResponse> itemNotExistException(ItemNotExistException ex) {
		LOGGER.error("ItemNotExistException ", ex);		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorCode(SecurityError.NOT_EXIST.getCode());
		error.setStatus(SecurityError.NOT_EXIST.getHttpStatus().value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.NO_CONTENT);
	}
	@ExceptionHandler(NoSuchMessageException.class)
	public ResponseEntity<ExceptionResponse> NoSuchMessageExceptionHandler(NoSuchMessageException ex) {
		LOGGER.error("NoSuchMessageException ", ex);		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorCode(SecurityError.PROPERTY_NOT_FOUND.getCode());
		error.setStatus(SecurityError.PROPERTY_NOT_FOUND.getHttpStatus().value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.NOT_FOUND);
	}

}
