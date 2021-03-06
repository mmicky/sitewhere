/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.commands.spi;

import java.util.List;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.command.ISystemCommand;
import com.sitewhere.spi.device.communication.IDeviceStreamManager;
import com.sitewhere.spi.device.event.IDeviceCommandInvocation;
import com.sitewhere.spi.server.lifecycle.ITenantEngineLifecycleComponent;

/**
 * Base interface for system components that empower device communication.
 * 
 * @author Derek
 */
public interface IDeviceCommunication extends ITenantEngineLifecycleComponent {

    /**
     * Get the configured device stream manager.
     * 
     * @return
     */
    public IDeviceStreamManager getDeviceStreamManager();

    /**
     * Get the command processing strategy.
     * 
     * @return
     */
    public ICommandProcessingStrategy getCommandProcessingStrategy();

    /**
     * Get the router that chooses which destination will process a command.
     * 
     * @return
     */
    public IOutboundCommandRouter getOutboundCommandRouter();

    /**
     * Get the list of command destinations that can deliver commands to devices.
     * 
     * @return
     */
    public List<ICommandDestination<?, ?>> getCommandDestinations();

    /**
     * Deliver a command invocation.
     * 
     * @param invocation
     * @throws SiteWhereException
     */
    public void deliverCommand(IDeviceCommandInvocation invocation) throws SiteWhereException;

    /**
     * Deliver a system command.
     * 
     * @param hardwareId
     * @param command
     * @throws SiteWhereException
     */
    public void deliverSystemCommand(String hardwareId, ISystemCommand command) throws SiteWhereException;
}