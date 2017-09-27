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
import com.delta.workshop.model.GroupMember;
import com.delta.workshop.model.Groups;
import com.delta.workshop.service.GroupsService;

@RestController
@RequestMapping("/groups")
public class GroupsController {

	private static Logger logger = LogManager.getLogger(GroupsController.class);

	@Autowired
	private GroupsService groupsService;
	CommonResultResponse commonResultResponse;

	@RequestMapping(value = "/list/{workshopId}", method = RequestMethod.GET)
	public CommonResultResponse get(@PathVariable Integer workshopId) {
		commonResultResponse = new CommonResultResponse();
		try {
			List<Groups> groups = groupsService.getAll(workshopId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(groups);
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
	public CommonResultResponse add(@RequestBody Groups groups) {
		commonResultResponse = new CommonResultResponse();
		try {
			groupsService.add(groups);
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

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public CommonResultResponse edit(@RequestBody Groups groups) {
		commonResultResponse = new CommonResultResponse();
		try {
			groupsService.edit(groups);
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
			groupsService.delete(id);
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

	@RequestMapping(value = "/member/list/{workshopId}/{groupId}", method = RequestMethod.GET)
	public CommonResultResponse getMember(@PathVariable("workshopId") Integer workshopId, @PathVariable("groupId") Integer groupId) {
		commonResultResponse = new CommonResultResponse();
		try {
			List<GroupMember> groupMembers = groupsService.getAllMember(workshopId,groupId);
			commonResultResponse.setCode(ResponseCode.SUCCESS);
			commonResultResponse.setMessage(ResponseMessage.SUCCESS);
			commonResultResponse.setResult(groupMembers);
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

	/**
	 * 增加组成员
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/member/add", method = RequestMethod.POST)
	public CommonResultResponse addMember(@RequestBody GroupMember groupMember) {
		commonResultResponse = new CommonResultResponse();
		try {
			groupsService.addMember(groupMember);
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

	
	/**
	 * 编辑组成员
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/member/edit", method = RequestMethod.POST)
	public CommonResultResponse editMember(@RequestBody GroupMember groupMember) {
		commonResultResponse = new CommonResultResponse();
		try {
			groupsService.editMember(groupMember);
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

	/**
	 * 删除组成员
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/member/delete/{id}", method = RequestMethod.DELETE)
	public CommonResultResponse deleteMember(@PathVariable Integer id) {
		commonResultResponse = new CommonResultResponse();
		try {
			groupsService.deleteMember(id);
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
