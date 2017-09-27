package com.delta.workshop.controller.proposal;

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
import com.delta.workshop.controller.opportunity.OpportunityController;
import com.delta.workshop.model.ProposalQuantization;
import com.delta.workshop.model.ProposalQuantizationItem;
import com.delta.workshop.model.ProposalQuantizationName;
import com.delta.workshop.service.ProposalQuantizationService;
import com.mysql.jdbc.StringUtils;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-8-14 上午10:42:28
 * @Description webtool 第四单元 效益分析模板
 */
@RestController
@RequestMapping("/benefit")
public class ProposalQuantizationController {
	private static Logger log = LogManager.getLogger(OpportunityController.class);

	@Autowired
	private ProposalQuantizationService service;

	/**
	 * 用以根据效益分析模板名字查询模板内容
	 * 
	 * @param groupId
	 * @param name
	 * @return
	 */
	@GetMapping("/get")
	public CommonResultResponse query(@RequestParam(value = "name", required = true) String name) {
		CommonResultResponse result = new CommonResultResponse();
		ProposalQuantization data = null;
		try {
			if (StringUtils.isNullOrEmpty(name)) {
				throw new IllegalArgumentException("模板名称不能为空");
			} else if (!name.replace(" ", "").matches("^[\\u4e00-\\u9fa5a-zA-Z0-9_]{1,255}+$")) {
				throw new IllegalArgumentException("模板名字不符合规则，只能包含中文，数字，字母和_，并且字节成都不能超过255");
			} else {
				data = service.getProposalQuantization(name);
				if (null == data) {
					result.setCode(ResponseCode.SUCCESS);
					result.setMessage("根据名字查询数据为空");
					result.setResult(data);
				} else {
					result.setCode(ResponseCode.SUCCESS);
					result.setMessage(ResponseMessage.SUCCESS);
					result.setResult(data);
				}
			}

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
	 * 查询效益分析模板列表
	 * 
	 * @param groupId
	 * @param workshopId
	 * @return
	 */
	@GetMapping("/listName")
	public CommonResultResponse nameList(@RequestParam(value = "groupId", required = false) Integer groupId,
			@RequestParam(value = "workshopId", required = false) Integer workshopId) {
		CommonResultResponse result = new CommonResultResponse();
		List<ProposalQuantizationName> list = null;
		try {
			if (null == groupId && null == workshopId) {
				throw new IllegalArgumentException("所有参数不能都为空");
			} else if (null != groupId && groupId <= 0 | null != workshopId && workshopId <= 0) {
				throw new IllegalArgumentException("所有参数为大于或等于1的正整数");
			} else {
				list = service.getNameList(groupId, workshopId);
			}
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
	 * 用于对模板内容进行添加和更新
	 * 
	 * @param pro
	 * @return
	 */
	@PostMapping("/edit")
	public CommonResultResponse edit(@RequestBody ProposalQuantization pro) {
		CommonResultResponse result = new CommonResultResponse();
		try {
			boolean success = service.edit(pro);

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

	/**
	 * 用于对模板内容进行添加和更新
	 * 
	 * @param pro
	 * @return
	 */
	@PostMapping("/editItem")
	public CommonResultResponse editItem(@RequestBody List<ProposalQuantizationItem> pro) {
		CommonResultResponse result = new CommonResultResponse();
		try {
			boolean success = service.editItem(pro);

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
