package com.delta.workshop.model;

public class Feature {
	private Integer featureId;
	private String featureName;
	private Integer measureSiteId;
	
	public Integer getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public Integer getMeasureSiteId() {
		return measureSiteId;
	}
	public void setMeasureSiteId(Integer measureSiteId) {
		this.measureSiteId = measureSiteId;
	}
}
