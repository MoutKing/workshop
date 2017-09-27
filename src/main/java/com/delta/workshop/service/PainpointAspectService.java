package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.PainpointAspect;

public interface PainpointAspectService {

	List<PainpointAspect> getbyIndustry(Integer industryId);

	int add(PainpointAspect painpointAspect);

	void edit(PainpointAspect painpointAspect);

	void delete(Integer id);

}
