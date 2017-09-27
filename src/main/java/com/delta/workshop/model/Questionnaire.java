package com.delta.workshop.model;

import java.util.List;

public class Questionnaire {
	private String preface;
	private List<QuestionnaireQuestion> questions;
	private Integer workshopId;
	
	public List<QuestionnaireQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionnaireQuestion> questions) {
		this.questions = questions;
	}
	public String getPreface() {
		return preface;
	}
	public void setPreface(String preface) {
		this.preface = preface;
	}
	public Integer getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}
}
