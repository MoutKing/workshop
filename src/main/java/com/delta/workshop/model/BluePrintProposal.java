package com.delta.workshop.model;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-9-1 上午11:10:03
 * @Description
 */
public class BluePrintProposal {
	private Integer proposalId;
	private Integer workshopId;
	private String proposalName;
	private String domainName;
	private Float benefit;
	private Float feasibility;
	private Integer sequence;

	public Integer getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}

	public Integer getProposalId() {
		return proposalId;
	}

	public void setProposalId(Integer proposalId) {
		this.proposalId = proposalId;
	}

	public String getProposalName() {
		return proposalName;
	}

	public void setProposalName(String proposalName) {
		this.proposalName = proposalName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Float getBenefit() {
		return benefit;
	}

	public void setBenefit(Float benefit) {
		this.benefit = benefit;
	}

	public Float getFeasibility() {
		return feasibility;
	}

	public void setFeasibility(Float feasibility) {
		this.feasibility = feasibility;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}
