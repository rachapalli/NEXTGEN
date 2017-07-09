/* 
 * ===========================================================================
 * File Name TemplateType.java
 * 
 * Created on Aug 19, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of NextGenHCM. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of NextGenHCM.
 *
 * Copyright (C) NextGenHCM. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: TemplateType.java,v $
 * ===========================================================================
 */

package com.nextgen.enums;

/**
 * This enum is used to identify the template types for scheduled item for additional info
 * 
 * @author umamaheswarar
 *
 */
public enum TemplateType {
	GENERAL, // No Special Item
	DIAMOND_ONLY, 
	DIAMOND_AND_GEMSTONES, 
	GEMSTONES_ONLY, 
	PAINTING, 
	PRINT_AND_POSTER, 
	DRAWINGS, 
	POTTERY, 
	SCULPTURE,
	WINE
};
