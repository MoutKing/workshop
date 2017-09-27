package com.delta.workshop.model;

public class BlueprintItem {
	private Integer itemId;
	private String domainName;
	private String proposalName;
	private Integer startPhaseId;
	private String startTime;
	private Integer endPhaseId;
	private String endTime;
	private Integer groupId;
	private Integer workshopId;
	private Integer startPhasePosition;
	private Integer endPhasePosition;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Integer getStartPhaseId() {
		return startPhaseId;
	}

	public void setStartPhaseId(Integer startPhaseId) {
		this.startPhaseId = startPhaseId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getEndPhaseId() {
		return endPhaseId;
	}

	public void setEndPhaseId(Integer endPhaseId) {
		this.endPhaseId = endPhaseId;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}

	public Integer getStartPhasePosition() {
		return startPhasePosition;
	}

	public void setStartPhasePosition(Integer startPhasePosition) {
		this.startPhasePosition = startPhasePosition;
	}

	public Integer getEndPhasePosition() {
		return endPhasePosition;
	}

	public void setEndPhasePosition(Integer endPhasePosition) {
		this.endPhasePosition = endPhasePosition;
	}

	public String getProposalName() {
		return proposalName;
	}

	public void setProposalName(String proposalName) {
		this.proposalName = proposalName;
	}

}
