package com.delta.workshop.controller.material;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delta.workshop.common.response.CommonResultResponse;
import com.delta.workshop.common.response.ResponseCode;
import com.delta.workshop.common.response.ResponseMessage;
import com.delta.workshop.model.OpportunityClass;
import com.delta.workshop.service.OpportunityClassService;

@RestController
@RequestMapping("/opportunity/class")
public class OpportunityClassController {
	
	private static Logger logger = LogManager.getLogger(OpportunityClassController.class);
	
	@Autowired
	private OpportunityClassService opportunityClassService;
	CommonResultResponse commonResultResponse;
	
	@RequestMapping(value="/list/{industryId}",method=RequestMethod.GET)
	public CommonResultResponse get(@PathVariable Integer industryId){
		commonResultResponse = new CommonResultResponse();
		try {
			List<OpportunityClass> opportunityClass= opportunityClassService.getAll(industryId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(opportunityClass);
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
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public CommonResultResponse add(@RequestBody OpportunityClass opportunityClass){
		commonResultResponse = new CommonResultResponse();
		try {
			int result = opportunityClassService.add(opportunityClass);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(result);
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
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public CommonResultResponse edit(@RequestBody OpportunityClass opportunityClass){
		commonResultResponse = new CommonResultResponse();
		try {
			opportunityClassService.edit(opportunityClass);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
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
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public CommonResultResponse delete(@PathVariable Integer id){
		commonResultResponse = new CommonResultResponse();
		try {
			opportunityClassService.delete(id);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
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
