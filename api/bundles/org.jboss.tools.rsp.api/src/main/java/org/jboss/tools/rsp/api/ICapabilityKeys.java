/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/
package org.jboss.tools.rsp.api;

public interface ICapabilityKeys {
	/*
	 * A list of possible capability keys
	 */
	
	/**
	 * A capability key expecting a three-segment or four-segment version string
	 */
	public static final String STRING_PROTOCOL_VERSION = "protocol.version";
	public static final String PROTOCOL_VERSION_0_9_0 = "0.9.0";
	public static final String PROTOCOL_VERSION_0_10_0 = "0.10.0";
	public static final String PROTOCOL_VERSION_CURRENT = PROTOCOL_VERSION_0_10_0;
	
	/**
	 * A capability key expecting a boolean in string form 
	 * whether the client can prompt the user for a string with a given message
	 */
	public static final String BOOLEAN_STRING_PROMPT = "prompt.string";
}
