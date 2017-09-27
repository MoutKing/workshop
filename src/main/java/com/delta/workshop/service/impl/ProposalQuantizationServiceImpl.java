package com.delta.workshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.ProposalQuantizationMapper;
import com.delta.workshop.model.Proposal;
import com.delta.workshop.model.ProposalQuantization;
import com.delta.workshop.model.ProposalQuantizationBenefit;
import com.delta.workshop.model.ProposalQuantizationCost;
import com.delta.workshop.model.ProposalQuantizationItem;
import com.delta.workshop.model.ProposalQuantizationName;
import com.delta.workshop.model.ProposalQuantizationPhase;
import com.delta.workshop.service.ProposalQuantizationService;
import com.delta.workshop.service.ProposalService;
import com.delta.workshop.util.Validation;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-8-14 下午2:13:38
 * @Description
 */
@Service
public class ProposalQuantizationServiceImpl implements ProposalQuantizationService {

	@Autowired
	private ProposalQuantizationMapper mapper;
	@Autowired
	private ProposalService proposalService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<ProposalQuantizationName> getNameList(Integer groupId, Integer workshopId) {
		List<ProposalQuantizationName> list = null;

		// 查询名字，有的话直接返回，没有的话从第三单元取
		list = getNames(groupId, workshopId);

		if (null != list && list.size() > 0) {
			return list;
		} else {
			List<ProposalQuantization> names = null;
			List<ProposalQuantization> lists = new ArrayList<ProposalQuantization>();
			if (null == groupId) {
				names = mapper.getOpportunityBywid(workshopId);
			} else {
				names = mapper.getOpportunityBygid(groupId);
			}

			if (names != null) {
				for (ProposalQuantization name : names) {
					if (name.getName().replace(" ", "").length() > 0 && null != name.getWorkshopId()) {
						ProposalQuantization pq = new ProposalQuantization();
						pq.setName(name.getName());
						pq.setWorkshopId(name.getWorkshopId());
						lists.add(pq);
					}
				}
				if (lists.size() > 0) {
					int count = mapper.insertProposalQuantizatins(lists);
					if (count == lists.size()) {
						list = getNames(groupId, workshopId);
					}
				}

				return list;
			} else
				return list;

		}
		//

	}

	@Override
	public ProposalQuantization getProposalQuantization(String name) {

		ProposalQuantization pq = mapper.getProposalQuantizatin(name);
		if (pq == null) {
			return null;
		}
		pq.setPhase(mapper.getProposalQuantizatinPhase(pq.getId()));
		pq.setBenefit(mapper.getProposalQuantizatinBenefit(pq.getId()));
		pq.setCost(mapper.getProposalQuantizatinCost(pq.getId()));
		pq.setItem(mapper.getProposalQuantizatinItem(pq.getId()));
		return pq;
	}

	@Override
	public boolean edit(ProposalQuantization pro) {
		boolean issuccess = false;
		// 判断数据时更新还是添加
		if (null != pro.getId()) {
			if (null != pro.getName() && null != pro.getCurrency() && Validation.validateInteger(pro.getWorkshopId())
					&& Validation.validateInteger(pro.getGroupId())) {

				if (pro.getName().replace(" ", "").matches("^[\\u4e00-\\u9fa5a-zA-Z0-9_]{1,255}+$")
						&& pro.getCurrency().replace(" ", "").matches("^[^\\s]{1,45}+$")) {

					// 判断模板名字是否重复
					ProposalQuantization pq = mapper.getProposalQuantizatin(pro.getName());
					if (null == pq || pro.getId().equals(pq.getId()) ){
						// 可以更新模板数据，首先删除原有的数据
						mapper.updateProposalQuantizatin(pro);
						mapper.deletePhase(pro);
						mapper.deleteBenefit(pro);
						mapper.deleteCost(pro);
						mapper.deleteItem(pro);
						for (ProposalQuantizationPhase pqp : pro.getPhase()) {
							if (pqp.getName().replace(" ", "").matches("^[\\u4e00-\\u9fa5a-zA-Z0-9_]{1,255}+$")) {
								pqp.setQuantizationId(pro.getId());
								if (null != pqp.getId()) {
									mapper.updateProposalQuantizatinPhase(pqp);
								} else {
									mapper.insertProposalQuantizatinPhase(pqp);
								}
							} else
								throw new IllegalArgumentException("模板阶段名称不符合规则，只能包含中文，数字，字母和_，并且字节长度不能超过255");
						}

						for (ProposalQuantizationBenefit pqb : pro.getBenefit()) {
							if (pqb.getName().replace(" ", "").matches("^[\\u4e00-\\u9fa5a-zA-Z0-9_]{1,255}+$")) {
								pqb.setQuantizationId(pro.getId());
								if (null != pqb.getId()) {
									mapper.updateProposalQuantizatinBenefit(pqb);
								} else {
									mapper.insertProposalQuantizatinBenefit(pqb);
								}

							} else
								throw new IllegalArgumentException("模板效益名称不符合规则，只能包含中文，数字，字母和_，并且字节长度不能超过255");
						}

						for (ProposalQuantizationCost pqc : pro.getCost()) {
							if (pqc.getName().replace(" ", "").matches("^[\\u4e00-\\u9fa5a-zA-Z0-9_]{1,255}+$")) {
								pqc.setQuantizationId(pro.getId());
								if (null != pqc.getId()) {
									mapper.updateProposalQuantizatinCost(pqc);
								} else {
									mapper.insertProposalQuantizatinCost(pqc);
								}
							} else
								throw new IllegalArgumentException("模板成本名称不符合规则，只能包含中文，数字，字母和_，并且字节长度不能超过255");
						}

						issuccess = true;
						// 更新成功后将信息插入提案企划表
						if (issuccess) {
							List<Proposal> list = proposalService.getProposal(pro.getWorkshopId(), pro.getGroupId());

							int count = 0;
							if (list.size() > 0) {
								for (Proposal p : list) {
									if (p.getProposalName().equals(pro.getName())) {
										count++;
									}
								}
							}

							if (count == 0) {
								Proposal proposal = new Proposal();
								proposal.setProposalName(pro.getName());
								proposal.setGroupId(pro.getGroupId());
								proposal.setQuantizationId(pro.getId());
								proposal.setWorkshopId(pro.getWorkshopId());
								proposalService.addProposal(proposal);

							}
						}

					} else
						throw new IllegalArgumentException("模板名称重复，更新失败");

				} else
					throw new IllegalArgumentException("模板名字不符合规则，只能包含中文，数字，字母和_，并且字节长度不能超过255，币种信息长度不能超过45并且组编号为正整数");
			} else
				throw new IllegalArgumentException("模板名字不能为空，组编号应为正整数，项目编号应为正整数，币种不能为空");
		}
		// else if (null == pro.getId() && null != pro.getGroupId() &&
		// pro.getGroupId() > 0
		// && !StringUtils.isNullOrEmpty(pro.getName()) &&
		// !StringUtils.isNullOrEmpty(pro.getCurrency())) {
		// if (pro.getName().replace(" ",
		// "").matches("^[\\u4e00-\\u9fa5a-zA-Z0-9_]{1,255}+$")
		// && pro.getCurrency().replace(" ", "").matches("^[^\\s]{1,45}+$")) {
		// ProposalQuantization pq =
		// mapper.getProposalQuantizatin(pro.getName());
		// if (null == pq) {
		// mapper.insertProposalQuantizatin(pro);
		//
		// for (ProposalQuantizationPhase pqp : pro.getPhase()) {
		// if (pqp.getName().replace(" ",
		// "").matches("^[\\u4e00-\\u9fa5a-zA-Z0-9_]{1,255}+$")) {
		// pqp.setQuantizationId(pro.getId());
		// mapper.insertProposalQuantizatinPhase(pqp);
		// } else
		// throw new
		// IllegalArgumentException("模板阶段名称不符合规则，只能包含中文，数字，字母和_，并且字节长度不能超过255");
		// }
		//
		// for (ProposalQuantizationBenefit pqb : pro.getBenefit()) {
		// if (pqb.getName().replace(" ",
		// "").matches("^[\\u4e00-\\u9fa5a-zA-Z0-9_]{1,255}+$")) {
		// pqb.setQuantizationId(pro.getId());
		// mapper.insertProposalQuantizatinBenefit(pqb);
		// } else
		// throw new
		// IllegalArgumentException("模板效益名称不符合规则，只能包含中文，数字，字母和_，并且字节长度不能超过255");
		// }
		//
		// for (ProposalQuantizationCost pqc : pro.getCost()) {
		// if (pqc.getName().replace(" ",
		// "").matches("^[\\u4e00-\\u9fa5a-zA-Z0-9_]{1,255}+$")) {
		// pqc.setQuantizationId(pro.getId());
		// mapper.insertProposalQuantizatinCost(pqc);
		// } else
		// throw new
		// IllegalArgumentException("模板成本名称不符合规则，只能包含中文，数字，字母和_，并且字节长度不能超过255");
		// }
		//
		// issuccess = true;
		// } else
		// throw new IllegalArgumentException("模板名称重复，添加失败");
		// } else
		// throw new
		// IllegalArgumentException("模板名字不符合规则，只能包含中文，数字，字母和_，并且字节长度不能超过255或者币种长度过长");
		//
		// } else
		// throw new IllegalArgumentException("模板ID为空时模板名字或组ID或币种不能为空");

		return issuccess;
	}

	@Override
	public boolean editItem(List<ProposalQuantizationItem> pro) {
		boolean issuccess = false;
		if (pro.size() > 0) {
			for (ProposalQuantizationItem pqi : pro) {
				if (null != pqi.getItem() && null != pqi.getQuantizationId()) {
					if (null != pqi.getId()) {
						mapper.updateProposalQuantizatinItem(pqi);
					} else if (null != pqi.getQuantizationPhaseId()
							&& (null != pqi.getQuantizationBenefitId() || null != pqi.getQuantizationCostId())) {
						mapper.insertProposalQuantizatinItem(pqi);
					}
					issuccess = true;
				} else
					throw new IllegalArgumentException("数据内容和模板ID不能为空");
			}
		} else
			throw new IllegalArgumentException("传入数据不能为空");
		return issuccess;
	}

	private List<ProposalQuantizationName> getNames(Integer groupId, Integer workshopId) {
		List<ProposalQuantizationName> list = null;

		// 查询名字，有的话直接返回，没有的话从第三单元取
		if (null != workshopId) {
			list = mapper.getListByWorkshopId(workshopId);
		} else if (null != groupId) {
			list = mapper.getListByGroupId(groupId);
		}
		if (list.size() > 0) {
		} else if (null != groupId) {
			list = mapper.getList(groupId);
		}
		return list;
	}

}
