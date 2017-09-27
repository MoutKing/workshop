package com.delta.workshop.model;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-8-14 上午10:50:37
 * @Description webtool 第四单元 效益分析模板 成本
 */
public class ProposalQuantizationCost {
	private Integer id;
	private Integer quantizationId;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantizationId() {
		return quantizationId;
	}

	public void setQuantizationId(Integer quantizationId) {
		this.quantizationId = quantizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
