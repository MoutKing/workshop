/**
 * 
 */
package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.DataQuality;
import com.delta.workshop.model.FilterKey;
import com.delta.workshop.model.FilterValue;

/**
 * @author Song.Li
 *
 */
public interface DataQualityService {
	public List<FilterValue> getFilterValue(Integer keyId);
	public List<DataQuality> getDataQuality(Integer filterValueId);
	public List<FilterKey> getFilterKey(Integer workshopId);
}
