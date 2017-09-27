package com.delta.workshop.controller.opportunity;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delta.workshop.common.response.CommonResultResponse;
import com.delta.workshop.common.response.ResponseCode;
import com.delta.workshop.common.response.ResponseMessage;
import com.delta.workshop.model.Case;
import com.delta.workshop.model.NodePicture;
import com.delta.workshop.model.NodeTree;
import com.delta.workshop.service.CaseService;

@RestController
@RequestMapping("/rootcause")
public class CaseController {
	private static Logger log = LogManager.getLogger(CaseController.class);
	
	@Autowired
	private CaseService caseService;
	
	private CommonResultResponse commonResultResponse;
	
	@GetMapping("/condition/{workshopId}")
	public CommonResultResponse getConditionTree(@PathVariable Integer workshopId) {
		commonResultResponse = new CommonResultResponse();
		try {
			List<Case> caseTree = caseService.getConditionTree(workshopId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(caseTree);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.PARAMS_ERROR);
			commonResultResponse.setMessage(ResponseMessage.PARAMS_ERROR);
			commonResultResponse.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.SERVER_ERROR);
			commonResultResponse.setMessage(ResponseMessage.SERVER_ERROR);
			commonResultResponse.setResult(e.getMessage());
		}

		return commonResultResponse;
	}
	
	@GetMapping("/tree/{featureId}/{mainprocesssiteId}")
	public CommonResultResponse getTree(@PathVariable("featureId")Integer featureId,@PathVariable("mainprocesssiteId")Integer mainprocesssiteId) {
		commonResultResponse = new CommonResultResponse();

		try {
			List<NodeTree> nodeTree = caseService.getNodeTree(featureId,mainprocesssiteId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(nodeTree);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.PARAMS_ERROR);
			commonResultResponse.setMessage(ResponseMessage.PARAMS_ERROR);
			commonResultResponse.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.SERVER_ERROR);
			commonResultResponse.setMessage(ResponseMessage.SERVER_ERROR);
			commonResultResponse.setResult(e.getMessage());
		}

		return commonResultResponse;
	}
	
	@GetMapping("/picture/{nodeId}")
	public CommonResultResponse getNodePicture(@PathVariable Integer nodeId) {
		commonResultResponse = new CommonResultResponse();

		try {
			List<NodePicture> nodePicture = caseService.getNodePicture(nodeId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(nodePicture);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.PARAMS_ERROR);
			commonResultResponse.setMessage(ResponseMessage.PARAMS_ERROR);
			commonResultResponse.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.SERVER_ERROR);
			commonResultResponse.setMessage(ResponseMessage.SERVER_ERROR);
			commonResultResponse.setResult(e.getMessage());
		}

		return commonResultResponse;
	}

}
