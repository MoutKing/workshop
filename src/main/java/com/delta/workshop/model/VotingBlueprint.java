package com.delta.workshop.model;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-9-4 下午2:49:04
 * @Description
 */
public class VotingBlueprint {

	/**
	 * 投票对象
	 */
	private Integer id;

	/**
	 * 用户
	 */
	private Integer userId;

	/**
	 * 效益评分
	 */
	private Integer benefit;

	/**
	 * 可行性评分
	 */
	private Integer feasibility;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBenefit() {
		return benefit;
	}

	public void setBenefit(Integer benefit) {
		this.benefit = benefit;
	}

	public Integer getFeasibility() {
		return feasibility;
	}

	public void setFeasibility(Integer feasibility) {
		this.feasibility = feasibility;
	}

	
	
}
