package com.delta.workshop.controller.opportunity;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delta.workshop.common.response.CommonResultResponse;
import com.delta.workshop.common.response.ResponseCode;
import com.delta.workshop.common.response.ResponseMessage;
import com.delta.workshop.model.Question;
import com.delta.workshop.service.OpportunityQuestionService;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-27 上午10:52:53
 * @Description 用于单元二和单元三的实作问题
 */

@RestController
@RequestMapping(value = "/question")
public class OpportunityQuestionController {
	private static Logger log = LogManager.getLogger(OpportunityQuestionController.class);

	@Autowired
	private OpportunityQuestionService service;

	@PostMapping("/{unitId}/add")
	public CommonResultResponse add(@RequestBody Question question, @PathVariable("unitId") Integer id) {

		CommonResultResponse response = new CommonResultResponse();
		Integer count = 0;
		try {
			if (id == 2 || id == 3) {
				count = service.add(id, question);
				response.setCode(ResponseCode.SUCCESS);
				response.setMessage(ResponseMessage.SUCCESS);
				response.setResult(count);
			} else
				throw new IllegalArgumentException("单元参数设置错误");

		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.PARAMS_ERROR);
			response.setMessage(ResponseMessage.PARAMS_ERROR);
			response.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.SERVER_ERROR);
			response.setMessage(ResponseMessage.SERVER_ERROR);
			response.setResult(e.getMessage());
		}
		return response;
	}

	@DeleteMapping("/{unitId}/delete/{id}")
	public CommonResultResponse delete(@PathVariable("unitId") Integer id, @PathVariable("id") Integer qId) {

		CommonResultResponse response = new CommonResultResponse();
		Integer count = 0;
		try {
			if (id == 2 || id == 3) {
				count = service.delete(id, qId);
				response.setCode(ResponseCode.SUCCESS);
				response.setMessage(ResponseMessage.SUCCESS);
				response.setResult(count);
			} else
				throw new IllegalArgumentException("单元参数设置错误");
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.PARAMS_ERROR);
			response.setMessage(ResponseMessage.PARAMS_ERROR);
			response.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.SERVER_ERROR);
			response.setMessage(ResponseMessage.SERVER_ERROR);
			response.setResult(e.getMessage());
		}
		return response;
	}

	@PostMapping("/{unitId}/update")
	public CommonResultResponse update(@RequestBody List<Question> question, @PathVariable("unitId") Integer id) {
		CommonResultResponse response = new CommonResultResponse();
		Integer count = 0;
		try {
			if (id == 2 || id == 3) {
				count = service.update(id, question);
				response.setCode(ResponseCode.SUCCESS);
				response.setMessage(ResponseMessage.SUCCESS);
				response.setResult(count);
			} else
				throw new IllegalArgumentException("单元参数设置错误");
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.PARAMS_ERROR);
			response.setMessage(ResponseMessage.PARAMS_ERROR);
			response.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.SERVER_ERROR);
			response.setMessage(ResponseMessage.SERVER_ERROR);
			response.setResult(e.getMessage());
		}
		return response;
	}

	@GetMapping("/{unitId}/list")
	public CommonResultResponse list(@PathVariable("unitId") Integer id,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "groupId", required = false) Integer groupId) {
		CommonResultResponse response = new CommonResultResponse();
		List<Question> question = null;
		try {
			if (id == 2 || id == 3) {
				question = service.list(id, type, groupId);
				response.setCode(ResponseCode.SUCCESS);
				response.setMessage(ResponseMessage.SUCCESS);
				response.setResult(question);
			} else
				throw new IllegalArgumentException("单元参数设置错误");
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.PARAMS_ERROR);
			response.setMessage(ResponseMessage.PARAMS_ERROR);
			response.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setCode(ResponseCode.SERVER_ERROR);
			response.setMessage(ResponseMessage.SERVER_ERROR);
			response.setResult(e.getMessage());
		}
		return response;
	}
}
