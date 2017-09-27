package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.OpportunityTemplate;

@Mapper
public interface OpportunityTemplateMapper {

	List<OpportunityTemplate> getbyCondition(@Param("industryId")Integer industryId, @Param("targetId")Integer targetId, @Param("customer")String customer);

	void add(OpportunityTemplate opportunity);

	void edit(OpportunityTemplate opportunity);

	void delete(Integer id);

}
