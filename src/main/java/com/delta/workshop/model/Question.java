package com.delta.workshop.model;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-27 上午11:01:29
 * @Description
 */

public class Question {
	private Integer id;
	@NotNull
	@Min(value = 1, message = "项目编号只能为大于0的整数")
	private Integer workshopId;
	@NotNull
	@Min(value = 1, message = "分组编号只能为大于0的整数")
	private Integer groupId;
	@NotNull(message = "问题名称不能为空")
	private String topic;
	private String type;
	@NotNull(message = "问题正确答案不能为空")
	private String answer;
	private String customerAnswer;
	private Date createTime;
	private Date editTime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCustomerAnswer() {
		return customerAnswer;
	}

	public void setCustomerAnswer(String customerAnswer) {
		this.customerAnswer = customerAnswer;
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
