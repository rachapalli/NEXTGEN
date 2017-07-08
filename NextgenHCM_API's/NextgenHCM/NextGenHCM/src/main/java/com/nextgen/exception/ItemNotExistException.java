/* 
 * ===========================================================================
 * File Name ItemNotExistexception.java
 * 
 * Created on Nov 2, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: ItemNotExistexception.java,v $
 * ===========================================================================
 */
 
 package com.nextgen.exception;
 
 /**
  * This class handle item not found exception
  *  
  * @author vikashk3 - Chetu
  * @version 1.0 - Nov 2, 2016
  */
 public class ItemNotExistException extends Exception{
	 
	 /** long Short Description */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	 public ItemNotExistException(){
		 super();
	 }
	 
	 public ItemNotExistException(String errorMessage){
		 super(errorMessage);
		 this.errorMessage=errorMessage;
	 }

	/**
	 * @return erorMessage of String Type
	 */
	public String getErorMessage() {
		return errorMessage;
	}

	/**
	 * @param String type set into erorMessage 
	 */
	public void setErorMessage(String erorMessage) {
		this.errorMessage = erorMessage;
	}

}
