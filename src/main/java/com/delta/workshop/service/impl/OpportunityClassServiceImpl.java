package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.OpportunityClassMapper;
import com.delta.workshop.model.OpportunityClass;
import com.delta.workshop.service.OpportunityClassService;

@Service
public class OpportunityClassServiceImpl implements OpportunityClassService {

	@Autowired
	private OpportunityClassMapper opportunityClassMapper;

	@Override
	public List<OpportunityClass> getAll(Integer industryId) {
		return opportunityClassMapper.getAll(industryId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int add(OpportunityClass opportunityClass) {
		opportunityClassMapper.add(opportunityClass);	
		return opportunityClass.getId();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void edit(OpportunityClass opportunityClass) {
		opportunityClass.setEditTime(new Date());
		opportunityClassMapper.edit(opportunityClass);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void delete(Integer id) {
		opportunityClassMapper.delete(id);	
	}


}
