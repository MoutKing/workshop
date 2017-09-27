package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.ImprovewayTemplate;

@Mapper
public interface ImprovewayTemplateMapper {

	List<ImprovewayTemplate> getImprovewayTemplateByCondition(@Param("industryId")Integer industryId,@Param("targetId")Integer targetId,@Param("customer") String customer);

	void add(ImprovewayTemplate improvewayTemplate);

	void edit(ImprovewayTemplate improvewayTemplate);

	void delete(Integer id);

}
