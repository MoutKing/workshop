package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.PainpointFactorMapper;
import com.delta.workshop.model.PainpointFactor;
import com.delta.workshop.service.PainpointFactorService;
@Service
public class PainpointFactorServiceImpl implements PainpointFactorService {
	
	@Autowired
	private PainpointFactorMapper painpointFcatorMapper;

	@Override
	public List<PainpointFactor> getbyIndustry(Integer industryId) {
		return painpointFcatorMapper.getbyIndustry(industryId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int add(PainpointFactor painpointFactor) {
		painpointFcatorMapper.add(painpointFactor);	
		return painpointFactor.getId();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void edit(PainpointFactor painpointFactor) {
		painpointFactor.setEditTime(new Date());
		painpointFcatorMapper.edit(painpointFactor);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void delete(Integer id) {
		painpointFcatorMapper.delete(id);
		
	}

}
