/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/
package org.jboss.tools.rsp.server.wildfly.test.servertype;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Collections;

import org.jboss.tools.rsp.server.spi.discovery.IServerBeanTypeManager;
import org.jboss.tools.rsp.server.spi.discovery.ServerBeanType;
import org.jboss.tools.rsp.server.spi.model.IServerManagementModel;
import org.jboss.tools.rsp.server.spi.servertype.IServer;
import org.jboss.tools.rsp.server.spi.servertype.IServerType;
import org.jboss.tools.rsp.server.wildfly.beans.impl.IServerConstants;
import org.jboss.tools.rsp.server.wildfly.servertype.IJBossServerAttributes;
import org.jboss.tools.rsp.server.wildfly.servertype.capabilities.ExtendedServerPropertiesAdapterFactory;
import org.jboss.tools.rsp.server.wildfly.servertype.capabilities.JBossExtendedProperties;
import org.jboss.tools.rsp.server.wildfly.servertype.capabilities.ServerExtendedProperties;
import org.junit.Test;

public class ExtendedPropertiesTest {

	@Test
	public void testServerTypes() {
		String[] toTest = IServerConstants.ALL_JBOSS_SERVERS;
		ExtendedServerPropertiesAdapterFactory fact = new ExtendedServerPropertiesAdapterFactory();
		for( int i = 0; i < toTest.length; i++ ) {
			String serverType = toTest[i];
			IServer s = createServer(serverType);
			ServerExtendedProperties props = fact.getExtendedProperties(s);
			assertNotNull("Server " + serverType + " has no properties,", props);
			assertTrue(props instanceof JBossExtendedProperties);
			JBossExtendedProperties t = (JBossExtendedProperties)props;
			assertNotNull("Server " + serverType + " has no default launch arguments.", t.getDefaultLaunchArguments());
		}
	}
	
	private IServer createServer(String type) {
		IServer s = mock(IServer.class);
		IServerType st = mock(IServerType.class);
		doReturn(st).when(s).getServerType();
		doReturn(type).when(st).getId();
		doReturn(".").when(s).getAttribute(IJBossServerAttributes.SERVER_HOME, (String)null);

		IServerManagementModel managementModel = mockServerManagementModel();
		doReturn(managementModel).when(s).getServerManagementModel();
	
		return s;
	}

	private IServerManagementModel mockServerManagementModel() {
		IServerManagementModel managementModel = mock(IServerManagementModel.class);		
		IServerBeanTypeManager beanTypeManager = mockServerBeanTypeManager();
		doReturn(beanTypeManager).when(managementModel).getServerBeanTypeManager();
		return managementModel;
	}

	private IServerBeanTypeManager mockServerBeanTypeManager() {
		IServerBeanTypeManager beanTypeManager = mock(IServerBeanTypeManager.class);
		doReturn(new ServerBeanType[] {}).when(beanTypeManager).getAllRegisteredTypes();
		return beanTypeManager;
	}

}
