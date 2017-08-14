/* 
 * ===========================================================================
 * File Name NotificationBaseConstants.java
 * 
 * Created on Oct 11, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: NotificationBaseConstants.java,v $
 * ===========================================================================
 */

package com.nextgen.enums;

/**
 * Enum for used in Notification
 * 
 * @author umamaheswarar 
 * @version 1.0 - Feb 11, 2016
 */

public enum NotificationBaseConstants {

    NOTIFICATION_SUBJECT_CLAIM("CLAIM"),
    NOTIFICATION_SUBJECT_COMPANY("COMPANY"),
    NOTIFICATION_SUBJECT_INVOICE("INVOICE"),
    NOTIFICATION_SUBJECT_POLICY("POLICY"),
    NOTIFICATION_TYPE_ALERT("ALERT"),
    NOTIFICATION_TYPE_EVENT("EVENT"),
    NOTIFICATION_TYPE_NOTIFICATION("NOTIFICATION"),
    NOTIFICATION_TYPE_REMINDER("REMINDER");

    private String value;

    NotificationBaseConstants(String value) {
	this.value = value;

    }

    public String getValue() {
	return value;
    }

}
