package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.Questionnaire;
import com.delta.workshop.model.QuestionnaireQuestion;
import com.delta.workshop.model.QuestionnaireSummary;
import com.delta.workshop.model.QuestionnaireUserAnswerGeneral;

public interface QuestionnaireService {

	Questionnaire getQuestionnaire(Integer workshopId);

	void addPreface(Questionnaire questionnaire);

	void addQuestion(QuestionnaireQuestion questionnaireQuestion);

	void editQuestion(QuestionnaireQuestion questionnaireQuestion);

	void deleteQuestion(Integer id);

	void editPreface(Questionnaire questionnaire);

	void addUserAnswer(QuestionnaireUserAnswerGeneral questionnaireUserAnswerGeneral);

	QuestionnaireSummary getSummary(Integer workshopId);

	Questionnaire getQuestionnairebyUsername(Integer workshopId, String username);

	void clearUserAnswer(Integer workshopId);

	void orderQuestion(List<QuestionnaireQuestion> questionnaireQuestions);

}
