/**
 * 
 */
package com.delta.workshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.workshop.mapper.DataQualityMapper;
import com.delta.workshop.model.DataQuality;
import com.delta.workshop.model.FilterKey;
import com.delta.workshop.model.FilterValue;
import com.delta.workshop.service.DataQualityService;

/**
 * @author Song.Li
 *
 */
@Service
public class DataQualityServiceImpl implements DataQualityService {

	@Autowired
	DataQualityService dataQualityService;
	
	@Autowired
	DataQualityMapper dataQualityMapper;
	
	@Override
	public List<FilterValue> getFilterValue(Integer keyId){
		List<FilterValue> filterValueListByFilterKey = dataQualityMapper.getFilterValue(keyId);
//		for(int j=0;j<filterValueListByFilterKey.size();j++){
//			FilterValue filterValue = filterValueListByFilterKey.get(j);
//			int filterValueId = filterValue.getId();
//			List<DataQuality> dataQualityList = dataQualityService.getDataQuality(filterValueId);
//			filterValue.setDataQualityList(dataQualityList);
//		}
		return filterValueListByFilterKey;
	}

	@Override
	public List<DataQuality> getDataQuality(Integer filterValueId){
		List<DataQuality> dataQualityList = dataQualityMapper.getDataQuality(filterValueId);
		return dataQualityList;
	}

	@Override
	public List<FilterKey> getFilterKey(Integer workshopId){
		List<FilterKey> filterKeyList = dataQualityMapper.getFilterKey(workshopId);
		for(int i=0;i<filterKeyList.size();i++){
			FilterKey filterKey = filterKeyList.get(i);
			int keyId = filterKey.getId();
			List<FilterValue> filterValueList = dataQualityService.getFilterValue(keyId);
			filterKey.setFilterValueList(filterValueList);
		}
		return filterKeyList;
	}
}
