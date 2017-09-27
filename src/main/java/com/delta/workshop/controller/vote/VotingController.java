package com.delta.workshop.controller.vote;

import java.util.List;

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
import com.delta.workshop.model.VoteUser;
import com.delta.workshop.model.Voting;
import com.delta.workshop.model.VotingImproveway;
import com.delta.workshop.model.VotingOpportunity;
import com.delta.workshop.model.VotingPainPoint;
import com.delta.workshop.service.VotingService;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-7-4 下午3:21:07
 * @Description
 */
@RestController
@RequestMapping(value = "/vote")
public class VotingController {
	private static Logger log = LogManager.getLogger(VotingController.class);

	@Autowired
	private VotingService service;

	/**
	 * 查询投票用户
	 * 
	 * @param wid
	 * @param gid
	 * @param uid
	 * @return
	 */
	@GetMapping("/{unitId}/users")
	public CommonResultResponse Users(@RequestParam("workshopId") Integer wid,
			@RequestParam(value = "groupId", required = false) Integer gid, @PathVariable("unitId") Integer uid) {
		CommonResultResponse response = new CommonResultResponse();
		List<VoteUser> users = null;
		try {
			if (wid != null && wid > 0 && (1 == uid || 2 == uid || 3 == uid)) {
				users = service.user(wid, gid, uid);
			} else
				throw new IllegalArgumentException();

			response.setCode(ResponseCode.SUCCESS);
			response.setMessage(ResponseMessage.SUCCESS);
			response.setResult(users);
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

	/**
	 * 用户投票数据记录
	 * 
	 * @param list
	 * @return 用户投票
	 */
	@PostMapping(value = "/{unitId}/doVoting")
	public CommonResultResponse doVoting(@RequestBody List<Voting> list, @PathVariable("unitId") Integer uid) {
		CommonResultResponse response = new CommonResultResponse();
		Integer count = 0;
		try {
			if (1 == uid || 2 == uid || 3 == uid) {
				count = service.doVoting(list, uid);
			} else
				throw new IllegalArgumentException();

			response.setCode(ResponseCode.SUCCESS);
			if (count % 2 == 0) {
				response.setMessage("更新成功");
			} else {
				response.setMessage("投票成功");
			}
			// response.setMessage(ResponseMessage.SUCCESS);
			response.setResult(count);
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

	/**
	 * 查询痛点的投票信息，根据项目，组
	 * 
	 * @param workShopId
	 * @param groupId
	 * @return
	 */
	@GetMapping(value = "/listPainPoint/{workShopId}")
	public CommonResultResponse list(@PathVariable("workShopId") Integer wid,
			@RequestParam(value = "groupId", required = false) Integer gid) {
		CommonResultResponse response = new CommonResultResponse();
		List<VotingPainPoint> list = null;

		try {

			if (wid != null && wid > 0) {
				list = service.listPainpoint(wid, gid);
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setSequence(i + 1);
				}
			} else
				throw new IllegalArgumentException();
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage(ResponseMessage.SUCCESS);
			response.setResult(list);
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

	/**
	 * 第二单元资料提升方式投票结果查询，根据项目，组
	 * 
	 * @param wid
	 * @param gid
	 * @return
	 */
	@GetMapping(value = "/listImproveway/{workShopId}")
	public CommonResultResponse listImproveway(@PathVariable("workShopId") Integer wid,
			@RequestParam(value = "groupId", required = false) Integer gid) {
		CommonResultResponse response = new CommonResultResponse();
		List<VotingImproveway> list = null;

		try {

			if (wid != null && wid > 0) {
				list = service.listImprove(wid, gid);
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setSequence(i + 1);
				}
			} else
				throw new IllegalArgumentException();
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage(ResponseMessage.SUCCESS);
			response.setResult(list);
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

	/**
	 * 单元三机会点投票结果查询，根据工单，组
	 * 
	 * @param wid
	 * @param gid
	 * @return
	 */
	@GetMapping(value = "/listOpportunity/{workShopId}")
	public CommonResultResponse listOpportunity(@PathVariable("workShopId") Integer wid,
			@RequestParam(value = "groupId", required = false) Integer gid) {
		CommonResultResponse response = new CommonResultResponse();
		List<VotingOpportunity> list = null;

		try {

			if (wid != null && wid > 0) {
				list = service.listOpportunity(wid, gid);
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setSequence(i + 1);
				}
			} else
				throw new IllegalArgumentException();
			response.setCode(ResponseCode.SUCCESS);
			response.setMessage(ResponseMessage.SUCCESS);
			response.setResult(list);
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
