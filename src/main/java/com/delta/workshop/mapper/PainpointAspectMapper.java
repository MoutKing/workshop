package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.PainpointAspect;

@Mapper
public interface PainpointAspectMapper {

	List<PainpointAspect> getbyIndustry(Integer industryId);

	void add(PainpointAspect painpointAspect);

	void edit(PainpointAspect painpointAspect);

	void delete(Integer id);

}
