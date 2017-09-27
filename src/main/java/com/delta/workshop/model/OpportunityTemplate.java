package com.delta.workshop.model;

import java.util.Date;

public class OpportunityTemplate {
	private Integer id;
	private String name;
	private Integer painpointId;
	private String painpointName;
	private Integer opportunityClassId;
	private String opportunityClassName;
	private String customer;
	private String content;
	private Integer industryId;
	private Integer targetId;

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	private Date createTime;
	private Date editTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOpportunityClassId() {
		return opportunityClassId;
	}

	public void setOpportunityClassId(Integer opportunityClassId) {
		this.opportunityClassId = opportunityClassId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPainpointId() {
		return painpointId;
	}

	public void setPainpointId(Integer painpointId) {
		this.painpointId = painpointId;
	}

	public String getPainpointName() {
		return painpointName;
	}

	public void setPainpointName(String painpointName) {
		this.painpointName = painpointName;
	}

	public String getOpportunityClassName() {
		return opportunityClassName;
	}

	public void setOpportunityClassName(String opportunityClassName) {
		this.opportunityClassName = opportunityClassName;
	}

}
