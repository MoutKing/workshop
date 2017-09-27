package com.delta.workshop.model;

import java.util.List;

public class MeasureSite {
	private Integer measureSiteId;
	private String measureSiteName;
	private Long caseId;
    private List<Feature> feature;
    private List<MainProcessSite> mainProcessSite;
	public Integer getMeasureSiteId() {
		return measureSiteId;
	}
	public void setMeasureSiteId(Integer measureSiteId) {
		this.measureSiteId = measureSiteId;
	}
	public String getMeasureSiteName() {
		return measureSiteName;
	}
	public void setMeasureSiteName(String measureSiteName) {
		this.measureSiteName = measureSiteName;
	}
	public Long getCaseId() {
		return caseId;
	}
	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
	public List<Feature> getFeature() {
		return feature;
	}
	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}
	public List<MainProcessSite> getMainProcessSite() {
		return mainProcessSite;
	}
	public void setMainProcessSite(List<MainProcessSite> mainProcessSite) {
		this.mainProcessSite = mainProcessSite;
	}
	
}
