/*******************************************************************************
 * Copyright (c) 2006-2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
package org.ebayopensource.turmeric.runtime.tests.common.sif.g11n;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceInvocationException;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceInvocationRuntimeException;
import org.ebayopensource.turmeric.runtime.common.types.G11nOptions;
import org.ebayopensource.turmeric.runtime.errorlibrary.ErrorDataCollection;
import org.ebayopensource.turmeric.runtime.tests.common.sif.Test1Driver;
import org.ebayopensource.turmeric.runtime.tests.common.sif.g11n.BaseG11nTest;


/**
 *
 */
public class UnsupportedLocale extends BaseG11nTest {

	public UnsupportedLocale() throws Exception {
		super("local");
	}

	protected void setupDriver(Test1Driver driver) {
		List<String> locales = new ArrayList<String>();
		locales.add("es-US_US"); // This is disabled in the current registry, so server will skip it.
		locales.add("zh-Hans_US"); // This will be chosen.
		Charset charset = Charset.forName("US-ASCII");
		G11nOptions options = new G11nOptions(charset, locales, "EBAY-US");
		driver.setG11nOptions(options);
		driver.setExpectedError(ErrorDataCollection.svc_g11n_unsupported_locale.getErrorId(),  
				ServiceInvocationException.class, ServiceInvocationRuntimeException.class, "Service does not support locale");
	}
}
