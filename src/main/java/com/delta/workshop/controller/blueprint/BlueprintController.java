package com.delta.workshop.controller.blueprint;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delta.workshop.common.response.CommonResultResponse;
import com.delta.workshop.common.response.ResponseCode;
import com.delta.workshop.common.response.ResponseMessage;
import com.delta.workshop.model.BlueprintDomain;
import com.delta.workshop.model.BlueprintItem;
import com.delta.workshop.model.BlueprintPhase;
import com.delta.workshop.service.BlueprintService;

@RestController
@RequestMapping("/blueprint")
public class BlueprintController {

	private static Logger logger = LogManager.getLogger(BlueprintController.class);
	private CommonResultResponse commonResultResponse = new CommonResultResponse();
	@Autowired
	private BlueprintService blueprintService;

	@GetMapping("/domain/list/{workshopId}")
	public CommonResultResponse getBlueprintDomains(@PathVariable Integer workshopId) {
		commonResultResponse = new CommonResultResponse();
		try {
			List<BlueprintDomain> blueprintDomains = blueprintService.getBlueprintDomains(workshopId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(blueprintDomains);
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

	@PostMapping("/domain/add")
	public CommonResultResponse addBlueprintDomain(@RequestBody BlueprintDomain blueprintDomain) {
		commonResultResponse = new CommonResultResponse();
		try {
			blueprintService.addBlueprintDomain(blueprintDomain);
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

	@PostMapping("/domain/edit")
	public CommonResultResponse editBlueprintDomain(@RequestBody BlueprintDomain blueDomain) {
		commonResultResponse = new CommonResultResponse();
		try {
			blueprintService.editBlueprintDomain(blueDomain);
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

	@DeleteMapping("/domain/{domainId}")
	public CommonResultResponse deleteBlueprintDomain(@PathVariable Integer domainId) {
		commonResultResponse = new CommonResultResponse();
		try {
			blueprintService.deleteBlueprintDomain(domainId);
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

	@GetMapping("/phase/list/{workshopId}")
	public CommonResultResponse getBlueprintPhase(@PathVariable Integer workshopId) {
		commonResultResponse = new CommonResultResponse();
		try {
			List<BlueprintPhase> blueprintPhases = blueprintService.getBlueprintPhase(workshopId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(blueprintPhases);
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

	@PostMapping("/phase/set")
	public CommonResultResponse setBlueprintPhase(@RequestBody BlueprintPhase blueprintPhase) {
		commonResultResponse = new CommonResultResponse();
		try {
			blueprintService.setBlueprintPhase(blueprintPhase);
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

	@PostMapping("/item/set/{workshopId}/{groupId}")
	public CommonResultResponse setBlueprintItem(@RequestBody List<BlueprintItem> blueprintItems,
			@PathVariable("workshopId") Integer workshopId, @PathVariable("groupId") Integer groupId) {
		commonResultResponse = new CommonResultResponse();
		try {
			blueprintService.setBlueprintItem(blueprintItems, workshopId, groupId);
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

	@GetMapping(value={"/item/list/{workshopId}","/item/list/{workshopId}/{groupId}"})
	public CommonResultResponse getBlueprintItems(@PathVariable("workshopId") Integer workshopId,@PathVariable(value="groupId",required=false) Integer groupId) {
		commonResultResponse = new CommonResultResponse();
		try {
			List<BlueprintItem> blueprintItems = blueprintService.getBlueprintItems(workshopId,groupId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(blueprintItems);
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
