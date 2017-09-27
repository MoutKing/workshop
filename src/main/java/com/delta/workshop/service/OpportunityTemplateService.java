package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.OpportunityTemplate;

public interface OpportunityTemplateService {

	int add(OpportunityTemplate opportunity);

	void edit(OpportunityTemplate opportunity);

	void delete(Integer id);

	List<OpportunityTemplate> getbyCondition(Integer painpointId, Integer opportunityClassId, String customer);

}
