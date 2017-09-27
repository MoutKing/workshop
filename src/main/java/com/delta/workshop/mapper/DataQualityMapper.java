/**
 * 
 */
package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.DataQuality;
import com.delta.workshop.model.FilterKey;
import com.delta.workshop.model.FilterValue;

/**
 * @author Song.Li
 *
 */
@Mapper
public interface DataQualityMapper {
	List<DataQuality> getDataQuality(Integer filterValueId);
	List<FilterKey> getFilterKey(Integer workshopId);
	List<FilterValue> getFilterValue(Integer keyId);
}
