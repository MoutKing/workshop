package com.delta.workshop.model;

import java.util.List;

public class Case {
	private Long caseId;
	private String caseName;
	private Integer workshopId;
	private List<MeasureSite> measureSite;
	
	public Long getCaseId() {
		return caseId;
	}
	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public List<MeasureSite> getMeasureSite() {
		return measureSite;
	}
	public void setMeasureSite(List<MeasureSite> measureSite) {
		this.measureSite = measureSite;
	}
	public Integer getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}
}	
