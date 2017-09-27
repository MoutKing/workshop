package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.OpportunityTemplateMapper;
import com.delta.workshop.model.OpportunityTemplate;
import com.delta.workshop.service.OpportunityTemplateService;

@Service
public class OpportunityTemplateServiceImpl implements OpportunityTemplateService {

	@Autowired
	private OpportunityTemplateMapper opportunityTemplateMapper;

	@Override
	public List<OpportunityTemplate> getbyCondition(Integer industryId, Integer targetId, String customer) {
		return opportunityTemplateMapper.getbyCondition(industryId, targetId, customer);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int add(OpportunityTemplate opportunity) {
		opportunityTemplateMapper.add(opportunity);	
		return opportunity.getId();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void edit(OpportunityTemplate opportunity) {
		opportunity.setEditTime(new Date());
		opportunityTemplateMapper.edit(opportunity);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void delete(Integer id) {
		opportunityTemplateMapper.delete(id);	
	}
}
