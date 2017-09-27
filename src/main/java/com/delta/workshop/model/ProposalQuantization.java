package com.delta.workshop.model;

import java.util.List;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-8-14 上午10:43:58
 * @Description webtool 第四单元 效益分析模板 对象
 */
public class ProposalQuantization {
	private Integer id;
	private Integer groupId;
	private String name;
	private String currency;
	private Integer workshopId;
	private List<ProposalQuantizationBenefit> benefit;
	private List<ProposalQuantizationCost> cost;
	private List<ProposalQuantizationPhase> phase;
	private List<ProposalQuantizationItem> item;

	public Integer getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<ProposalQuantizationBenefit> getBenefit() {
		return benefit;
	}

	public void setBenefit(List<ProposalQuantizationBenefit> benefit) {
		this.benefit = benefit;
	}

	public List<ProposalQuantizationCost> getCost() {
		return cost;
	}

	public void setCost(List<ProposalQuantizationCost> cost) {
		this.cost = cost;
	}

	public List<ProposalQuantizationPhase> getPhase() {
		return phase;
	}

	public void setPhase(List<ProposalQuantizationPhase> phase) {
		this.phase = phase;
	}

	public List<ProposalQuantizationItem> getItem() {
		return item;
	}

	public void setItem(List<ProposalQuantizationItem> item) {
		this.item = item;
	}

	public static void main(String[] args) {
		throw new IllegalArgumentException("所有参数不能都为空");
	}

}
