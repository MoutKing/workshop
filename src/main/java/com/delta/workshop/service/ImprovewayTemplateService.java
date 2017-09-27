package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.ImprovewayTemplate;

public interface ImprovewayTemplateService {

	List<ImprovewayTemplate> getImprovewayTemplateByCondition(Integer industryId, Integer targetId, String customer);

	int add(ImprovewayTemplate improvewayTemplate);

	void edit(ImprovewayTemplate improvewayTemplate);

	void delete(Integer id);

}
