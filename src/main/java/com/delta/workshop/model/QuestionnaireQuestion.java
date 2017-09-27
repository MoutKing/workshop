package com.delta.workshop.model;

import java.util.List;

public class QuestionnaireQuestion {
	private Integer questionId;
	private String question;
	private Integer answerType;
	private List<String> answerContent;
	private Integer questionSequence;
	private Integer workshopId;
	private List<QuestionAnswer> questionAnswers;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getAnswerType() {
		return answerType;
	}

	public void setAnswerType(Integer answerType) {
		this.answerType = answerType;
	}

	public Integer getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}

	public List<QuestionAnswer> getQuestionAnswers() {
		return questionAnswers;
	}

	public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setId(Integer questionId) {
		this.questionId = questionId;
	}

	

	public Integer getQuestionSequence() {
		return questionSequence;
	}

	public void setQuestionSequence(Integer questionSequence) {
		this.questionSequence = questionSequence;
	}

	public List<String> getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(List<String> answerContent) {
		this.answerContent = answerContent;
	}
	
}
