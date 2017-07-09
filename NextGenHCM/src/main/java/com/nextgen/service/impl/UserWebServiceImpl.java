/* 
 * ===========================================================================
 * File Name UserWebServiceImpl.java
 * 
 * Created on Aug 8, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: UserWebServiceImpl.java,v $
 * ===========================================================================
 */

package com.nextgen.service.impl;

import org.springframework.stereotype.Service;

import com.nextgen.dto.ContactDTO;
import com.nextgen.service.UserWebService;

/**
 * This class implements the all method of UserWebService interface
 * 
 * @author vikashk3 - Chetu
 * @version 1.0 - Aug 8, 2016
 */
@Service
public class UserWebServiceImpl implements UserWebService {

	/* (non-Javadoc)
	 * @see com.nextgen.service.UserWebService#getUserPermissions(java.lang.String)
	 */
	@Override
	public ContactDTO getUserPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
