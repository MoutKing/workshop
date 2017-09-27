package com.delta.workshop.model;

public class Voting {

	/**
	 * 投票对象
	 */
	private Integer id;

	/**
	 * 用户
	 */
	private Integer userId;

	/**
	 * 重要性排序
	 */
	private Integer sequence;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (null != id) {
			if (id instanceof Integer && id > 0) {
				this.id = id;
			} else
				throw new IllegalArgumentException("投票对象ID只能为大于0的整数");
		} else
			throw new IllegalArgumentException("投票对象ID不能为空");
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {

		if (null != userId) {
			if (id instanceof Integer && userId > 0) {
				this.userId = userId;
			} else
				throw new IllegalArgumentException("投票者ID只能为大于0的整数");
		} else
			throw new IllegalArgumentException("投票者ID不能为空");

	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		


		if (null != sequence) {
			if (id instanceof Integer && sequence >= 0) {
				this.sequence = sequence;
			} else
				throw new IllegalArgumentException("投票分数只能为大于等于0的整数");
		} else
			throw new IllegalArgumentException("投票分数不能为空");

	
	}

}
