package com.delta.workshop.controller.blueprint;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delta.workshop.common.response.CommonResultResponse;
import com.delta.workshop.common.response.ResponseCode;
import com.delta.workshop.common.response.ResponseMessage;
import com.delta.workshop.model.BluePrintProposal;
import com.delta.workshop.model.VoteUser;
import com.delta.workshop.model.VotingBlueprint;
import com.delta.workshop.service.BluePrintProposalService;
import com.delta.workshop.util.Validation;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-9-1 上午10:54:10
 * @Description 第五单元蓝图提案领域
 */
@RestController
@RequestMapping("/blueprint/porposal")
public class BluePrintProposalController {
	private static Logger log = LogManager.getLogger(BluePrintProposalController.class);
	@Autowired
	BluePrintProposalService service;

	/**
	 * 提案领域列表展示
	 * 
	 * @param workshopId
	 * @return
	 */
	@GetMapping("/list")
	public CommonResultResponse List(@RequestParam(value = "workshopId", required = true) Integer workshopId) {
		CommonResultResponse result = new CommonResultResponse();
		List<BluePrintProposal> list = new ArrayList<BluePrintProposal>();
		try {
			if (Validation.validateInteger(workshopId)) {
				list = service.list(workshopId);
			} else
				throw new IllegalArgumentException("参数为正整数，请检查后重新输入");
			result.setCode(ResponseCode.SUCCESS);
			result.setMessage(ResponseMessage.SUCCESS);
			result.setResult(list);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(e.getMessage());
		}

		return result;
	}

	/**
	 * 保存提案领域设置
	 * 
	 * @param workshopId
	 * @return
	 */
	@PostMapping("/edit")
	public CommonResultResponse edit(@RequestBody List<BluePrintProposal> list) {
		CommonResultResponse result = new CommonResultResponse();
		int count = 0;
		try {

			for (BluePrintProposal bpp : list) {
				if (Validation.validateInteger(bpp.getProposalId())) {
					if (Validation.validateString(bpp.getDomainName())) {

					} else
						throw new IllegalArgumentException("参数提案领域名称为中文，并且长度小于45，请检查后重新输入");
				} else
					throw new IllegalArgumentException("参数提案领域ID正整数，请检查后重新输入");
			}

			count = service.edit(list);
			result.setCode(ResponseCode.SUCCESS);
			result.setMessage(ResponseMessage.SUCCESS);
			result.setResult(count);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(e.getMessage());
		}

		return result;
	}

	/**
	 * 投票成员列表
	 * 
	 * @param workshopId
	 * @return
	 */
	@GetMapping("/users")
	public CommonResultResponse votUsers(@RequestParam(value = "groupId", required = true) Integer groupId) {
		CommonResultResponse result = new CommonResultResponse();
		List<VoteUser> users = new ArrayList<VoteUser>();
		try {
			if (Validation.validateInteger(groupId)) {
				users = service.listUsers(groupId);
			} else
				throw new IllegalArgumentException("参数组编号为正整数，请检查后重新输入");
			result.setCode(ResponseCode.SUCCESS);
			result.setMessage(ResponseMessage.SUCCESS);
			result.setResult(users);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(e.getMessage());
		}

		return result;
	}

	/**
	 * 投票评分记录
	 * 
	 * @param workshopId
	 * @return
	 */
	@PostMapping("/vote")
	public CommonResultResponse doVote(@RequestBody List<VotingBlueprint> list,
			@RequestParam(value = "workshopId", required = false) Integer workshopId) {
		CommonResultResponse result = new CommonResultResponse();
		Integer count = 0;
		try {
			for (VotingBlueprint vb : list) {

				if (Validation.validateInteger(workshopId)) {

					if (Validation.validateInteger(vb.getId())) {
						if (Validation.validateInteger(vb.getUserId())) {
							if (Validation.validateVote(vb.getBenefit())) {
								if (Validation.validateVote(vb.getFeasibility())) {

								} else
									throw new IllegalArgumentException("可行性评分有误，请检查后重新输入");
							} else
								throw new IllegalArgumentException("效益评分有误，请检查后重新输入");
						} else
							throw new IllegalArgumentException("参数用户ID正整数，请检查后重新输入");
					} else
						throw new IllegalArgumentException("参数提案领域ID正整数，请检查后重新输入");

				} else
					throw new IllegalArgumentException("参数参数项目编号为正整数，请检查后重新输入");
			}
			count = service.doVote(list,workshopId);
			result.setCode(ResponseCode.SUCCESS);
			if (count > list.size()) {
				result.setMessage("更新成功");
			} else {
				result.setMessage("投票成功");
			}
			// response.setMessage(ResponseMessage.SUCCESS);
			result.setResult(count);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(e.getMessage());
		}

		return result;
	}

	/**
	 * 投票结果展示
	 * 
	 * @param workshopId
	 * @return
	 */
	@GetMapping("/listvote")
	public CommonResultResponse voteList(@RequestParam(value = "groupId", required = false) Integer gid,
			@RequestParam(value = "workshopId", required = false) Integer wid) {
		CommonResultResponse result = new CommonResultResponse();
		List<BluePrintProposal> list = new ArrayList<BluePrintProposal>();
		try {

			if (Validation.validateInteger(wid)) {
				if (null == gid) {
					list = service.listVote(wid, null);
				} else if (Validation.validateInteger(gid)) {
					list = service.listVote(wid, gid);
				} else
					throw new IllegalArgumentException("项目编号为正整数，请检查后重新输入");
			} else
				throw new IllegalArgumentException("参数组编号为正整数，请检查后重新输入");
			result.setCode(ResponseCode.SUCCESS);
			result.setMessage(ResponseMessage.SUCCESS);
			result.setResult(list);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(e.getMessage());
		}

		return result;
	}

	/**
	 * 投票结果排序修改
	 * 
	 * @param workshopId
	 * @return
	 */
	@PostMapping("/sequence")
	public CommonResultResponse updateSequence(@RequestBody List<Integer> list) {
		CommonResultResponse result = new CommonResultResponse();
		boolean success = false;
		try {
			for (Integer num : list) {
				if (Validation.validateInteger(num)) {

				} else
					throw new IllegalArgumentException("参数提案领域ID正整数，请检查后重新输入");
			}
			success = service.sequence(list);
			result.setCode(ResponseCode.SUCCESS);
			result.setMessage(ResponseMessage.SUCCESS);
			result.setResult(success);
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.PARAMS_ERROR);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setCode(ResponseCode.SERVER_ERROR);
			result.setMessage(e.getMessage());
		}

		return result;
	}
}
