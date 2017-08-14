/* 
 * ===========================================================================
 * File Name AuthenticationTokenFilter.java
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
 * $Log: AuthenticationTokenFilter.java,v $
 * ===========================================================================
 */
package com.nextgen.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nextgen.component.TokenGenrator;
import com.nextgen.enums.BaseAppConstants;

/**
 * This Authentication Filter class created for handled all method related to
 * authenticate the request
 * 
 * @author umamaheswarar 
 * @version 1.0 - Aug 4, 2016
 */
public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {
	private static final Logger LOGGER = Logger.getLogger(AuthenticationTokenFilter.class);

	@Autowired
	private TokenGenrator tokenUtils;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private MessageSource source;

	/**
	 * This filter method is created to authenticate the each request with the
	 * system
	 * 
	 * @date Aug 22, 2016
	 * @param request
	 *            servlet request object
	 * @param response
	 *            servlet response object
	 * @param chain
	 *            filter chain object
	 * @throws IOException
	 *             exception in case of any miss leading with the Input/Output
	 *             stream of the system
	 * @throws ServletException
	 *             exception in case of any miss leading with the servlet
	 *             request/response
	 */
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		tokenUtils = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext())
				.getBean(TokenGenrator.class);

		userDetailsService = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext())
				.getBean(UserDetailsService.class);

		final HttpServletResponse httpResponse = (HttpServletResponse) response;
		final HttpServletRequest httpRequest = (HttpServletRequest) request;

		final String authToken = httpRequest.getHeader(BaseAppConstants.TOKEN_HEADER.getValue());
		final String username = this.tokenUtils.getUsernameFromToken(authToken);

		LOGGER.info("AUTH TOKEN					: " + authToken);
		LOGGER.info("URL 						: " + httpRequest.getRequestURL());
		LOGGER.info("METHOD TYPE 				: " + httpRequest.getMethod());
		LOGGER.info("AUTH TYPE 					: " + httpRequest.getAuthType());

		Enumeration<String> enums = httpRequest.getHeaderNames();
		while (enums.hasMoreElements()) {
			LOGGER.info("Request Header  			: " + enums.nextElement());
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			//Loading use details from spring context.
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if (this.tokenUtils.validateToken(authToken, userDetails)) {//validating authentication token 
				final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		LOGGER.info(" Null Check " + httpRequest.getHeader("Access-Control-Request-Method"));
		LOGGER.info(" Request Method " + httpRequest.getMethod());

		if (httpRequest.getHeader("Access-Control-Request-Method") != null
				&& "OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
			LOGGER.info("Inside Request Method type Options");
			httpResponse.setHeader(BaseAppConstants.ACCESS_CONTROL_ALLOW_ORIGIN.getValue(), "*");
			httpResponse.setHeader(BaseAppConstants.ACCESS_CONTROL_ALLOW_CREDENTIALS.getValue(),
					BaseAppConstants.TRUE.getValue());

			httpResponse.setHeader(BaseAppConstants.ACCESS_CONTROL_ALLOW_METHODS.getValue(),
					source.getMessage("access.controll.allow.methods", null, null));
			httpResponse.setHeader(BaseAppConstants.ACCESS_CONTROL_ALLOW_HEADERS.getValue(),
					source.getMessage("access.controll.allow.headers", null, null));

			/*
			 * resp.setHeader(BaseAppConstants.ACCESS_CONTROL_EXPOSE_HEADERS.
			 * getValue(), source.getMessage("access.controll.allow.headers",
			 * null, null));
			 */
			httpResponse.setHeader(BaseAppConstants.ACCESS_CONTROL_MAX_AGE.getValue(),
					source.getMessage("access.controll.max.age", null, null));
			httpResponse.setStatus(HttpServletResponse.SC_OK);
		} else {
			LOGGER.info("Inside filter chain . . ");
			chain.doFilter(request, response);
		}
	}
}