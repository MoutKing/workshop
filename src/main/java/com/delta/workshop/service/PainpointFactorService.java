package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.PainpointFactor;

public interface PainpointFactorService {

	List<PainpointFactor> getbyIndustry(Integer industryId);

	int add(PainpointFactor painpointFactor);

	void edit(PainpointFactor painpointFactor);

	void delete(Integer id);

}
