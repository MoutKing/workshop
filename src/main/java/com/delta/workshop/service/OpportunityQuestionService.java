package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.Question;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-27 下午3:30:43
 * @Description
 */
public interface OpportunityQuestionService {

    /**
     * 这个接口用来添加问题
     * 
     * @param id
     * @param question
     * @return
     */
    Integer add(Integer id, Question question);

    /**
     * 这个接口用来删除问题
     * 
     * @param id
     * @param qId
     * @return
     */
    Integer delete(Integer id, Integer qId);

    /**
     * 更新问题
     * 
     * @param id
     * @param question
     * @return
     */
    Integer update(Integer id, List<Question> question);

    /**
     * 查询所有问题
     * 
     * @param id
     * @param groupId 
     * @param type 
     * @return
     */
    List<Question> list(Integer id, String type, Integer groupId);

}
