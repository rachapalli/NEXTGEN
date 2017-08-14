/* 
 * ===========================================================================
 * File Name AuthenticationController.java
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
 * $Log: AuthenticationController.java,v $
 * ===========================================================================
 */
package com.nextgen.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextgen.component.TokenGenrator;
import com.nextgen.dto.ContactDTO;
import com.nextgen.dto.UserDTO;
import com.nextgen.enums.BaseAppConstants;
import com.nextgen.enums.SecurityError;
import com.nextgen.exception.ApplicationCustomException;
import com.nextgen.model.AuthenticationRequest;
import com.nextgen.model.AuthenticationResponse;
import com.nextgen.model.SpringSecurityUser;
import com.nextgen.response.BaseResponse;
import com.nextgen.service.UserService;
import com.nextgen.service.UserWebService;

/**
 * This Controller class created for handled all method related to authenticate
 * the request
 * 
 * @author umamaheswarar 
 * @version 1.0 - Aug 4, 2016
 */

@RestController
@RequestMapping("/api")
public class AuthenticationController {
	private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class);
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenGenrator tokenUtils;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private UserWebService userWebService;
	@Autowired
	private UserService userService;

	/**
	 * This controller method is created to authenticate the mobile application
	 * user
	 * 
	 * @date Aug 22, 2016
	 * @param authenticationRequest
	 * @return ResponseEntity 
	 * @throws ApplicationCustomException
	 */
	@RequestMapping(value = "/customer/login", method = RequestMethod.POST)
	public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest)
			throws ApplicationCustomException {
		LOGGER.info("On Authentication controller...");
		/* Perform the authentication */
		try {
			final Authentication authentication = this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
							authenticationRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			/* Reload password post-authentication so we can generate token */
			final UserDetails userDetails = this.userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());
			LOGGER.info("USER DETAILS "+userDetails);
			final String token = this.tokenUtils.generateToken(userDetails);
			/* Return the generated token */
			final UserDTO userDTO = userService.getUserDetails(authenticationRequest.getUsername());
			if (userDTO != null) {
				userDTO.setToken(token);
			}
			return new ResponseEntity<Object>(new BaseResponse(SecurityError.LOGIN_SUCCESS.getHttpStatus().value(),
					SecurityError.LOGIN_SUCCESS.getDescription(), userDTO), HttpStatus.OK);
		} catch (UsernameNotFoundException e) {
			LOGGER.error("UsernameNotFoundException.." + e);
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_LOGIN.getCode(), SecurityError.INVALID_LOGIN.getDescription()),
					HttpStatus.BAD_REQUEST);
		} catch (AuthenticationException e) {
			LOGGER.error("AuthenticationException.." + e);
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_LOGIN.getCode(), SecurityError.INVALID_LOGIN.getDescription()),
					HttpStatus.BAD_REQUEST);
		} catch (AccessDeniedException e) {
			LOGGER.error("AccessDeniedException.." + e);
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_LOGIN.getCode(), SecurityError.INVALID_LOGIN.getDescription()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOGGER.error("Exception.." + e);
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_LOGIN.getCode(), SecurityError.INVALID_LOGIN.getDescription()),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This controller method is created to authenticate the web application
	 * user
	 * 
	 * @date Aug 22, 2016
	 * @param authenticationRequest
	 * @return ResponseEntity 
	 * @throws ApplicationCustomException
	 */
	@RequestMapping(value = "/web/login", method = RequestMethod.POST)
	public ResponseEntity<?> authenticationWebRequest(@RequestBody AuthenticationRequest authenticationRequest)
			throws ApplicationCustomException {
		/* Perform the authentication */
		try {
			final Authentication authentication = this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
							authenticationRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			/* Reload password post-authentication so we can generate token */
			final UserDetails userDetails = this.userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());
			final String token = this.tokenUtils.generateToken(userDetails);
			/* Getting permissions for this user */
			final ContactDTO contact = userWebService.getUserPermissions(userDetails.getUsername());
			if (contact != null) {
				contact.setToken(token);
				return new ResponseEntity<Object>(new BaseResponse(SecurityError.LOGIN_SUCCESS.getCode(),
						SecurityError.LOGIN_SUCCESS.getDescription(), contact), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
						SecurityError.INVALID_LOGIN.getCode(), SecurityError.INVALID_LOGIN.getDescription()),
						HttpStatus.BAD_REQUEST);
			}
		} catch (UsernameNotFoundException e) {
			LOGGER.error("Username Not found exception ", e);
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_LOGIN.getCode(), SecurityError.INVALID_LOGIN.getDescription()),
					HttpStatus.BAD_REQUEST);
		} catch (AuthenticationException e) {
			LOGGER.error("Authentication exception ", e);
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_LOGIN.getCode(), SecurityError.INVALID_LOGIN.getDescription()),
					HttpStatus.BAD_REQUEST);
		} catch (AccessDeniedException e) {
			LOGGER.error("Access denied ", e);
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_LOGIN.getCode(), SecurityError.INVALID_LOGIN.getDescription()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOGGER.error("Exception ", e);
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.INVALID_LOGIN.getCode(), SecurityError.INVALID_LOGIN.getDescription()),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This controller method is created to authenticate the user request and
	 * checking the authorization token validity
	 * 
	 * @date Aug 22, 2016
	 * @param authenticationRequest
	 * @return ResponseEntity 
	 */
	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public ResponseEntity<?> authenticationRequest(final HttpServletRequest request) {
		final String token = request.getHeader(BaseAppConstants.TOKEN_HEADER.getValue());
		final String username = this.tokenUtils.getUsernameFromToken(token);
		final SpringSecurityUser user = (SpringSecurityUser) this.userDetailsService.loadUserByUsername(username);
		if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
			final String refreshedToken = this.tokenUtils.refreshToken(token);
			return ResponseEntity.ok(new AuthenticationResponse(refreshedToken));
		} else {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.UNAUTHORIZED.value(),
					SecurityError.TOKEN_EXPIRED.getCode(), SecurityError.TOKEN_EXPIRED.getDescription()),
					HttpStatus.UNAUTHORIZED);
		}
	}
}