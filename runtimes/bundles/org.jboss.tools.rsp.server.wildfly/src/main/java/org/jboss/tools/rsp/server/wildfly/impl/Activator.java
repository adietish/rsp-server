/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/
package org.jboss.tools.rsp.server.wildfly.impl;

import org.jboss.tools.rsp.server.LauncherSingleton;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {
	private static final Logger LOG = LoggerFactory.getLogger(Activator.class);
	public static final String BUNDLE_ID = "org.jboss.tools.rsp.server.wildfly";
	
	@Override
	public void start(BundleContext context) throws Exception {
		LOG.info("Wildfly Server bundle started");
		ExtensionHandler.addExtensionsToModel(LauncherSingleton.getDefault().getLauncher().getModel());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}
}
