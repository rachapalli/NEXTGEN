/* 
 * ===========================================================================
 * File Name CustomerException.java
 * 
 * Created on Jul 21, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: CustomerException.java,v $
 * ===========================================================================
 */

package com.nextgen.exception;

/**
 * This class handles all the customer exceptions.
 * 
 * @author umamaheswarar 
 * @version 1.0 - Jul 21, 2016
 */

public class ApplicationCustomException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    /**
     * @return errorMessage of String Type
     */
    public String getErrorMessage() {
	return errorMessage;
    }

    /**
     * @param String
     *            type set into errorMessage
     */
    public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }

    public ApplicationCustomException() {
	super();
    }

    /**
     * @param errorMessage
     * @description
     */
    public ApplicationCustomException(String errorMessage) {
	super(errorMessage);
	this.errorMessage = errorMessage;
    }

}
