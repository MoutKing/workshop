package com.delta.workshop.model;

import java.util.Date;
import java.util.List;

public class QuestionnaireUserAnswerGeneral {
	private Integer id;
	private String username;
	private Integer workshopId;
	private List<QuestionnaireUserAnswer> questionnaireUserAnswers;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}
	private Date createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<QuestionnaireUserAnswer> getQuestionnaireUserAnswers() {
		return questionnaireUserAnswers;
	}
	public void setQuestionnaireUserAnswers(List<QuestionnaireUserAnswer> questionnaireUserAnswers) {
		this.questionnaireUserAnswers = questionnaireUserAnswers;
	}
}	
