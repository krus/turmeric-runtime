/*******************************************************************************
 * Copyright (c) 2006-2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
package org.ebayopensource.turmeric.tools.codegen;


import org.ebayopensource.turmeric.runtime.tests.service1.sample.types1.ItemType;
import org.ebayopensource.turmeric.runtime.tests.service1.sample.types2.SearchResultType;
import org.ebayopensource.turmeric.runtime.tests.service1.sample.types2.UserType;


public interface ItemServiceInterface {	
	
	public UserType  getUser(String userName);
	
	public ItemType  getItem(long itemId) throws Exception;
	
	public SearchResultType  getSearchResults(String searchQry);
	
}
