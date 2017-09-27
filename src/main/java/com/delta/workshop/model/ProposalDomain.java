package com.delta.workshop.model;

public class ProposalDomain {
	private Integer domainId;
	private String domainName;
	private Integer domainStatus;

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Integer getDomainStatus() {
		return domainStatus;
	}

	public void setDomainStatus(Integer domainStatus) {
		this.domainStatus = domainStatus;
	}

}
