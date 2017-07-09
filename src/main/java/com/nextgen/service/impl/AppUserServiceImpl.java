/* 
 * ===========================================================================
 * File Name AppUserServiceImpl.java
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
 * $Log: AppUserServiceImpl.java,v $
 * ===========================================================================
 */

package com.nextgen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextgen.dao.IBaseDAO;
import com.nextgen.model.Employee;
import com.nextgen.service.AppUserService;

/**
 * This class implements the all method of AppUserService interface to provide
 * the support for security
 * 
 * @author umamaheswarar
 * @version 1.0 - Aug 8, 2016
 */

@Service(value = "appUserService")
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private IBaseDAO<Employee> employeeBaseDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nextgen.service.AppUserService#loadUserByUsername(java.lang.String)
	 */
	@Override
	@Transactional
	public Employee loadUserByUsername(String username) {
		return (Employee) employeeBaseDAO.findUniqueByColumn(Employee.class, "username", username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nextgen.service.AppUserService#post(com.nextgen.model.Contact)
	 */
	@Override
	public long post(Employee appUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nextgen.service.AppUserService#get(long)
	 */
	@Override
	public Employee get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nextgen.service.AppUserService#patch(com.nextgen.model.Contact)
	 */
	@Override
	public Employee patch(Employee appUser) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nextgen.service.AppUserService#delete(long)
	 */
	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
