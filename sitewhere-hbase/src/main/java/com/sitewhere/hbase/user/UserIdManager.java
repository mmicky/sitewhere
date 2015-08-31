/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.hbase.user;

import com.sitewhere.hbase.IHBaseContext;
import com.sitewhere.hbase.uid.UniqueIdCounterMap;
import com.sitewhere.hbase.uid.UniqueIdType;
import com.sitewhere.spi.SiteWhereException;

/**
 * Singleton that keeps up with asset management entities.
 * 
 * @author Derek
 */
public class UserIdManager {

	/** Singleton instance */
	private static UserIdManager SINGLETON;

	/** Manager for tenant ids */
	private UniqueIdCounterMap tenantKeys;

	private UserIdManager() {
	}

	public static UserIdManager getInstance() {
		if (SINGLETON == null) {
			SINGLETON = new UserIdManager();
		}
		return SINGLETON;
	}

	/**
	 * Load existing keys from table.
	 * 
	 * @param context
	 * @throws SiteWhereException
	 */
	public void load(IHBaseContext context) throws SiteWhereException {
		tenantKeys =
				new UniqueIdCounterMap(context, UniqueIdType.TenantKey.getIndicator(),
						UniqueIdType.TenantValue.getIndicator());
		tenantKeys.refresh();
	}

	public UniqueIdCounterMap getTenantKeys() {
		return tenantKeys;
	}

	public void setTenantKeys(UniqueIdCounterMap tenantKeys) {
		this.tenantKeys = tenantKeys;
	}
}