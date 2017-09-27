package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.PainpointFactor;

@Mapper
public interface PainpointFactorMapper {

	List<PainpointFactor> getbyIndustry(Integer industryId);

	void add(PainpointFactor painpointFactor);

	void edit(PainpointFactor painpointFactor);

	void delete(Integer id);

}
