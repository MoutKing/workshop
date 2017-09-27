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
import com.delta.workshop.model.User;
import com.delta.workshop.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	CommonResultResponse commonResultResponse;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public CommonResultResponse get(){
		commonResultResponse = new CommonResultResponse();
		try {
			List<User> users= userService.get();
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(users);
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
	public CommonResultResponse add(@RequestBody User User){
		commonResultResponse = new CommonResultResponse();
		try {
			userService.add(User);
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
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public CommonResultResponse edit(@RequestBody User User){
		commonResultResponse = new CommonResultResponse();
		try {
			userService.edit(User);
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
	
	@RequestMapping(value="/delete/{userId}",method=RequestMethod.DELETE)
	public CommonResultResponse add(@PathVariable String userId){
		commonResultResponse = new CommonResultResponse();
		try {
			userService.delete(userId);
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
