package com.delta.workshop.model;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-7-10 下午2:50:59
 * @Description
 */
public class FactorConditions {
	private Integer casesId;
	private String analysis;
	private String measureStation;
	private String feature;
	private String majorStation;
	private String analysisLevel;
	private String machine;
	private String machineParameter;

	public Integer getCasesId() {
		return casesId;
	}

	public void setCasesId(Integer casesId) {
		this.casesId = casesId;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getMeasureStation() {
		return measureStation;
	}

	public void setMeasureStation(String measureStation) {
		this.measureStation = measureStation;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getMajorStation() {
		return majorStation;
	}

	public void setMajorStation(String majorStation) {
		this.majorStation = majorStation;
	}

	public String getAnalysisLevel() {
		return analysisLevel;
	}

	public void setAnalysisLevel(String analysisLevel) {
		this.analysisLevel = analysisLevel;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getMachineParameter() {
		return machineParameter;
	}

	public void setMachineParameter(String machineParameter) {
		this.machineParameter = machineParameter;
	}

}
