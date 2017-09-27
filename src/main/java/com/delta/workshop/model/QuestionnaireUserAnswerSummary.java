package com.delta.workshop.model;

import java.util.List;

public class QuestionnaireUserAnswerSummary {
	private Integer questionId;
	private List<String> answerIds;
	private String answerContent;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public List<String> getAnswerIds() {
		return answerIds;
	}

	public void setAnswerIds(List<String> answerIds) {
		this.answerIds = answerIds;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
}
