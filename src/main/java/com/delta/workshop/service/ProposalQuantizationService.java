package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.ProposalQuantization;
import com.delta.workshop.model.ProposalQuantizationItem;
import com.delta.workshop.model.ProposalQuantizationName;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-8-14 下午2:12:39
 * @Description
 */
public interface ProposalQuantizationService {

	/**
	 * 获取模板列表
	 * 
	 * @param groupId
	 * @param workshopId
	 * @return
	 */
	List<ProposalQuantizationName> getNameList(Integer groupId, Integer workshopId);

	/**
	 * 查询具体的模板的信息
	 * 
	 * @param name
	 * @return
	 */
	ProposalQuantization getProposalQuantization(String name);

	boolean edit(ProposalQuantization pro);

	boolean editItem(List<ProposalQuantizationItem> pro);

}
