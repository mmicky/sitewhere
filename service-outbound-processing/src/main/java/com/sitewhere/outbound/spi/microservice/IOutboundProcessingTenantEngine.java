/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.outbound.spi.microservice;

import com.sitewhere.outbound.spi.IOutboundProcessorsManager;
import com.sitewhere.spi.microservice.multitenant.IMicroserviceTenantEngine;

/**
 * Extends {@link IMicroserviceTenantEngine} with features specific to outbound
 * event processing.
 * 
 * @author Derek
 */
public interface IOutboundProcessingTenantEngine extends IMicroserviceTenantEngine {

    /**
     * Get manager for outbound processors.
     * 
     * @return
     */
    public IOutboundProcessorsManager getOutboundProcessorsManager();
}