package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.Question;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-27 下午3:30:23
 * @Description
 */
@Mapper
public interface QuestionMapper {

	Integer add(Question question);

	Integer add3(Question question);

	Integer delete(Integer id);

	Integer delete3(Integer id);

	Integer update(@Param("question") List<Question> question);

	Integer update3(@Param("question") List<Question> question);

	List<Question> list(@Param("type") String type, @Param("groupId") Integer groupId);

	List<Question> list3(@Param("type") String type, @Param("groupId") Integer groupId);

}
