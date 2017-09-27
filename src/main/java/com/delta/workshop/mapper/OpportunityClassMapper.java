package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.OpportunityClass;

@Mapper
public interface OpportunityClassMapper {

	List<OpportunityClass> getAll(Integer industryId);

	void add(OpportunityClass opportunityClass);

	void edit(OpportunityClass opportunityClass);

	void delete(Integer id);

}
