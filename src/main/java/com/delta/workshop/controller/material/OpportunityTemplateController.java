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
import com.delta.workshop.model.OpportunityTemplate;
import com.delta.workshop.service.OpportunityTemplateService;

@RestController
@RequestMapping("/opportunity/template")
public class OpportunityTemplateController {

	private static Logger logger = LogManager.getLogger(OpportunityTemplateController.class);

	@Autowired
	private OpportunityTemplateService opportunityTemplateService;
	CommonResultResponse commonResultResponse;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public CommonResultResponse getbyCondition(Integer industryId, Integer targetId, String customer) {
		commonResultResponse = new CommonResultResponse();
		try {
			List<OpportunityTemplate> OpportunityTemplates = opportunityTemplateService.getbyCondition(industryId,targetId,customer);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(OpportunityTemplates);
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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResultResponse add(@RequestBody OpportunityTemplate opportunityTemplate) {
		commonResultResponse = new CommonResultResponse();
		try {
			int result = opportunityTemplateService.add(opportunityTemplate);
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

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public CommonResultResponse edit(@RequestBody OpportunityTemplate opportunityTemplate) {
		commonResultResponse = new CommonResultResponse();
		try {
			opportunityTemplateService.edit(opportunityTemplate);
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

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public CommonResultResponse delete(@PathVariable Integer id) {
		commonResultResponse = new CommonResultResponse();
		try {
			opportunityTemplateService.delete(id);
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
