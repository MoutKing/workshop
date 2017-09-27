package com.delta.workshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.workshop.mapper.QuestionMapper;
import com.delta.workshop.model.Question;
import com.delta.workshop.service.OpportunityQuestionService;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-27 下午3:27:05
 * @Description
 */
@Service
public class OpportunityQuestionServiceImpl implements OpportunityQuestionService {
    @Autowired
    private  QuestionMapper  mapper;
    
    @Override
    public Integer add(Integer id, Question question) {
	if (id==2) {
	    return mapper.add(question);
	} else {
	   return mapper.add3(question);
	}
    }

    @Override
    public Integer delete(Integer id, Integer qId) {
	if (id==2) {
	    return mapper.delete(qId);
	} else {
	   return mapper.delete3(qId);
	}
    }

    @Override
    public Integer update(Integer id, List<Question> question) {
	if (id==2) {
	    return mapper.update(question);
	} else {
	   return mapper.update3(question);
	}
    }

    @Override
    public List<Question> list(Integer id,String type, Integer groupId) {
	if (id==2) {
	    return mapper.list(type,groupId);
	} else {
	   return mapper.list3(type,groupId);
	}
    }

}
