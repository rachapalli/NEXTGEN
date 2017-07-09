/* 
 * ===========================================================================
 * File Name UserWebService.java
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
 * $Log: UserWebService.java,v $
 * ===========================================================================
 */
/**
* Class Information
* @author vikashk3 - Chetu
* @version 1.0 - Aug 8, 2016
*/
package com.nextgen.service;

import com.nextgen.dto.ContactDTO;

public interface UserWebService {

	/**
	 * This Service method created for implement the getting permissions for the
	 * user
	 * 
	 * @author umamaheswarar
	 * @date August 11, 2016
	 * @return <code>ContactDTO</code> Agent information are returning.
	 * @throws HibernateException
	 *             if any problem with database query
	 * @param username
	 *            passing username
	 */

	public ContactDTO getUserPermissions(String username);

}
