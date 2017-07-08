/* 
 * ===========================================================================
 * File Name AuthenticationRequest.java
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
 * $Log: AuthenticationRequest.java,v $
 * ===========================================================================
 */
package com.nextgen.model;


/**
 * This Model class created to hold the data for authentication request
 * 
 * @author umamaheswarar - Chetu
 * @version 1.0 - Aug 4, 2016
 */
public class AuthenticationRequest {

    private String username;
    private String password;

    /**
     * Default constructor
     */
    public AuthenticationRequest() {
        super();
    }

    /**
     * @param username 				accept username to initialize the username field
     * @param password				accept password to initialize the password field
     */
    public AuthenticationRequest(String username, String password) {
        this.username=username;
        this.password=password;
    }

    /**
     * @return						initialized value of the username field
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @param username				accept username to initialize the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return						initialized value of the password field
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password				accepts password to initialized the password field
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
