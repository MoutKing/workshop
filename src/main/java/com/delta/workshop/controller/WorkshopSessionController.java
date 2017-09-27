package com.delta.workshop.controller;

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
import com.delta.workshop.model.WorkshopSession;
import com.delta.workshop.service.WorkshopSessionService;

@RestController
@RequestMapping("/session")
public class WorkshopSessionController {

	private static Logger logger = LogManager.getLogger(WorkshopSessionController.class);

	@Autowired
	private WorkshopSessionService workshopSessionService;
	private CommonResultResponse commonResultResponse;

	@RequestMapping(value = "/list/{workshopId}", method = RequestMethod.GET)
	public CommonResultResponse get(@PathVariable Integer workshopId) {
		commonResultResponse = new CommonResultResponse();
		try {
			List<WorkshopSession> WorkshopSessions = workshopSessionService.getByWorkshop(workshopId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(WorkshopSessions);
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

	@RequestMapping(value = "/edit/{workshopId}", method = RequestMethod.GET)
	public CommonResultResponse edit(@PathVariable Integer workshopId,@RequestBody List<WorkshopSession> workshopSessions) {
		commonResultResponse = new CommonResultResponse();
		try {
			workshopSessionService.edit(workshopId, workshopSessions);
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
	
	@RequestMapping(value = "/sub/edit/{workshopId}", method = RequestMethod.GET)
	public CommonResultResponse editSub(@PathVariable Integer workshopId,@RequestBody List<WorkshopSession> workshopSessions) {
		commonResultResponse = new CommonResultResponse();
		try {
			workshopSessionService.editSub(workshopId, workshopSessions);
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
