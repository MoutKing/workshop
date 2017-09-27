package com.delta.workshop.model;

import java.util.List;

public class QuestionnaireSummary {
	
	private Integer questionnaireCount ;
	private List<QuestionnaireQuestion> QuestionnaireSummary;
	
	
	public Integer getQuestionnaireCount() {
		return questionnaireCount;
	}
	public void setQuestionnaireCount(Integer questionnaireCount) {
		this.questionnaireCount = questionnaireCount;
	}
	public List<QuestionnaireQuestion> getQuestionnaireSummary() {
		return QuestionnaireSummary;
	}
	public void setQuestionnaireSummary(List<QuestionnaireQuestion> questionnaireSummary) {
		QuestionnaireSummary = questionnaireSummary;
	}
	
	
}
