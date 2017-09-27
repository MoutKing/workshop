package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.PainpointTemplate;

public interface PainpointTemplateService {

	int add(PainpointTemplate painpointTemplate);

	void edit(PainpointTemplate painpointTemplate);

	void delete(Integer id);

	List<PainpointTemplate> getPainpointTemplateByCondition(Integer industryId, Integer targetId, String customer);
	

}
