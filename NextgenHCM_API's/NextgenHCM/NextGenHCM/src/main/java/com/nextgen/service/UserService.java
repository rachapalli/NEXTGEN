/* 
 * ===========================================================================
 * File Name UserService.java
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
 * $Log: UserService.java,v $
 * ===========================================================================
 */

package com.nextgen.service;

import com.nextgen.dto.EmployeeAddressDTO;
import com.nextgen.dto.EmployeeDTO;
import com.nextgen.dto.JobChangeDTO;
import com.nextgen.dto.PayrollDTO;
import com.nextgen.dto.PositionDTO;
import com.nextgen.dto.TimeOffDTO;
import com.nextgen.dto.UserDTO;
import com.nextgen.exception.ApplicationCustomException;

/**
 * Service interface is to have all the abstract methods related to user.
 * 
 * @author umamaheswarar
 * @version 1.0 - Jul 22, 2016
 */

public interface UserService {

	/**This method is used to create a worker into the system.
	 * 
	 * @author umamaheswarar
	 * @param createEmployeeDTO						worker related information to create the worker
	 * @return createEmployeeDTO						worker information after creating the worker into the system.
	 * @throws ApplicationCustomException 
	 */
	public EmployeeDTO createEmployee(final EmployeeDTO createEmployeeDTO) throws ApplicationCustomException;
	
	/**This method is used to update a worker into the system.
	 * 
	 * @author umamaheswarar
	 * @param createEmployeeDTO						worker related information to create the worker
	 * @return createEmployeeDTO						worker information after creating the worker into the system.
	 * @throws ApplicationCustomException 
	 */
	public EmployeeDTO updateEmployee(final EmployeeDTO createEmployeeDTO) throws ApplicationCustomException;

	/**This method is used to get the user from system.
	 * 
	 * @author umamaheswarar
	 * @param username						username of the logged in user.
	 * @return UserDTO						user details.
	 */
	public UserDTO getUserDetails(final String username);

	/**This method is used to create a position into the system.
	 * 
	 * @author umamaheswarar
	 * @param positionDTO						position related information to create the position
	 * @return positionDTO						position information after creating into the system.
	 * @throws ApplicationCustomException 
	 */
	public PositionDTO createJobPosition(final PositionDTO positionDTO) throws ApplicationCustomException;

	/**This method is used to update a position into the system.
	 * 
	 * @author umamaheswarar
	 * @param positionDTO						position related information to update the position
	 * @return positionDTO						position information after updating into the system.
	 * @throws ApplicationCustomException 
	 */
	public PositionDTO updateJobPosition(final PositionDTO positionDTO) throws ApplicationCustomException;

	/**This method is used to manage the time off of the employees
	 * 
	 * @author umamaheswarar
	 * @param timeOffDTO					time off DTO object
	 * @return TimeOffDTO					time off details after saving the details 
	 */
	public TimeOffDTO manageTimeOff(final TimeOffDTO timeOffDTO) throws ApplicationCustomException;

	/**This method is used to change the employee job details
	 * 
	 * @author umamaheswarar
	 * @param jobChangeDTO							job change details
	 * @return jobChangeDTO							job change details after completion
	 * @throws ApplicationCustomException			custom application message in case of any exception
	 */
	public JobChangeDTO jobChange(JobChangeDTO jobChangeDTO) throws ApplicationCustomException;

	/**This method is used to change the address details of the employee
	 * 
	 * @author umamaheswarar
	 * @param employeeAddressDTO
	 * @return addressChangeEventId							address change event id
	 * @throws ApplicationCustomException					custom application exception message
	 */
	public String changeContactDetails(final EmployeeAddressDTO employeeAddressDTO) throws ApplicationCustomException;

	/**This method is used to manage the payroll of the employees
	 * 
	 * @author umamaheswarar
	 * @param payrollDTO					payrollDTO object
	 * @return payrollDTO					payroll details after saving the details 
	 */
	public PayrollDTO managePayroll(PayrollDTO payrollDTO) throws ApplicationCustomException;

}
