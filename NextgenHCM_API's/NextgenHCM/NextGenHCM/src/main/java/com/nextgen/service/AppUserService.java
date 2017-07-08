/* 
 * ===========================================================================
 * File Name AppUserService.java
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
 * $Log: AppUserService.java,v $
 * ===========================================================================
 */

package com.nextgen.service;

import com.nextgen.model.Employee;

/**
* This class implements the all method of require to provide the support to the security
* 
* @author umamaheswarar
* @version 1.0 - Aug 8, 2016
*
*/

public interface AppUserService {
	
	/**This method to load the user based on username
	 * @date Aug 8, 2016
	 * @param username				username to fetch the contact object form the database
	 * @return Contact object		contact object
	 */
	public Employee loadUserByUsername(final String username);

	/** This method is used to update the contact object
	 * @date Aug 8, 2016
	 * @param appUser			contact object as the appUser
	 * @return	number			long as 	
	 */
	public long post(final Employee appUser);

	/** To get the contact object form the database
	 * @date Aug 8, 2016
	 * @param id				id of the contact which is required to get
	 * @return	contact			contact oject
	 */
	public Employee get(long id);

	
	/**This method is to update the contact object
	 * 
	 * @date Aug 8, 2016
	 * @param appUser			contact object as appUser to update the contact
	 * @return contact			contact object is returned back
	 */
	public Employee patch(final Employee appUser);

	/**This method is used to delete the user 
	 * @param id				id to get the contact to delete
	 * @return boolean 			return true/false based on the opertion status
	 */
	public boolean delete(long id);
}
