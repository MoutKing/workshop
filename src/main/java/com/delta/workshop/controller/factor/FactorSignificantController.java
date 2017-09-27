package com.delta.workshop.controller.factor;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delta.workshop.common.response.CommonResultResponse;
import com.delta.workshop.common.response.ResponseCode;
import com.delta.workshop.common.response.ResponseMessage;
import com.delta.workshop.model.FactorConditions;
import com.delta.workshop.service.FactorSignificantService;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-7-10 上午8:59:16
 * @Description
 */
@RestController
@RequestMapping(value = "/factor")
public class FactorSignificantController {
	private static Logger log = LogManager.getLogger(FactorSignificantController.class);

	@Autowired
	private FactorSignificantService service;

	@GetMapping("/condition")
	public CommonResultResponse condition(@RequestParam(value = "casesId", required = false) Integer casesId,
			@RequestParam(value = "measureStation", required = false) String measureStation,
			@RequestParam(value = "majorStation", required = false) String majorStation,
			@RequestParam(value = "machine", required = false) String machine) {
		CommonResultResponse response = new CommonResultResponse();
		Map<String, Object> condition = null;

		try {
			FactorConditions conditions = new FactorConditions();
			conditions.setCasesId(casesId);
			conditions.setMeasureStation(measureStation);
			conditions.setMajorStation(majorStation);
			conditions.setMachine(machine);
			condition = service.conditions(conditions);

			response.setCode(ResponseCode.SUCCESS);
			response.setMessage(ResponseMessage.SUCCESS);
			response.setResult(condition);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.PARAMS_ERROR);
			response.setMessage(ResponseMessage.PARAMS_ERROR);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.SERVER_ERROR);
			response.setMessage(ResponseMessage.SERVER_ERROR);
		}
		return response;
	}

	@PostMapping("/analyse")
	public CommonResultResponse data(@RequestBody FactorConditions conditons) {
		CommonResultResponse response = new CommonResultResponse();
		List<Map<String, Object>> condition = null;

		try {
			condition = service.analyze(conditons);

			response.setCode(ResponseCode.SUCCESS);
			response.setMessage(ResponseMessage.SUCCESS);
			response.setResult(condition);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.PARAMS_ERROR);
			response.setMessage(ResponseMessage.PARAMS_ERROR);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.SERVER_ERROR);
			response.setMessage(ResponseMessage.SERVER_ERROR);
		}
		return response;
	}

	@GetMapping("/multi/{id}")
	public CommonResultResponse data(@PathVariable Integer id) {
		CommonResultResponse response = new CommonResultResponse();
		Map<String, Object> condition = null;

		try {
			condition = service.multi(id);

			response.setCode(ResponseCode.SUCCESS);
			response.setMessage(ResponseMessage.SUCCESS);
			response.setResult(condition);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.PARAMS_ERROR);
			response.setMessage(ResponseMessage.PARAMS_ERROR);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.SERVER_ERROR);
			response.setMessage(ResponseMessage.SERVER_ERROR);
		}
		return response;
	}

}
