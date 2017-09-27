package com.delta.workshop.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.QuestionAnswer;
import com.delta.workshop.model.Questionnaire;
import com.delta.workshop.model.QuestionnaireQuestion;
import com.delta.workshop.model.QuestionnaireUserAnswer;
import com.delta.workshop.model.QuestionnaireUserAnswerGeneral;

@Mapper
public interface QuestionnaireMapper {

	void addPreface(Questionnaire questionnaire);
	
	void deletePreface(Integer workshopId);

	void addQuestion(QuestionnaireQuestion questionnaireQuestion);

	void addAnswer(@Param("list") List<QuestionAnswer> questionAnswers, @Param("questionId") Integer questionId);
	
	void editQuestion(QuestionnaireQuestion questionnaireQuestion);

	void deleteAnswer(Integer id);

	void deleteQuestion(Integer id);

	Questionnaire getQuestionnaire(Integer workshopId);

	void addUserAnswerGeneral(QuestionnaireUserAnswerGeneral questionnaireUserAnswerGeneral);

	void addUserAnswer(@Param("list") List<QuestionnaireUserAnswer> questionnaireUserAnswers, @Param("id") Integer id);

	Integer getQuestionnaireCount(Integer workshopId);

	Questionnaire getQuestionSummary(Integer workshopId);

	List<HashMap<String, Object>> getnoChoiceQuestionSummary(Integer workshopId);

	int getUsercount(String username);

	Questionnaire getResultByUsername(@Param("workshopId") Integer workshopId , @Param("username") String username);

	void clearUserAnswer(Integer workshopId);

	void orderQuestion(List<QuestionnaireQuestion> questionnaireQuestions);

	

	
}
