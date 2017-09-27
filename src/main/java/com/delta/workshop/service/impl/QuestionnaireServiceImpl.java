package com.delta.workshop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.QuestionnaireMapper;
import com.delta.workshop.model.QuestionAnswer;
import com.delta.workshop.model.Questionnaire;
import com.delta.workshop.model.QuestionnaireQuestion;
import com.delta.workshop.model.QuestionnaireSummary;
import com.delta.workshop.model.QuestionnaireUserAnswerGeneral;
import com.delta.workshop.service.QuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QuestionnaireMapper questionnaireMapper;

	@Override
	public Questionnaire getQuestionnaire(Integer workshopId) {
		return questionnaireMapper.getQuestionnaire(workshopId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addPreface(Questionnaire questionnaire) {
		if (questionnaire.getWorkshopId() != null && questionnaire.getPreface() != null
				&& !"".equals(questionnaire.getPreface().trim())) {
			questionnaireMapper.addPreface(questionnaire);
		} else {
			throw new IllegalArgumentException("参数错误");
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editPreface(Questionnaire questionnaire) {
		if (questionnaire.getWorkshopId() != null && questionnaire.getPreface() != null
				&& !"".equals(questionnaire.getPreface().trim())) {
			questionnaireMapper.deletePreface(questionnaire.getWorkshopId());
			questionnaireMapper.addPreface(questionnaire);
		} else {
			throw new IllegalArgumentException("参数错误");
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addQuestion(QuestionnaireQuestion questionnaireQuestion) {
		questionnaireMapper.addQuestion(questionnaireQuestion);
		Integer questionId = questionnaireQuestion.getQuestionId();
		List<QuestionAnswer> questionAnswers = questionnaireQuestion.getQuestionAnswers();
		if (questionAnswers != null && questionAnswers.size() != 0) {
			questionnaireMapper.addAnswer(questionAnswers, questionId);
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editQuestion(QuestionnaireQuestion questionnaireQuestion) {
		Integer questionId = questionnaireQuestion.getQuestionId();
		questionnaireMapper.deleteAnswer(questionId);
		List<QuestionAnswer> questionAnswers = questionnaireQuestion.getQuestionAnswers();
		if (questionAnswers != null && questionAnswers.size() != 0) {
			questionnaireMapper.addAnswer(questionAnswers, questionId);
		}
		questionnaireMapper.editQuestion(questionnaireQuestion);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteQuestion(Integer id) {
		// questionnaireMapper.deleteAnswer(id);
		questionnaireMapper.deleteQuestion(id);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addUserAnswer(QuestionnaireUserAnswerGeneral questionnaireUserAnswerGeneral) {
		String username = questionnaireUserAnswerGeneral.getUsername();
		int usercount = questionnaireMapper.getUsercount(username);
		if (usercount != 0) {
			throw new IllegalArgumentException("您已经回答过此问卷！");
		}
		questionnaireMapper.addUserAnswerGeneral(questionnaireUserAnswerGeneral);
		questionnaireMapper.addUserAnswer(questionnaireUserAnswerGeneral.getQuestionnaireUserAnswers(),
				questionnaireUserAnswerGeneral.getId());
	}

	@Override
	public QuestionnaireSummary getSummary(Integer workshopId) {
		QuestionnaireSummary questionnaireSummary = new QuestionnaireSummary();
		// 获取问卷份数
		Integer questionnaireCount = questionnaireMapper.getQuestionnaireCount(workshopId);
		// 获取选择题的汇总
		Questionnaire questionnaire = questionnaireMapper.getQuestionSummary(workshopId);
		// 获取非选择题的汇总
		List<HashMap<String, Object>> noChoiceQuestionSummary = questionnaireMapper
				.getnoChoiceQuestionSummary(workshopId);

		Map<String, List<String>> noChoiceQuestionSummaryMap = new LinkedHashMap<String, List<String>>();
		for (HashMap<String, Object> hashMap : noChoiceQuestionSummary) {
			String question = (String) hashMap.get("question");
			if (noChoiceQuestionSummaryMap.containsKey(question)) {
				noChoiceQuestionSummaryMap.get(question).add((String) hashMap.get("answer_content"));
			} else {
				List<String> questionAnswers = new ArrayList<String>();
				questionAnswers.add((String) hashMap.get("answer_content"));
				noChoiceQuestionSummaryMap.put(question, questionAnswers);
			}
		}
		
		List<QuestionnaireQuestion> questions = questionnaire.getQuestions();
		for (QuestionnaireQuestion questionnaireQuestion : questions) {
			int answerType =questionnaireQuestion.getAnswerType();
			if(answerType==3){
				String question = questionnaireQuestion.getQuestion();
				List<String> questionAnswers = noChoiceQuestionSummaryMap.get(question);
				questionnaireQuestion.setAnswerContent(questionAnswers);
			}
		}
		questionnaireSummary.setQuestionnaireCount(questionnaireCount);
		questionnaireSummary.setQuestionnaireSummary(questionnaire.getQuestions());
		return questionnaireSummary;
	}

	@Override
	public Questionnaire getQuestionnairebyUsername(Integer workshopId, String username) {
		
		Questionnaire questionnaire = questionnaireMapper.getResultByUsername(workshopId, username);
		return questionnaire;
	}

	@Override
	public void clearUserAnswer(Integer workshopId) {
		questionnaireMapper.clearUserAnswer(workshopId);
		
	}

	@Override
	public void orderQuestion(List<QuestionnaireQuestion> questionnaireQuestions) {
		questionnaireMapper.orderQuestion(questionnaireQuestions);
		
	}

}
