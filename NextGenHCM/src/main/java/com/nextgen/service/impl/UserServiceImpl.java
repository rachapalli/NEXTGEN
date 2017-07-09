/* 
 * ===========================================================================
 * File Name UserServiceImpl.java
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
 * $Log: UserServiceImpl.java,v $
 * ===========================================================================
 */

package com.nextgen.service.impl;

import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextgen.dao.IBaseDAO;
import com.nextgen.dto.AddressBaseDTO;
import com.nextgen.dto.BaseAppDTO;
import com.nextgen.dto.EmployeeAddressDTO;
import com.nextgen.dto.EmployeeDTO;
import com.nextgen.dto.JobChangeDTO;
import com.nextgen.dto.JobProfileDTO;
import com.nextgen.dto.JobReasonDTO;
import com.nextgen.dto.PayrollDTO;
import com.nextgen.dto.PositionDTO;
import com.nextgen.dto.RegisterDTO;
import com.nextgen.dto.TimeOffDTO;
import com.nextgen.dto.TimeTypeDTO;
import com.nextgen.dto.UserDTO;
import com.nextgen.enums.BaseAppConstants;
import com.nextgen.exception.ApplicationCustomException;
import com.nextgen.model.Address;
import com.nextgen.model.AddressType;
import com.nextgen.model.AddressVisibility;
import com.nextgen.model.City;
import com.nextgen.model.Country;
import com.nextgen.model.Employee;
import com.nextgen.model.EmployeePayroll;
import com.nextgen.model.JobChangeDetail;
import com.nextgen.model.JobChangeReason;
import com.nextgen.model.JobProfile;
import com.nextgen.model.JobTitle;
import com.nextgen.model.Location;
import com.nextgen.model.Organization;
import com.nextgen.model.PayrollInputType;
import com.nextgen.model.PayrollRunType;
import com.nextgen.model.Position;
import com.nextgen.model.State;
import com.nextgen.model.TimeOff;
import com.nextgen.model.TimeOffType;
import com.nextgen.model.TimeType;
import com.nextgen.service.UserService;
import com.nextgen.utils.EncryptionUtility;
import com.nextgen.utils.Utility;

/**
 * Class have all the implementations for the user service methods which are
 * related to employee basic functionality.
 * 
 * @author umamaheswarar - Chetu
 * @version 1.0 - July 22, 2016
 */

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private IBaseDAO<Employee> employeeBaseDAO;
	@Autowired
	private IBaseDAO<EmployeePayroll> employeePayrollBaseDAO;
	@Autowired
	private IBaseDAO<City> cityBaseDAO;
	@Autowired
	private IBaseDAO<Country> countryBaseDAO;
	@Autowired
	private IBaseDAO<State> stateBaseDAO;
	@Autowired
	private IBaseDAO<JobTitle> jobTitleBaseDAO;
	@Autowired
	private IBaseDAO<JobProfile> jobProfileBaseDAO;
	@Autowired
	private IBaseDAO<Organization> organizationBaseDAO;
	@Autowired
	private IBaseDAO<Position> positionBaseDAO;
	@Autowired
	private IBaseDAO<Location> locationBaseDAO;
	@Autowired
	private IBaseDAO<TimeType> timeTypeBaseDAO;
	@Autowired
	private IBaseDAO<JobChangeReason> jobChangeReasonBaseDAO;
	@Autowired
	private IBaseDAO<TimeOffType> timeOffTypeBaseDAO;
	@Autowired
	private IBaseDAO<TimeOff> timeOffBaseDAO;
	@Autowired
	private IBaseDAO<JobChangeDetail> jobChangeDetailBaseDAO;
	@Autowired
	private IBaseDAO<Address> addressBaseDAO;
	@Autowired
	private IBaseDAO<AddressType> addressTypeBaseDAO;
	@Autowired
	private IBaseDAO<PayrollInputType> payrollInputTypeBaseDAO;
	@Autowired
	private IBaseDAO<PayrollRunType> payrollRunTypeBaseDAO;
	@Autowired
	private IBaseDAO<AddressVisibility> addressVisibilityBaseDAO;
	@Autowired
	private MessageSource source;
	@Autowired
	private IBaseDAO<Country> countryDao;
	@Autowired
	private IBaseDAO<State> StateDao;
	@Autowired
	private IBaseDAO<City> cityDao;

	/**
	 * This method is used to create a worker into the system.
	 * 
	 * @author umamaheswarar
	 * @param createWorkerDTO
	 *            worker related information to create the worker
	 * @return createEmployeeDTO worker information after creating the worker
	 *         into the system.
	 */
	@Override
	@Transactional
	public EmployeeDTO createEmployee(EmployeeDTO createEmployeeDTO) throws ApplicationCustomException {
		LOGGER.info("SERVICE : Inside create employee.");
		if (createEmployeeDTO != null) {
			// checking for the existing employee with the email id.
			final Employee existingUser = employeeBaseDAO.findUniqueByColumn(Employee.class, "username",
					createEmployeeDTO.getEmail());
			if (existingUser != null) {
				throw new ApplicationCustomException(source.getMessage("user.email.exists.message", null, null));
			}
		}
		if (createEmployeeDTO != null) {
			// checking for the existing employee with the email id.
			final Employee existingUser = employeeBaseDAO.findUniqueByColumn(Employee.class, "nationalId",
					createEmployeeDTO.getNationalId());
			if (existingUser != null) {
				throw new ApplicationCustomException(source.getMessage("user.national.exists.message", null, null));
			}
		}
		// creating new employee.
		final Employee contact = getContactFromWorkerDTO(createEmployeeDTO, null);
		if (contact != null) {
			employeeBaseDAO.save(contact);
			createEmployeeDTO.setId(contact.getId());
			createEmployeeDTO.setNationalId(contact.getNationalId());
			return createEmployeeDTO;
		} else {
			return null;
		}
	}

	/**
	 * This method is used to update a worker into the system.
	 * 
	 * @author umamaheswarar
	 * @param createWorkerDTO
	 *            worker related information to create the worker
	 * @return createEmployeeDTO worker information after creating the worker
	 *         into the system.
	 */
	@Override
	@Transactional
	public EmployeeDTO updateEmployee(final EmployeeDTO createEmployeeDTO) throws ApplicationCustomException {
		LOGGER.info("SERVICE : Inside update employee.");
		if (createEmployeeDTO != null) {
			if (createEmployeeDTO.getNationalId() != null && !createEmployeeDTO.getNationalId().equals("")) {
				final Employee existingUser = employeeBaseDAO.findUniqueByColumn(Employee.class, "nationalId",
						createEmployeeDTO.getNationalId());
				if (existingUser != null) {
					final Employee contact = getContactFromWorkerDTO(createEmployeeDTO, existingUser);
					if (contact != null) {
						employeeBaseDAO.saveOrUpdate(contact);
						createEmployeeDTO.setId(contact.getId());
						createEmployeeDTO.setNationalId(contact.getNationalId());
						return createEmployeeDTO;
					} else {
						return null;
					}
				}

			} else {
				throw new ApplicationCustomException(
						source.getMessage("employee.national.id.require.message", null, null));
			}
		} else {
			throw new ApplicationCustomException(source.getMessage("employee.not.exists.message", null, null));
		}
		return createEmployeeDTO;
	}

	/**
	 * This method is used to get the contact model object from worker DTO.
	 * 
	 * @param createEmployeeDTO
	 * @return contact contact model object
	 * @throws ApplicationCustomException
	 * @throws NoSuchMessageException
	 */
	private Employee getContactFromWorkerDTO(final EmployeeDTO createEmployeeDTO, Employee employee)
			throws NoSuchMessageException, ApplicationCustomException {
		LOGGER.info(" Service : inside getting employee model object from DTO");
		if (createEmployeeDTO != null) {
			if (employee == null) {
				employee = new Employee();
				employee.setCreateDate(new Date());
				employee.setNationalId(createEmployeeDTO.getNationalId());
			}
			employee.setAuthorities(BaseAppConstants.AUTHORITY_USER.getValue());
			if (createEmployeeDTO.getDob() != null) {
				employee.setDob(Utility.parseStringToUTCDate(createEmployeeDTO.getDob()));
			}
			employee.setUsername(createEmployeeDTO.getEmail());
			employee.setGender(createEmployeeDTO.getGender());
			if (createEmployeeDTO.getHireDate() != null) {
				employee.setHiredate(Utility.parseStringToUTCDate(createEmployeeDTO.getHireDate()));
			}
			employee.setFirstname(createEmployeeDTO.getFirstName());
			employee.setLastname(createEmployeeDTO.getLastName());
			employee.setMiddlename(createEmployeeDTO.getMiddleName());
			employee.setPhone(createEmployeeDTO.getPhone());
			employee.setAddressLineOne(createEmployeeDTO.getAddressLineOne());
			employee.setAddressLineTwo(createEmployeeDTO.getAddressLineTwo());
			employee.setZip(createEmployeeDTO.getZip());
			final BaseAppDTO cityDTO = createEmployeeDTO.getCity();
			if (cityDTO != null) {
				final City city = cityBaseDAO.findById(City.class, cityDTO.getId());
				if (city != null) {
					employee.setCity(city);
					cityDTO.setName(city.getName());
				}
			}
			final BaseAppDTO stateDTO = createEmployeeDTO.getState();
			if (stateDTO != null) {
				final State state = stateBaseDAO.findById(State.class, stateDTO.getId());
				if (state != null) {
					employee.setState(state);
					stateDTO.setName(state.getName());
				}
			}
			final BaseAppDTO countryDTO = createEmployeeDTO.getCountry();
			if (countryDTO != null) {
				final Country country = countryBaseDAO.findById(Country.class, countryDTO.getId());
				if (country != null) {
					employee.setCountry(country);
					countryDTO.setName(country.getCountry_name());
				}
			}

			return employee;
		} else {
			return null;
		}
	}

	/**
	 * This method is used to get worker info from the system.
	 * 
	 * @author umamaheswarar
	 * @param username
	 *            username of the logged in user.
	 * @return UserDTO user details.
	 */
	@Override
	@Transactional
	public UserDTO getUserDetails(final String username) {
		LOGGER.info("SERVICE : Inside getting user details.");
		final Employee employee = employeeBaseDAO.findUniqueByColumn(Employee.class, "username", username);
		if (employee != null) {
			final UserDTO user = new UserDTO();
			user.setId(employee.getId());
			user.setFirstName(employee.getFirstname());
			user.setMiddleName(employee.getMiddlename());
			user.setLastName(employee.getLastname());
			return user;
		}
		return null;
	}

	/**
	 * This method is used to create a position into the system.
	 * 
	 * @author umamaheswarar
	 * @param positionDTO
	 *            position related information to create the position
	 * @return positionDTO position information after creating into the system.
	 * @throws ApplicationCustomException
	 */
	@Override
	@Transactional
	public PositionDTO createJobPosition(final PositionDTO positionDTO) throws ApplicationCustomException {
		LOGGER.info("SERVICE : Inside create job position...");
		if (positionDTO != null) {
			// getting the Model object from DTO object.
			final Position position = getPositionFromPositionDTO(positionDTO, null);
			if (position != null) {
				positionBaseDAO.save(position);
				positionDTO.setId(position.getId());
				return positionDTO;
			} else {
				return null;
			}
		} else {
			throw new ApplicationCustomException(source.getMessage("position.details.blank.message", null, null));
		}
	}

	/**
	 * This method is used to update a position into the system.
	 * 
	 * @author umamaheswarar
	 * @param positionDTO
	 *            position related information to update the position
	 * @return positionDTO position information after updating into the system.
	 * @throws ApplicationCustomException
	 */
	@Override
	@Transactional
	public PositionDTO updateJobPosition(final PositionDTO positionDTO) throws ApplicationCustomException {
		LOGGER.info("SERVICE : Inside update position into the system.");
		if (positionDTO != null) {
			Position position = positionBaseDAO.findById(Position.class, positionDTO.getId());
			// Before going to update, checking whether the position exists into
			// the system or not
			if (position != null) {
				// Getting the model object from DTO object.
				position = getPositionFromPositionDTO(positionDTO, position);
				if (position != null) {
					positionBaseDAO.saveOrUpdate(position);
					return positionDTO;
				} else {
					return null;
				}
			} else {
				throw new ApplicationCustomException(source.getMessage("position.not.exists.message", null, null));
			}
		} else {
			throw new ApplicationCustomException(source.getMessage("position.details.blank.message", null, null));
		}
	}

	/**
	 * This method is used to get the position model object from position DTO.
	 * 
	 * @author umamaheswarar
	 * @param positionDTO
	 *            position details DTO
	 * @return position position model object
	 */
	private Position getPositionFromPositionDTO(final PositionDTO positionDTO, Position position) {
		LOGGER.info("SERVICE : In side getting position model object from DTO.");
		if (positionDTO != null) {
			if (position == null) {
				position = new Position();
				position.setCreateDate(new Date());
			}
			position.setAvailabilityDate(Utility.parseStringToUTCDate(positionDTO.getAvailabilityDate()));
			final BaseAppDTO jobPostingTitle = positionDTO.getJobPostingTitle();
			if (jobPostingTitle != null) {
				final JobTitle jobTitle = jobTitleBaseDAO.findById(JobTitle.class, jobPostingTitle.getId());
				if (jobTitle != null) {
					position.setJobPostingTitle(jobTitle);
					jobPostingTitle.setName(jobTitle.getName());
				}
			}
			final JobProfileDTO jobProfileDTO = positionDTO.getJobProfile();
			if (jobProfileDTO != null) {
				final JobProfile jobProfile = jobProfileBaseDAO.findById(JobProfile.class, jobProfileDTO.getId());
				if (jobProfile != null) {
					position.setJobProfile(jobProfile);
					jobProfileDTO.setName(jobProfile.getName());
					jobProfileDTO.setDescription(jobProfile.getDescription());
				}
			}
			position.setName(positionDTO.getPositionName());
			final BaseAppDTO organizationDTO = positionDTO.getOrganization();
			if (organizationDTO != null) {
				final Organization organization = organizationBaseDAO.findById(Organization.class,
						organizationDTO.getId());
				if (organization != null) {
					position.setOrganization(organization);
					organizationDTO.setName(organization.getName());
				}
			}
			position.setPositionCode(positionDTO.getPositionCode());
			position.setPositionRequestReason(positionDTO.getPositionRequestReason());
			final TimeTypeDTO timeTypeDTO = positionDTO.getTimeType();
			if (timeTypeDTO != null) {
				final TimeType timeType = timeTypeBaseDAO.findById(TimeType.class, timeTypeDTO.getId());
				position.setTimeType(timeType);
				timeTypeDTO.setTimeType(timeType.getTimeType());
			}
			final BaseAppDTO locationDTO = positionDTO.getLocation();
			if (locationDTO != null) {
				final Location location = locationBaseDAO.findById(Location.class, locationDTO.getId());
				if (location != null) {
					position.setLocation(location);
					locationDTO.setName(location.getName());
				}
			}
			return position;
		} else {
			return null;
		}
	}

	/**
	 * This method is used to manage the time off of the employees
	 * 
	 * @author umamaheswarar
	 * @param timeOffDTO
	 *            time off DTO object
	 * @return TimeOffDTO time off details after saving the details
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, ApplicationCustomException.class })
	public TimeOffDTO manageTimeOff(final TimeOffDTO timeOffDTO) throws ApplicationCustomException {
		LOGGER.info("SERVICE : inside manage timeoff details of employee...");
		TimeOff timeOff = null;
		Boolean isNew = Boolean.FALSE;
		if (timeOffDTO.getId() != null) {
			timeOff = timeOffBaseDAO.findById(TimeOff.class, timeOffDTO.getId());
		}
		if (timeOff == null) {
			timeOff = new TimeOff();
			isNew = Boolean.TRUE;
		}
		setTimeOffFromTimeOffDTO(timeOffDTO, timeOff);
		if (isNew) {
			final BaseAppDTO employeeDTO = timeOffDTO.getEmployee();
			if (employeeDTO != null) {
				final Employee employee = employeeBaseDAO.findById(Employee.class, employeeDTO.getId());
				if (employee != null) {
					timeOffBaseDAO.save(timeOff);
					// setting the time off event id
					String timeOffEventId = employee.getId() + BaseAppConstants.UNDERSCORE.getValue()
							+ BaseAppConstants.TIME_OFF.getValue() + BaseAppConstants.UNDERSCORE.getValue()
							+ timeOff.getId();
					timeOff.setTimeOffEventId(timeOffEventId);
					timeOffDTO.setTimeOffEventId(timeOffEventId);
				}
				timeOffBaseDAO.save(timeOff);
				timeOffDTO.setId(timeOff.getId());
			}
		} else {
			timeOffBaseDAO.saveOrUpdate(timeOff);
		}

		return timeOffDTO;
	}

	/**
	 * This method is used to get the position model object from position DTO.
	 * 
	 * @author umamaheswarar
	 * @param timeOffDTO
	 *            time off DTO object
	 * @throws ApplicationCustomException
	 * @throws NoSuchMessageException
	 */
	private void setTimeOffFromTimeOffDTO(final TimeOffDTO timeOffDTO, TimeOff timeOff)
			throws NoSuchMessageException, ApplicationCustomException {
		LOGGER.info("SERVICE : In side getting time off model object from DTO.");
		if (timeOffDTO != null) {
			final BaseAppDTO employeeDTO = timeOffDTO.getEmployee();
			if (employeeDTO != null) {
				final Employee employee = employeeBaseDAO.findById(Employee.class, employeeDTO.getId());
				if (employee != null) {
					timeOff.setCreateDate(new Date());
					timeOff.setDailyQuantity(timeOffDTO.getDailyQuantity());
					timeOff.setEmployee(employee);
					timeOff.setFromDate(Utility.parseStringToUTCDate(timeOffDTO.getFromDate()));
					timeOff.setToDate(Utility.parseStringToUTCDate(timeOffDTO.getToDate()));
					timeOff.setReason(timeOffDTO.getReason());
					final BaseAppDTO timeOffTypeDTO = timeOffDTO.getTimeOffType();
					if (timeOffTypeDTO != null) {
						final TimeOffType timeOffType = timeOffTypeBaseDAO.findById(TimeOffType.class,
								timeOffTypeDTO.getId());
						timeOff.setTimeOffType(timeOffType);
					}
				} else {
					throw new ApplicationCustomException(source.getMessage("employee.not.exists.message", null, null));
				}
			} else {
				throw new ApplicationCustomException(source.getMessage("employee.dto.empty.message", null, null));
			}
		}
	}

	/**
	 * This method is used to change the employee job details
	 * 
	 * @author umamaheswarar
	 * @param jobChangeDTO
	 *            job change details
	 * @return jobChangeDTO job change details after completion
	 * @throws ApplicationCustomException
	 *             custom application message in case of any exception
	 */
	@Override
	@Transactional
	public JobChangeDTO jobChange(final JobChangeDTO jobChangeDTO) throws ApplicationCustomException {
		LOGGER.info("SERVICE : In side jobChange method...");
		final BaseAppDTO employeeDTO = jobChangeDTO.getEmployee();
		if (employeeDTO != null) {
			final Employee employee = employeeBaseDAO.findById(Employee.class, employeeDTO.getId());
			if (employee != null) {
				final JobChangeDetail jobChangeDetail = new JobChangeDetail();
				final JobReasonDTO jobChangeReasonDTO = jobChangeDTO.getReason();
				if (jobChangeReasonDTO != null) {
					final JobChangeReason reason = jobChangeReasonBaseDAO.findById(JobChangeReason.class,
							jobChangeReasonDTO.getId());
					jobChangeDetail.setReason(reason);
					jobChangeReasonDTO.setReason(reason.getReason());
				}
				final BaseAppDTO jobLocationDTO = jobChangeDTO.getProposedLocation();
				if (jobLocationDTO != null) {
					final Location proposedLocation = locationBaseDAO.findById(Location.class, jobLocationDTO.getId());
					jobChangeDetail.setProposedLocation(proposedLocation);
					jobLocationDTO.setName(proposedLocation.getName());
				}

				final BaseAppDTO proposedManagerDTO = jobChangeDTO.getProposedManager();
				if (proposedManagerDTO != null) {
					final Employee proposedManager = employeeBaseDAO.findById(Employee.class,
							proposedManagerDTO.getId());
					jobChangeDetail.setProposedManager(proposedManager);
				}
				jobChangeDetail.setChangeDate(new Date());
				jobChangeDetail.setEmployee(employee);
				jobChangeDetail.setEffectiveDate(Utility.parseStringToUTCDate(jobChangeDTO.getEffectiveDate()));
				jobChangeDetailBaseDAO.save(jobChangeDetail);

				final String jobChangeEventId = employee.getId() + BaseAppConstants.UNDERSCORE.getValue()
						+ BaseAppConstants.JOB_CHANGE.getValue() + BaseAppConstants.UNDERSCORE.getValue()
						+ jobChangeDetail.getId();
				jobChangeDetail.setJobChangeEventId(jobChangeEventId);

				jobChangeDetailBaseDAO.save(jobChangeDetail);
				jobChangeDTO.setId(jobChangeDetail.getId());
				jobChangeDTO.setJobChangeEventId(jobChangeDetail.getJobChangeEventId());
				jobChangeDTO.setEffectiveDate(Utility.parseUTCDateToString(jobChangeDetail.getEffectiveDate()));
				return jobChangeDTO;
			} else {
				throw new ApplicationCustomException(source.getMessage("employee.not.exists.message", null, null));
			}
		} else {
			throw new ApplicationCustomException(source.getMessage("employee.dto.empty.message", null, null));
		}
	}

	/**
	 * This method is used to change the address details of the employee
	 * 
	 * @author umamaheswarar
	 * @param employeeAddressDTO
	 * @return addressChangeEventId address change event id
	 * @throws ApplicationCustomException
	 *             custom application exception message
	 */
	@Override
	@Transactional
	public String changeContactDetails(final EmployeeAddressDTO employeeAddressDTO) throws ApplicationCustomException {
		LOGGER.info("SERVICE : Inside the change contact details...");
		if (employeeAddressDTO != null) {
			final Long employeeId = employeeAddressDTO.getEmployeeId();
			final Employee employee = employeeBaseDAO.findById(Employee.class, employeeId);
			if (employee != null) {
				final AddressBaseDTO addressDTO = employeeAddressDTO.getAddress();
				if (addressDTO != null) {
					final Address address = new Address();
					setAddressFromDTO(address, addressDTO);
					address.setEmployee(employee);
					addressBaseDAO.save(address);

					address.setAddressChangeEventId(employee.getId() + BaseAppConstants.UNDERSCORE.getValue()
							+ BaseAppConstants.ADDRESS_CHANGE.getValue() + BaseAppConstants.UNDERSCORE.getValue()
							+ address.getId());
					addressBaseDAO.save(address);
					return address.getAddressChangeEventId();
				} else {
					throw new ApplicationCustomException(
							source.getMessage("employee.address.details.empty.message", null, null));
				}
			} else {
				throw new ApplicationCustomException(source.getMessage("employee.not.exists.message", null, null));
			}
		}
		throw new ApplicationCustomException(source.getMessage("employee.dto.empty.message", null, null));
	}

	/**
	 * This method is used to get the updated address model from address DTO
	 * object
	 * 
	 * @author umamaheswarar
	 * @param address
	 *            address model object
	 * @param addressDTO
	 *            address DTO object
	 */
	private void setAddressFromDTO(final Address address, final AddressBaseDTO addressDTO) {
		LOGGER.info("SERVICE: Inside setting address details model object");
		if (address != null) {
			final BaseAppDTO addressType = addressDTO.getType();
			if (addressType != null) {
				final AddressType type = addressTypeBaseDAO.findById(AddressType.class, addressType.getId());
				if (type != null) {
					address.setType(type);
					addressType.setName(type.getType());
				}
			}
			final BaseAppDTO addressUsage = addressDTO.getUsage();
			if (addressUsage != null) {
				/*
				 * final AddressUsage usage =
				 * addressUsageBaseDAO.findById(AddressUsage.class,
				 * addressUsage.getId()); if(usage!=null){
				 * address.setAddressUsage(usage);
				 * addressUsage.setName(usage.getUsage()); }
				 */
			}
			final BaseAppDTO addressVisibility = addressDTO.getVisibility();
			if (addressVisibility != null) {
				final AddressVisibility visibility = addressVisibilityBaseDAO.findById(AddressVisibility.class,
						addressVisibility.getId());
				if (visibility != null) {
					address.setVisibility(visibility);
					addressVisibility.setName(visibility.getVisibility());
				}
			}
			final BaseAppDTO cityDTO = addressDTO.getCity();
			if (cityDTO != null) {
				final City city = cityBaseDAO.findById(City.class, cityDTO.getId());
				if (city != null) {
					address.setCity(city);
					cityDTO.setName(city.getName());
				}
			}
			final BaseAppDTO stateDTO = addressDTO.getState();
			if (stateDTO != null) {
				final State state = stateBaseDAO.findById(State.class, stateDTO.getId());
				if (state != null) {
					address.setState(state);
					stateDTO.setName(state.getName());
				}
			}
			final BaseAppDTO countryDTO = addressDTO.getCountry();
			if (countryDTO != null) {
				final Country country = countryBaseDAO.findById(Country.class, countryDTO.getId());
				if (country != null) {
					address.setCountry(country);
					countryDTO.setName(country.getCountry_name());
				}
			}
			address.setCreateDate(new Date());
			address.setAddressLineOne(addressDTO.getAddressLineOne());
			address.setAddressLineTwo(addressDTO.getAddressLineTwo());
			address.setZip(addressDTO.getZip());
		}
	}

	/**
	 * This method is used to manage the payroll of the employees
	 * 
	 * @author umamaheswarar
	 * @param payrollDTO
	 *            payrollDTO object
	 * @return payrollDTO payroll details after saving the details
	 */
	@Override
	@Transactional
	public PayrollDTO managePayroll(final PayrollDTO payrollDTO) throws ApplicationCustomException {
		LOGGER.info("SERVICE : Inside manage payroll details...");
		final Employee employee = employeeBaseDAO.findById(Employee.class, payrollDTO.getEmployeeId());
		if (employee != null) {
			final EmployeePayroll employeePayroll = new EmployeePayroll();
			employeePayroll.setEmployee(employee);
			employeePayroll.setCreateDate(new Date());
			final BaseAppDTO inputType = payrollDTO.getInputType();
			if (inputType != null) {
				final PayrollInputType payrollInputType = payrollInputTypeBaseDAO.findById(PayrollInputType.class,
						inputType.getId());
				if (payrollInputType != null) {
					employeePayroll.setInputType(payrollInputType);
					inputType.setName(payrollInputType.getType());
				}
			}
			final BaseAppDTO runType = payrollDTO.getRunType();
			if (runType != null) {
				final PayrollRunType payrollRunType = payrollRunTypeBaseDAO.findById(PayrollRunType.class,
						runType.getId());
				if (payrollRunType != null) {
					employeePayroll.setRunType(payrollRunType);
					runType.setName(payrollRunType.getType());
				}
			}
			employeePayroll.setInputValue(payrollDTO.getInputValue());
			employeePayroll.setPayComponentCode(payrollDTO.getPayComponentCode());
			employeePayroll.setStartDate(Utility.parseStringToUTCDate(payrollDTO.getStartDate()));
			employeePayroll.setEndDate(Utility.parseStringToUTCDate(payrollDTO.getEndDate()));
			employeePayrollBaseDAO.save(employeePayroll);
			final String payrollInputEventId = employee.getId() + BaseAppConstants.UNDERSCORE.getValue()
					+ BaseAppConstants.PAYROLL_INPUT.getValue() + BaseAppConstants.UNDERSCORE.getValue()
					+ employeePayroll.getId();
			employeePayroll.setPayrollInputEventId(payrollInputEventId);
			employeePayrollBaseDAO.save(employeePayroll);
			payrollDTO.setPayrollInputEventId(employeePayroll.getPayrollInputEventId());
			payrollDTO.setId(employeePayroll.getId());
			return payrollDTO;
		} else {
			throw new ApplicationCustomException(source.getMessage("employee.not.exists.message", null, null));
		}
	}

	@Override
	@Transactional
	public boolean register(RegisterDTO registerDTO) throws ApplicationCustomException, HibernateException, SQLException {
		Employee employee = employeeBaseDAO.findUniqueByColumn(Employee.class, "username", registerDTO.getEmail());
		if (employee != null) {
			throw new ApplicationCustomException("Email arleady registered, please check!");
		}
		employee = new Employee();
		employee.setFirstname(registerDTO.getFirstName());
		employee.setLastname(registerDTO.getLastName());
		employee.setUsername(registerDTO.getEmail());
		employee.setPassword(EncryptionUtility.encrypt(registerDTO.getPassword()));
		employee.setCountry(countryDao.findById(Country.class, registerDTO.getCountry()));
		employee.setState(stateBaseDAO.findById(State.class, registerDTO.getState()));
		employee.setCity(cityBaseDAO.findById(City.class, registerDTO.getCity()));
		employeeBaseDAO.save(employee);
		return true;
	}

}
