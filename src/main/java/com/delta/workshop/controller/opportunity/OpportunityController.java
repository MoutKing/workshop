package com.delta.workshop.controller.opportunity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.delta.workshop.model.Groups;
import com.delta.workshop.model.Opportunity;
import com.delta.workshop.service.GroupsService;
import com.delta.workshop.service.OpportunityService;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-30 上午9:26:23
 * @Description
 */
@RestController
@RequestMapping(value = "/opportunity")
public class OpportunityController {
	private static Logger log = LogManager.getLogger(OpportunityController.class);

	@Autowired
	private OpportunityService service;
	@Autowired
	private GroupsService groupsService;

	/**
	 * 项目内添加机会点
	 * 
	 * @param opprotunity
	 * @return
	 */
	@PostMapping("/add")
	public CommonResultResponse add(@RequestBody List<Opportunity> opprotunity,
			@RequestParam(value = "isTemplate", required = false) boolean isTemplate) {
		CommonResultResponse result = new CommonResultResponse();

		try {
			isTemplate = false;
			Integer count = service.add(isTemplate, opprotunity);
			result.setCode(ResponseCode.SUCCESS);
			result.setMessage(ResponseMessage.SUCCESS);
			result.setResult(count);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(ResponseMessage.PARAMS_ERROR);
			result.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(ResponseMessage.SERVER_ERROR);
			result.setResult(e.getMessage());
		}

		return result;
	}

	/**
	 * 项目内更新机会点
	 * 
	 * @param opprotunity
	 * @return
	 */
	@PostMapping("/update")
	public CommonResultResponse update(@RequestBody Opportunity opprotunity) {
		CommonResultResponse result = new CommonResultResponse();
		Integer count = 0;
		try {
			if (null != opprotunity.getId() && opprotunity.getId() > 0) {
				count = service.update(opprotunity);
			} else
				throw new IllegalArgumentException("机会点编号不能为空");
			result.setCode(ResponseCode.SUCCESS);
			result.setMessage(ResponseMessage.SUCCESS);
			result.setResult(count);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(ResponseMessage.PARAMS_ERROR);
			result.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(ResponseMessage.SERVER_ERROR);
			result.setResult(e.getMessage());
		}

		return result;
	}

	/**
	 * 项目内删除机会点
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public CommonResultResponse delete(@PathVariable Integer id) {
		CommonResultResponse result = new CommonResultResponse();

		try {
			if (null != id && id > 0) {
				Integer count = service.delete(id);
				result.setCode(ResponseCode.SUCCESS);
				result.setMessage(ResponseMessage.SUCCESS);
				result.setResult(count);
			} else
				throw new IllegalArgumentException("项目编号不能为空");

		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(ResponseMessage.PARAMS_ERROR);
			result.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(ResponseMessage.SERVER_ERROR);
			result.setResult(e.getMessage());
		}

		return result;
	}

	/**
	 * 项目内查询机会点，不分组
	 * 
	 * @param pid
	 * @param wid
	 * @param cid
	 * @return
	 */
	@GetMapping("/list")
	public CommonResultResponse list(@RequestParam(value = "painpointId", required = false) Integer pid,
			@RequestParam(value = "workshopId", required = true) Integer wid,
			@RequestParam(value = "classId", required = false) Integer cid,
			@RequestParam(value = "groupId", required = false) Integer gid,
			@RequestParam(value = "customer", required = false) String customer) {
		CommonResultResponse result = new CommonResultResponse();
		try {
			if (null != wid && wid > 0) {
				List<Opportunity> list = service.list(pid, wid, cid, gid, customer);
				result.setCode(ResponseCode.SUCCESS);
				result.setMessage(ResponseMessage.SUCCESS);
				result.setResult(list);
			} else
				throw new IllegalArgumentException("项目编号不能为空");

		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(ResponseMessage.PARAMS_ERROR);
			result.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(ResponseMessage.SERVER_ERROR);
			result.setResult(e.getMessage());
		}

		return result;
	}

	@GetMapping("/groupList")
	public CommonResultResponse list(@RequestParam("workshopId") Integer wid) {
		CommonResultResponse result = new CommonResultResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (null != wid && wid > 0) {
				List<Groups> groups = groupsService.getAll(wid);
				if (groups.size() > 0 && null != groups.get(0)) {
					for (Groups g : groups) {
						List<Opportunity> list = service.list(null, wid, null, g.getId(), null);
						map.put(g.getName(), list);
					}
				}

				result.setCode(ResponseCode.SUCCESS);
				result.setMessage(ResponseMessage.SUCCESS);
				result.setResult(map);
			} else
				throw new IllegalArgumentException("项目编号不能为空");

		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(ResponseMessage.PARAMS_ERROR);
			result.setResult(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(ResponseMessage.SERVER_ERROR);
			result.setResult(e.getMessage());
		}
		return result;
	}
}
