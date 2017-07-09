/* 
 * ===========================================================================
 * File Name SpringSecurityUser.java
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
 * $Log: SpringSecurityUser.java,v $
 * ===========================================================================
 */

package com.nextgen.model;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class created to hold the fields for accepting the user information
 * 
 * @author umamaheswarar - Chetu
 * @version 1.0 - Aug 4, 2016
 */
public class SpringSecurityUser implements UserDetails {

    /**
     * long Aug 8, 2016 com.pims.security.model  NextGenHCM
     */
    private static final long serialVersionUID = -8340778298768930342L;
    private Long id;
    private String username;
    private String password;
    private String email;
    private Date lastPasswordReset;
    private Collection<? extends GrantedAuthority> authorities;
    private Boolean accountNonExpired = true;
    private Boolean accountNonLocked = true;
    private Boolean credentialsNonExpired = true;
    private Boolean enabled = true;

    public SpringSecurityUser() {
	super();
    }

    /**
     * Parameterized constructor to initialized the fields
     * 
     * @param id
     *            user id
     * @param username
     *            username
     * @param password
     *            password
     * @param email
     *            email
     * @param lastPasswordReset
     *            last password
     * @param authorities
     *            authrorities or role information for permission
     */
    public SpringSecurityUser(final Long id, final String username, final String password, final String email,
	    final Date lastPasswordReset, final Collection<? extends GrantedAuthority> authorities) {
	this.id = id;
	this.username = username;
	this.password = password;
	this.email = email;
	this.lastPasswordReset = lastPasswordReset;
	this.authorities = authorities;
    }

    /**
     * @return returns user id
     */
    public Long getId() {
	return this.id;
    }

    /**
     * @param id
     *            accepts user id
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @return returns usename
     */
    public String getUsername() {
	return this.username;
    }

    /**
     * @param username
     *            accepts username
     */
    public void setUsername(final String username) {
	this.username = username;
    }

    /**
     * @return returns password
     */
    @JsonIgnore
    public String getPassword() {
	return this.password;
    }

    /**
     * @param password
     *            accepts password
     */
    public void setPassword(final String password) {
	this.password = password;
    }

    /**
     * @return returns user email
     */
    public String getEmail() {
	return this.email;
    }

    /**
     * @param email
     *            accepts user email
     */
    public void setEmail(final String email) {
	this.email = email;
    }

    /**
     * @return returns last password date
     */
    @JsonIgnore
    public Date getLastPasswordReset() {
	return this.lastPasswordReset;
    }

    /**
     * @param id
     *            accepts last password date
     */
    public void setLastPasswordReset(final Date lastPasswordReset) {
	this.lastPasswordReset = lastPasswordReset;
    }

    /**
     * @return returns authorities or roles
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return this.authorities;
    }

    /**
     * @param authorities
     *            accepts authorities value
     */
    public void setAuthorities(final Collection<? extends GrantedAuthority> authorities) {
	this.authorities = authorities;
    }

    /**
     * @return returns account non expired
     */
    @JsonIgnore
    public Boolean getAccountNonExpired() {
	return this.accountNonExpired;
    }

    /**
     * @param accountNonExpired
     *            accepts account non expired boolean value
     */
    public void setAccountNonExpired(final Boolean accountNonExpired) {
	this.accountNonExpired = accountNonExpired;
    }

    /**
     * @return returns true or false after checking the account expiration
     */
    public boolean isAccountNonExpired() {
	return this.getAccountNonExpired();
    }

    /**
     * @return returns true or false after checking the account lock info
     */
    @JsonIgnore
    public Boolean getAccountNonLocked() {
	return this.accountNonLocked;
    }

    /**
     * @param accountNonLocked
     *            sets the account lock status to true
     */
    public void setAccountNonLocked(final Boolean accountNonLocked) {
	this.accountNonLocked = accountNonLocked;
    }

    /**
     * @return returns true or false after checking the account lock info
     */
    public boolean isAccountNonLocked() {
	return this.getAccountNonLocked();
    }

    /**
     * @return returns true or false after checking the credential expiration
     *         info
     */
    @JsonIgnore
    public Boolean getCredentialsNonExpired() {
	return this.credentialsNonExpired;
    }

    /**
     * @param credentialsNonExpired
     *            set true or false after checking the credential expiration
     *            info
     */
    public void setCredentialsNonExpired(final Boolean credentialsNonExpired) {
	this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * @return returns true or false after checking the credential expiration
     *         info
     */
    public boolean isCredentialsNonExpired() {
	return this.getCredentialsNonExpired();
    }

    /**
     * @return returns user account info based on whether it is enabled or not
     */
    @JsonIgnore
    public Boolean getEnabled() {
	return this.enabled;
    }

    /**
     * @param enabled
     *            sets user account info based on whether it is enabled or not
     */
    public void setEnabled(final Boolean enabled) {
	this.enabled = enabled;
    }

    /**
     * @return returns user account info based on whether it is enabled or not
     */
    public boolean isEnabled() {
	return this.getEnabled();
    }

}
