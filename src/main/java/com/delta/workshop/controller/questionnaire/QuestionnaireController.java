package com.delta.workshop.controller.questionnaire;

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
import com.delta.workshop.model.Questionnaire;
import com.delta.workshop.model.QuestionnaireSummary;
import com.delta.workshop.model.QuestionnaireUserAnswerGeneral;
import com.delta.workshop.service.QuestionnaireService;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	
	private static Logger logger = LogManager.getLogger(QuestionnaireController.class);
	
	@Autowired
	private QuestionnaireService questionnaireService;
	CommonResultResponse commonResultResponse;
	
	@GetMapping("/list/{workshopId}")
	public CommonResultResponse getQuestionnaire(@PathVariable Integer workshopId){
		commonResultResponse = new CommonResultResponse();
		try {
			Questionnaire questionnaire = questionnaireService.getQuestionnaire(workshopId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(questionnaire);
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
	
	@PostMapping("/preface/add")
	public CommonResultResponse addPreface(@RequestBody Questionnaire questionnaire){
		commonResultResponse = new CommonResultResponse();
		try {
			questionnaireService.addPreface(questionnaire);
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
	
	@PostMapping("/preface/edit")
	public CommonResultResponse editPreface(@RequestBody Questionnaire questionnaire){
		commonResultResponse = new CommonResultResponse();
		try {
			questionnaireService.editPreface(questionnaire);
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
	
	@PostMapping("/commit/answer")
	public CommonResultResponse addUserAnswer(@RequestBody QuestionnaireUserAnswerGeneral questionnaireUserAnswerGeneral){
		commonResultResponse = new CommonResultResponse();
		try {
			questionnaireService.addUserAnswer(questionnaireUserAnswerGeneral);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.PARAMS_ERROR);
			commonResultResponse.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.SERVER_ERROR);
			commonResultResponse.setMessage(ResponseMessage.SERVER_ERROR);
		}
		return commonResultResponse;
	}	
	
	@GetMapping("/result/summary/{workshopId}")
	public CommonResultResponse getSummary(@PathVariable Integer workshopId){
		commonResultResponse = new CommonResultResponse();
		try {
			QuestionnaireSummary questionnaireSummary = questionnaireService.getSummary(workshopId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(questionnaireSummary);
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
	
	@GetMapping("/result/conditon")
	public CommonResultResponse getQuestionnaire(Integer workshopId,String username){
		commonResultResponse = new CommonResultResponse();
		try {
			Questionnaire questionnaire = questionnaireService.getQuestionnairebyUsername(workshopId,username);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(questionnaire);
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
	
	@DeleteMapping("/result/clear/{workshopId}")
	public CommonResultResponse clearUserAnswer(@PathVariable Integer workshopId){
		commonResultResponse = new CommonResultResponse();
		try {
			questionnaireService.clearUserAnswer(workshopId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.PARAMS_ERROR);
			commonResultResponse.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			commonResultResponse.setCode(ResponseCode.SERVER_ERROR);
			commonResultResponse.setMessage(ResponseMessage.SERVER_ERROR);
		}
		return commonResultResponse;
	}	
}
