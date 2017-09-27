package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.PainpointAspectMapper;
import com.delta.workshop.model.PainpointAspect;
import com.delta.workshop.service.PainpointAspectService;

@Service
public class PainpointAspectServiceImpl implements PainpointAspectService {

	@Autowired
	private PainpointAspectMapper painpointAspectMapper;

	@Override
	public List<PainpointAspect> getbyIndustry(Integer industryId) {
		return painpointAspectMapper.getbyIndustry(industryId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int add(PainpointAspect painpointAspect) {
		painpointAspectMapper.add(painpointAspect);	
		return painpointAspect.getId();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void edit(PainpointAspect painpointAspect) {
		painpointAspect.setEditTime(new Date());
		painpointAspectMapper.edit(painpointAspect);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void delete(Integer id) {
		painpointAspectMapper.delete(id);	
	}


}
