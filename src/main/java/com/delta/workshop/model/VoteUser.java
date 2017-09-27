package com.delta.workshop.model;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-7-4 下午4:00:55
 * @Description
 */
public class VoteUser {
	 /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 用户名字
     */
    private String userName;
    /**
     * 用户是否投票
     */
    private Integer isVote;
    /**
     * 用户是否弃权
     */
    private Integer isAbstain;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getIsVote() {
		return isVote;
	}
	public void setIsVote(Integer isVote) {
		this.isVote = isVote;
	}
	public Integer getIsAbstain() {
		return isAbstain;
	}
	public void setIsAbstain(Integer isAbstain) {
		this.isAbstain = isAbstain;
	}
    
    
}
