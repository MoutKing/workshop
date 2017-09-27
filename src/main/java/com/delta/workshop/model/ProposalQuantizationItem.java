package com.delta.workshop.model;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-8-14 上午10:51:24
 * @Description webtool 第四单元 效益分析模板 数据
 */
public class ProposalQuantizationItem {
	private Integer id;
	private Float item;
	private Integer quantizationPhaseId;
	private Integer quantizationBenefitId;
	private Integer quantizationCostId;
	private Integer quantizationId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getItem() {
		return item;
	}

	public void setItem(Float item) {
		this.item = item;
	}

	public Integer getQuantizationPhaseId() {
		return quantizationPhaseId;
	}

	public void setQuantizationPhaseId(Integer quantizationPhaseId) {
		this.quantizationPhaseId = quantizationPhaseId;
	}

	public Integer getQuantizationBenefitId() {
		return quantizationBenefitId;
	}

	public void setQuantizationBenefitId(Integer quantizationBenefitId) {
		this.quantizationBenefitId = quantizationBenefitId;
	}

	public Integer getQuantizationCostId() {
		return quantizationCostId;
	}

	public void setQuantizationCostId(Integer quantizationCostId) {
		this.quantizationCostId = quantizationCostId;
	}

	public Integer getQuantizationId() {
		return quantizationId;
	}

	public void setQuantizationId(Integer quantizationId) {
		this.quantizationId = quantizationId;
	}

}
