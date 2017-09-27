/**
 * 
 */
package com.delta.workshop.controller.improveway;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delta.workshop.common.response.CommonResultResponse;
import com.delta.workshop.common.response.ResponseCode;
import com.delta.workshop.common.response.ResponseMessage;
import com.delta.workshop.model.DataQuality;
import com.delta.workshop.model.FilterKey;
import com.delta.workshop.service.DataQualityService;

/**
 * @author Song.Li
 *
 */

@RestController
@RequestMapping("/dataquality")
public class DataQualityController {
	
	private static Logger logger = LogManager.getLogger(DataQualityController.class);

	@Autowired
	private DataQualityService dataQualityService;
	private CommonResultResponse commonResultResponse;

	@RequestMapping(value = "/filterkeylist/{workshopId}", method = RequestMethod.GET)
	public CommonResultResponse getFilterKeyList(@PathVariable Integer workshopId){
		commonResultResponse = new CommonResultResponse();
		try {
			List<FilterKey> filterKeyList = dataQualityService.getFilterKey(workshopId); 
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(filterKeyList);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.PARAMS_ERROR);
			commonResultResponse.setMessage(ResponseMessage.PARAMS_ERROR);
		} catch (Exception e) {
			logger.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.SERVER_ERROR);
			commonResultResponse.setMessage(ResponseMessage.SERVER_ERROR);
		}
		return commonResultResponse;
	}
	
	@RequestMapping(value = "/dataqualitylist/{filterValueId}", method = RequestMethod.GET)
	public CommonResultResponse getDataQuality(@PathVariable Integer filterValueId){
		commonResultResponse = new CommonResultResponse();
		try {
			List<DataQuality> dataQualityList = dataQualityService.getDataQuality(filterValueId); 
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(dataQualityList);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.PARAMS_ERROR);
			commonResultResponse.setMessage(ResponseMessage.PARAMS_ERROR);
		} catch (Exception e) {
			logger.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.SERVER_ERROR);
			commonResultResponse.setMessage(ResponseMessage.SERVER_ERROR);
		}
		return commonResultResponse;
	}
}
