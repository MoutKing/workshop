package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.ProposalQuantization;
import com.delta.workshop.model.ProposalQuantizationBenefit;
import com.delta.workshop.model.ProposalQuantizationCost;
import com.delta.workshop.model.ProposalQuantizationItem;
import com.delta.workshop.model.ProposalQuantizationName;
import com.delta.workshop.model.ProposalQuantizationPhase;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-8-14 下午3:21:45
 * @Description
 */
@Mapper
public interface ProposalQuantizationMapper {

	List<ProposalQuantizationName> getListByWorkshopId(Integer workshopId);

	List<ProposalQuantizationName> getListByGroupId(Integer groupId);

	/** 根据模板名字查询模板信息
	 * @param name
	 * @return
	 */
	ProposalQuantization getProposalQuantizatin(String name);

	List<ProposalQuantizationPhase> getProposalQuantizatinPhase(Integer id);

	List<ProposalQuantizationBenefit> getProposalQuantizatinBenefit(Integer id);

	List<ProposalQuantizationCost> getProposalQuantizatinCost(Integer id);

	List<ProposalQuantizationItem> getProposalQuantizatinItem(Integer id);

	void updateProposalQuantizatin(ProposalQuantization pro);

	void insertProposalQuantizatin(ProposalQuantization pro);

	void updateProposalQuantizatinPhase(ProposalQuantizationPhase pqp);

	void updateProposalQuantizatinBenefit(ProposalQuantizationBenefit pqb);

	void updateProposalQuantizatinCost(ProposalQuantizationCost pqc);

	void insertProposalQuantizatinPhase(ProposalQuantizationPhase pqp);

	void insertProposalQuantizatinBenefit(ProposalQuantizationBenefit pqb);

	void insertProposalQuantizatinCost(ProposalQuantizationCost pqc);

	void updateProposalQuantizatinItem(ProposalQuantizationItem pqi);

	void insertProposalQuantizatinItem(ProposalQuantizationItem pqi);

	void deletePhase(ProposalQuantization pro);

	void deleteBenefit(ProposalQuantization pro);

	void deleteCost(ProposalQuantization pro);

	void deleteItem(ProposalQuantization pro);

	List<ProposalQuantization> getOpportunityBywid(Integer workshopId);

	List<ProposalQuantization> getOpportunityBygid(Integer groupId);

	int insertProposalQuantizatins(List<ProposalQuantization> list);

	List<ProposalQuantizationName> getList(Integer groupId);

	
}
