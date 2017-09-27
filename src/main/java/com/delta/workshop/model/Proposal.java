package com.delta.workshop.model;

import java.util.List;

public class Proposal {
	private Integer proposalId;
	private String proposalName;
	private List<ProposalDomain> domains;
	private String chance;
	private String background;
	private String target;
	private List<ProposalStep> steps;
	private Integer quantizationId;
	private List<ProposalQualitativeBenefitAnalysis> qualitativeBenefitAnalysis;
	private Float benefit;
	private Float possibility;
	private String precondition;
	private List<ProposalInterestperson> interestpersons;
	private Integer groupId;
	private Integer workshopId;

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

	public List<ProposalDomain> getDomains() {
		return domains;
	}

	public void setDomains(List<ProposalDomain> domains) {
		this.domains = domains;
	}

	public String getChance() {
		return chance;
	}

	public void setChance(String chance) {
		this.chance = chance;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<ProposalStep> getSteps() {
		return steps;
	}

	public void setSteps(List<ProposalStep> steps) {
		this.steps = steps;
	}

	public List<ProposalQualitativeBenefitAnalysis> getQualitativeBenefitAnalysis() {
		return qualitativeBenefitAnalysis;
	}

	public void setQualitativeBenefitAnalysis(List<ProposalQualitativeBenefitAnalysis> qualitativeBenefitAnalysis) {
		this.qualitativeBenefitAnalysis = qualitativeBenefitAnalysis;
	}

	public String getPrecondition() {
		return precondition;
	}

	public void setPrecondition(String precondition) {
		this.precondition = precondition;
	}

	public List<ProposalInterestperson> getInterestpersons() {
		return interestpersons;
	}

	public void setInterestpersons(List<ProposalInterestperson> interestpersons) {
		this.interestpersons = interestpersons;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getQuantizationId() {
		return quantizationId;
	}

	public void setQuantizationId(Integer quantizationId) {
		this.quantizationId = quantizationId;
	}

	public Float getBenefit() {
		return benefit;
	}

	public void setBenefit(Float benefit) {
		this.benefit = benefit;
	}

	public Float getPossibility() {
		return possibility;
	}

	public void setPossibility(Float possibility) {
		this.possibility = possibility;
	}

}
