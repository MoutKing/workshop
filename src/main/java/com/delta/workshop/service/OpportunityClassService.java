package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.OpportunityClass;

public interface OpportunityClassService {

	List<OpportunityClass> getAll(Integer industryId);

	int add(OpportunityClass opportunityClass);

	void edit(OpportunityClass opportunityClass);

	void delete(Integer id);

}
