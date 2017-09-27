package com.delta.workshop.model;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-20 下午3:09:30
 * @Description
 */
public class VotingPainPoint {

	/**
	 * 项目编号
	 */
	private Integer workshopId;
	/**
	 * 组编号
	 */
	private Integer groupId;
	private String groupName;
	/**
	 * 痛点编号
	 */
	private Integer id;

	/**
	 * 痛点名字
	 */
	private String name;

	/**
	 * 痛点面向名字
	 */
	private String aspectName;
	private Integer aspectId;
	/**
	 * 痛点因素
	 */
	private String factorName;
	private Integer factorId;
	/**
	 * 痛点影响
	 */
	private String influence;

	/**
	 * 重要性排序
	 */
	private Integer sequence;
	private Float grade;

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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAspectName() {
		return aspectName;
	}

	public void setAspectName(String aspectName) {
		this.aspectName = aspectName;
	}

	public Integer getAspectId() {
		return aspectId;
	}

	public void setAspectId(Integer aspectId) {
		this.aspectId = aspectId;
	}

	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public Integer getFactorId() {
		return factorId;
	}

	public void setFactorId(Integer factorId) {
		this.factorId = factorId;
	}

	public String getInfluence() {
		return influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

}
