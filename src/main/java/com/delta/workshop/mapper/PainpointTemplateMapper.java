package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.PainpointTemplate;

@Mapper
public interface PainpointTemplateMapper {

	void add(PainpointTemplate painpointTemplate);

	void edit(PainpointTemplate painpointTemplate);

	void delete(Integer id);

	List<PainpointTemplate> getPainpointTemplateByCondition(@Param("industryId") Integer industryId,
			@Param("targetId") Integer targetId, @Param("customer") String customer);

}
