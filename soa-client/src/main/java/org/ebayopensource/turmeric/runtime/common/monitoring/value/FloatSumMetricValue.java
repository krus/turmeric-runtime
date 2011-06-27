/*******************************************************************************
 * Copyright (c) 2006-2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
package org.ebayopensource.turmeric.runtime.common.monitoring.value;

import org.ebayopensource.turmeric.runtime.common.monitoring.MetricId;

/**
 * A metric value that uses Float to aggregate the sum for a given MetricId.
 * 
 * @author wdeng
 */
public class FloatSumMetricValue extends FloatMetricValue {

	/**
	 * @param id A MetricId.
	 */
	public FloatSumMetricValue(MetricId id) {
		super(id);
	}

	/**
	 * @param id A MetricId
	 * @param initValue The initial value in <code>float</code>.
	 */
	public FloatSumMetricValue(MetricId id, float initValue) {
		super(id, initValue);
	}

	/* (non-Javadoc)
	 * @see org.ebayopensource.turmeric.runtime.common.monitoring.value.BaseMetricValue#addOtherValue(org.ebayopensource.turmeric.runtime.common.monitoring.value.MetricValue, boolean)
	 */
	@Override
	public void addOtherValue(MetricValue other, boolean isPositive) {
		checkUpdateable();

		FloatSumMetricValue other2 = (FloatSumMetricValue)other;
		if (isPositive) {
			m_value += other2.m_value;
		} else {
			m_value -= other2.m_value;
		}
	}

	/* (non-Javadoc)
	 * @see org.ebayopensource.turmeric.runtime.common.monitoring.value.BaseMetricValue#update(org.ebayopensource.turmeric.runtime.common.monitoring.value.MetricValue)
	 */
	@Override
	public void update(MetricValue newValue) {
		checkUpdateable();
		checkInstance(newValue, FloatSumMetricValue.class);
		FloatSumMetricValue value = (FloatSumMetricValue)newValue;
		m_value += value.m_value;
	}

	/* (non-Javadoc)
	 * @see org.ebayopensource.turmeric.runtime.common.monitoring.value.BaseMetricValue#update(int)
	 */
	@Override
	public void update(int value) {
		checkUpdateable();
		m_value += value;
	}

	/* (non-Javadoc)
	 * @see org.ebayopensource.turmeric.runtime.common.monitoring.value.BaseMetricValue#update(long)
	 */
	@Override
	public void update(long value) {
		checkUpdateable();
		m_value += value;
	}

	/* (non-Javadoc)
	 * @see org.ebayopensource.turmeric.runtime.common.monitoring.value.BaseMetricValue#update(float)
	 */
	@Override
	public void update(float value) {
		checkUpdateable();
		m_value += value;
	}

	/* (non-Javadoc)
	 * @see org.ebayopensource.turmeric.runtime.common.monitoring.value.BaseMetricValue#update(double)
	 */
	@Override
	public void update(double value) {
		checkUpdateable();
		m_value += value;
	}
}
