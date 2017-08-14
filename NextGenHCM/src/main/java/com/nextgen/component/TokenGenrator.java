/* 
 * ===========================================================================
 * File Name TokenGenrator.java
 * 
 * Created on Jul 22, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: TokenGenrator.java,v $
 * ===========================================================================
 */
package com.nextgen.component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.nextgen.enums.BaseAppConstants;
import com.nextgen.model.SpringSecurityUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * This class is created to manage the spring security by using the token
 * management system
 * 
 * @author umamaheswarar
 * @version 1.0 - Oct 5, 2016
 */
@Component
public class TokenGenrator {
	private static final Logger LOGGER = Logger.getLogger(TokenGenrator.class);
	private final String AUDIENCE_MOBILE = BaseAppConstants.MOBILE.getValue();
	private final String AUDIENCE_TABLET = BaseAppConstants.TABLET.getValue();
	private String secret = BaseAppConstants.SECRET.getValue();
	private Long expiration = 18000L;

	/**
	 * This method is used to extract the username from the token string
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @return username username after extracting from token
	 */
	public String getUsernameFromToken(final String token) {
		try {
			final Claims claims = this.getClaimsFromToken(token);
			return claims.getSubject();
		} catch (Exception e) {
			LOGGER.error("Json Web Token Claim", e);
			return null;
		}
	}

	/**
	 * This method is used to get the created date from the token
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @return Date
	 */
	public Date getCreatedDateFromToken(final String token) {
		try {
			final Claims claims = this.getClaimsFromToken(token);
			return new Date((Long) claims.get(BaseAppConstants.TOKEN_CREATED.getValue()));
		} catch (Exception e) {
			LOGGER.error("Json Web Token Claim", e);
			return null;
		}
	}

	/**
	 * This method is used to get the expiration date from token
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @return date expiration date
	 */
	public Date getExpirationDateFromToken(final String token) {
		try {
			final Claims claims = this.getClaimsFromToken(token);
			return claims.getExpiration();
		} catch (Exception e) {
			LOGGER.error("Json Web Token Claim", e);
			return null;
		}
	}

	/**
	 * This method is used to get the audience from token
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @return String audience of the token
	 */
	public String getAudienceFromToken(final String token) {
		try {
			final Claims claims = this.getClaimsFromToken(token);
			return (String) claims.get(Claims.AUDIENCE);
		} catch (Exception e) {
			LOGGER.error("Json Web Token Claim", e);
			return null;
		}
	}

	/**
	 * This method is used to get the claims from token
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @return claims claims object from the token
	 */
	private Claims getClaimsFromToken(final String token) {
		try {
			return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			LOGGER.error("Json parser ", e);
			return null;
		}
	}

	/**
	 * This method is used to get the current system date
	 * 
	 * @return date current system date
	 */
	private Date generateCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * This method is used to generate the expiration date
	 * 
	 * @return date generated expiration date of the token
	 */
	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + this.expiration * 1000);
	}

	/**
	 * This method is used to get the status of the expiration of the token
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @return boolean expiration status
	 */
	private Boolean isTokenExpired(final String token) {
		final Date expiration = this.getExpirationDateFromToken(token);
		return expiration.before(this.generateCurrentDate());
	}

	/**
	 * This method is used to get the status of the token whether it is cerated
	 * before last password reset or not
	 * 
	 * @param created
	 *            createdDate
	 * @param lastPasswordReset
	 *            last password reset date
	 * @return boolean true/false after checking the status
	 */
	private Boolean isCreatedBeforeLastPasswordReset(final Date created, final Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

	/**
	 * This method is used to get the status of the token expiration whether
	 * it's expiration is ignored or not
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @return boolean true/false
	 */
	private Boolean ignoreTokenExpiration(final String token) {
		final String audience = this.getAudienceFromToken(token);
		return this.AUDIENCE_TABLET.equals(audience) || this.AUDIENCE_MOBILE.equals(audience);
	}

	/**
	 * This method is used to generate the token from the user details
	 * 
	 * @param userDetails
	 *            user details
	 * @return String generated token as String
	 */
	public String generateToken(final UserDetails userDetails) {
		final Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(BaseAppConstants.SUB.getValue(), userDetails.getUsername());
		claims.put(BaseAppConstants.AUDIENCE.getValue(), BaseAppConstants.WEB.getValue());
		claims.put(BaseAppConstants.TOKEN_CREATED.getValue(), this.generateCurrentDate());
		return this.generateToken(claims);
	}

	/**
	 * This method is used to generate the token from the claims
	 * 
	 * @param claims
	 *            claims
	 * @return String generated token as String
	 */
	private String generateToken(final Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(this.generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, this.secret).compact();
	}

	/**
	 * This method is used to get the status of the token whether it can be
	 * refreshed or not.
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @param lastPasswordReset
	 *            last reset password
	 * @return boolean true/false
	 */
	public Boolean canTokenBeRefreshed(final String token, final Date lastPasswordReset) {
		final Date created = this.getCreatedDateFromToken(token);
		return (!(this.isCreatedBeforeLastPasswordReset(created, lastPasswordReset))
				&& (!(this.isTokenExpired(token)) || this.ignoreTokenExpiration(token)));
	}

	/**
	 * This method is used to refresh the token
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @return String refreshed token
	 */
	public String refreshToken(final String token) {
		try {
			final Claims claims = this.getClaimsFromToken(token);
			claims.put(BaseAppConstants.TOKEN_CREATED.getValue(), this.generateCurrentDate());
			return this.generateToken(claims);
		} catch (Exception e) {
			LOGGER.error("Json Web token claim ", e);
			return null;
		}
	}

	/**
	 * This method is used to validate the token
	 * 
	 * @param token
	 *            authentication token as parameter
	 * @param userDetails
	 *            userdetails to match the token
	 * @return Boolean true/false
	 */
	public Boolean validateToken(final String token, final UserDetails userDetails) {
		LOGGER.info("TOKEN : " + token);
		final SpringSecurityUser user = (SpringSecurityUser) userDetails;
		final String username = this.getUsernameFromToken(token);
		final Date created = this.getCreatedDateFromToken(token);
		// final Date expiration = this.getExpirationDateFromToken(token);
		return (username.equals(user.getUsername()) && !(this.isTokenExpired(token))
				&& !(this.isCreatedBeforeLastPasswordReset(created, user.getLastPasswordReset())));
		/*
		 * if(!(this.isTokenExpired(token))){ String refreshedToken =
		 * this.refreshToken(token); LOGGER.info("REFRESHED TOKEN : "
		 * +refreshedToken); this.expiration=60L; }
		 */
		// return isValidToken;
	}
}