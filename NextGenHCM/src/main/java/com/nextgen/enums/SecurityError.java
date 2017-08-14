/* 
 * ===========================================================================
 * File Name SecurityError.java
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
 * $Log: SecurityError.java,v $
 * ===========================================================================
 */

package com.nextgen.enums;

import org.springframework.http.HttpStatus;

/**
 * Enum contains all the response codes along with messages.
 * 
 * @author umamaheswarar 
 * @version 1.0 - Jul 21, 2016
 */

public enum SecurityError {
    
    	    NO_DATA(HttpStatus.OK, 404100, "No Data found."),
    	    NO_SIGN_IN_DATA(HttpStatus.UNAUTHORIZED, 404101, "No token was provided"),
	    WRONG_PASSWORD(HttpStatus.UNAUTHORIZED, 404102, "Wrong login or password"),
	    WRONG_LOGIN(HttpStatus.NOT_FOUND, 404103, "User with given login was not found"),
	    ROLE_ACCESS_DENIED(HttpStatus.UNAUTHORIZED, 404104, "no! no! no! Don't Play With My Heart"),
	    USER_WAS_BLOCKED(HttpStatus.UNAUTHORIZED, 404105, "This user was blocked"),
	    EMAIL_NOT_VERIFIED(HttpStatus.UNAUTHORIZED, 404106, "Please verify your email"),
	    PHONE_NOT_VERIFIED(HttpStatus.UNAUTHORIZED, 404107, "Please verify your phone number"),
	    AWAITING_APPROVAL(HttpStatus.UNAUTHORIZED, 404108, "Waiting for approval"),
	    
	    TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, 404110, "Token was not found"),
	    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, 404111, "Token has been expired"),
	    WRONG_FACEBOOK_LOGIN(HttpStatus.NOT_FOUND, 404112, "Please login as facebook user"),
	    WRONG_EMAIL_LOGIN(HttpStatus.NOT_FOUND, 404113, "Please login using you Email/Phone Number"),
	    FILE_NOT_FOUND(HttpStatus.NOT_FOUND, 4041114, "File not found."),
	    IO_EXCEPTION(HttpStatus.NO_CONTENT, 4041115, "No writing file or closing file."),
	    
	    LOGIN_SUCCESS(HttpStatus.OK, 200001, "User is successfully logged in."),
	    LOGOUT_SUCCESS(HttpStatus.OK, 200102, "User is successfully logged out."),
	    
	    WRONG_LOGIN_TYPE_CLIENT(HttpStatus.UNAUTHORIZED, 404118, "Please login as Client"),
	    WRONG_LOGIN_TYPE_TRAINER(HttpStatus.UNAUTHORIZED, 404119, "Please login as Trainer"),
	    INVALID_DATA(HttpStatus.BAD_REQUEST, 400203, "Invalid data was provided"),

	    INVALID_EMAIL_CONFIRMATION_KEY(HttpStatus.BAD_REQUEST, 400214, "Email confirmation key is invalid"),
	    EXPIRED_EMAIL_CONFIRMATION_KEY(HttpStatus.BAD_REQUEST, 400215, "Email confirmation key has expired"),
	    INVALID_PHONE_CONFIRMATION_KEY(HttpStatus.BAD_REQUEST, 400216, "Phone confirmation key is invalid"),
	    EXPIRED_PHONE_CONFIRMATION_KEY(HttpStatus.BAD_REQUEST, 400217, "Phone confirmation key has expired"),
	    FACEBOOK_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, 404115, "Facebook Token has expired"),
	    TEMPORARY_PASSWORD_EXPIRED(HttpStatus.UNAUTHORIZED, 404116, "Temporary password has expired"),
	    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, 400014, "Password should contains from 8 to 20 symbols with at least 1 capital letter and at least 1 numeric symbol."),
	    INVALID_GYM(HttpStatus.BAD_REQUEST, 400015, "Gym is required for trainer"),
	    INVALID_GYM_1(HttpStatus.BAD_REQUEST, 400016, "Gym is required for trainer - no gym in database"),
	    INVALID_GYM_2(HttpStatus.BAD_REQUEST, 400017, "Gym is required for trainer - exception"),
	    INVALID_NEW_PASSWORD(HttpStatus.BAD_REQUEST, 400001, "New password is invalid"),
	    INVALID_EMAIL_FORMAT(HttpStatus.BAD_REQUEST, 400013, "Invalid email format"),

	    INVALID_FIELDS_FORMAT(HttpStatus.BAD_REQUEST, 400600, "Invalid fields format"),
	    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, 409101, "User with this login data already exist"),
	    EMAIL_VERIFIED_ALREADY(HttpStatus.CONFLICT, 409102, "Email was verified already"),
	    COLLECTION_CONFLICT(HttpStatus.CONFLICT, 409103, "Collection with the tis name is already present under this policy."),
	    CANT_DELETE_USER_WITH_BOOKINGS(HttpStatus.CONFLICT, 409104, "Can't delete user with future bookings"),
	    CANT_DELETE_USER_WITH_OPEN_TRANSACTIONS(HttpStatus.BAD_REQUEST, 409105, "Can't delete user with open transactions"),
	    CANT_CHANGE_SETTINGS(HttpStatus.CONFLICT, 409106, "Can't change settings gym or trainer"),
	    INSURANCE_ALREADY_REGISTERED(HttpStatus.CONFLICT, 409107, "This insurance account is already register with us."),
	    UPDATE_REQUIRED(HttpStatus.FORBIDDEN, 403000, "Please update your application"),
	    INVALID_USER_PERMISSION(HttpStatus.FORBIDDEN, 403001, "Invalid user permission"),
	    INVALID_AVATAR_TYPE(HttpStatus.BAD_REQUEST, 400010, "Invalid file type for user avatar"),
	    INVALID_TIME_FORMAT(HttpStatus.BAD_REQUEST, 400011, "Invalid date format"),
	    NO_SUCH_USER(HttpStatus.FORBIDDEN, 403012, "Please check the details you have provided, user name is wrong!"),
	    SECURITY_KEY_NOT_FOUND(HttpStatus.FORBIDDEN, 403013, "No valid secret key found!!! Please request to again to reset password."),
	    
	    WRONG_AUTHORIZED_PASSWORD(HttpStatus.BAD_REQUEST, 400202, "Wrong password"),

	    OPERATION_FAILED(HttpStatus.BAD_REQUEST, 400203, "The current operation is failed."),
	    OPERATION_SUCCESS(HttpStatus.OK, 200001, "The current operation is successfully completed."),
	    OPERATION_SUCCESS_WITH_ERROR(HttpStatus.OK, 200002, "The current operation is successfully completed with some error."),
	    OPERATION_SUCCESS_PARTIAL_COVERAGE(HttpStatus.OK, 200003, "Some of the coverage limits are not available or already removed."),

	    INVALID_PHONE_NUMBER(HttpStatus.BAD_REQUEST, 400300, "Invalid phone number. It should contains  + sign, country code and local number"),
	    NO_LOGIN_DATA(HttpStatus.BAD_REQUEST, 400301, "No login data was provided"),
	    INVALID_LOGIN(HttpStatus.BAD_REQUEST, 400302, "Invalid username or password!!!"),
	    PROPERTY_NOT_FOUND(HttpStatus.NOT_FOUND, 400304, "No matched property found for the message."),
	    NO_PROPERTY_MATCHED(HttpStatus.NOT_FOUND, 400305, "Please verify the request . . ."),

	    ALREADY_SCHEDULED(HttpStatus.CONFLICT, 409107, "This item is already scheduled."),
	    ALREADY_EXIST(HttpStatus.CONFLICT, 409107, "Already Exist."),
	    INVALID_UUID(HttpStatus.CONFLICT, 409108, "Invalid uuid"),
	    UUID_NOT_MATCHED(HttpStatus.SEE_OTHER, 409109, "UUID's are not matched"),
	    INVALID_TYPE(HttpStatus.SEE_OTHER, 409110, "Invalid type has been provided"),
	    INVALID_PROMO_CODE(HttpStatus.NOT_FOUND, 409110, "Invalid Promo has been provided"),
	    NOT_EXIST(HttpStatus.NOT_FOUND, 409111, "This item doesn't exist"),
	    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500100, "Please contact administrator . . ."),
	    LOGOUT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500101, "Something went wrong in logging out..."),
	    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500102, "Some error in Database Side..."),
	    BAD_URL(HttpStatus.BAD_REQUEST, 500404, "Contact Admin : You are trying to access an resource");

	    private HttpStatus status;
	    private int code;
	    private String description;

	    SecurityError(HttpStatus status, int code, String description) {
	        this.status = status;
	        this.code = code;
	        this.description = description;
	    }

	  	    public int getCode() {
	        return code;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public HttpStatus getHttpStatus() {
	        return status;
	    }
	}
