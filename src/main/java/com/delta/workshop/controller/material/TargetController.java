package com.delta.workshop.controller.material;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delta.workshop.common.response.CommonResultResponse;
import com.delta.workshop.common.response.ResponseCode;
import com.delta.workshop.common.response.ResponseMessage;
import com.delta.workshop.model.Target;
import com.delta.workshop.service.TargetService;

@RestController
@RequestMapping("/target")
public class TargetController {
	
	private static Logger logger = LogManager.getLogger(TargetController.class);
	
	@Autowired
	private TargetService targetService;
	CommonResultResponse commonResultResponse;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public CommonResultResponse get(){
		commonResultResponse = new CommonResultResponse();
		try {
			List<Target> targets= targetService.getAll();
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(targets);
		} catch (Exception e) {
			logger.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.SERVER_ERROR);
			commonResultResponse.setMessage(ResponseMessage.SERVER_ERROR);
		}
		return commonResultResponse;
	}
	
	
}
