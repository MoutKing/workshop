package com.delta.workshop.model;

import java.util.Date;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-30 上午9:31:31
 * @Description
 */
public class Opportunity {
	/**
	 * 编号
	 */
	private Integer id;

	/**
	 * 痛点id
	 */
	private Integer painpointId;
	/**
	 * 项目编号
	 */
	private Integer workshopId;
	private String painpointName;
	/**
	 * 机会类别名称
	 */
	private String className;
	/**
	 * 机会类别编号
	 */
	private Integer classId;
	/**
	 * 机会点组别
	 */
	private String groupName;
	private Integer groupId;

	/**
	 * 机会名称
	 */
	private String name;
	/**
	 * 机会内容
	 */
	private String content;
	/**
	 * 客户
	 */
	private String customer;
	private Date createTime;
	private Date editTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPainpointId() {
		return painpointId;
	}

	public void setPainpointId(Integer painpointId) {
		this.painpointId = painpointId;
	}

	public Integer getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}

	public String getPainpointName() {
		return painpointName;
	}

	public void setPainpointName(String painpointName) {
		this.painpointName = painpointName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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

}
