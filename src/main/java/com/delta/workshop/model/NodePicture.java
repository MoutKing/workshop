package com.delta.workshop.model;

import java.util.Date;

public class NodePicture {
	
	private Long pictureId;
	private Integer nodeId;
	private String type;
	private Date time;
	private String xValue;
	private Float yValue;
	private String featureParameter;
	private Float threshold;

	public Long getPictureId() {
		return pictureId;
	}

	public void setPictureId(Long pictureId) {
		this.pictureId = pictureId;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getxValue() {
		return xValue;
	}

	public void setxValue(String xValue) {
		this.xValue = xValue == null ? null : xValue.trim();
	}

	public Float getyValue() {
		return yValue;
	}

	public void setyValue(Float yValue) {
		this.yValue = yValue;
	}

	public String getFeatureParameter() {
		return featureParameter;
	}

	public void setFeatureParameter(String featureParameter) {
		this.featureParameter = featureParameter == null ? null : featureParameter.trim();
	}

	public Float getThreshold() {
		return threshold;
	}

	public void setThreshold(Float threshold) {
		this.threshold = threshold;
	}
}
