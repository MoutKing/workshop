package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.PainpointTemplateMapper;
import com.delta.workshop.model.PainpointTemplate;
import com.delta.workshop.service.PainpointTemplateService;

@Service
public class PainpointTemplateServiceImpl implements PainpointTemplateService {

	@Autowired
	private PainpointTemplateMapper painpointTemplateMapper;

	@Override
	public List<PainpointTemplate> getPainpointTemplateByCondition(Integer industryId, Integer targetId, String customer) {
		return painpointTemplateMapper.getPainpointTemplateByCondition(industryId, targetId, customer);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int add(PainpointTemplate painpointTemplate) {
		painpointTemplateMapper.add(painpointTemplate);
		return painpointTemplate.getId();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void edit(PainpointTemplate painpointTemplate) {
		painpointTemplate.setEditTime(new Date());
		painpointTemplateMapper.edit(painpointTemplate);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		painpointTemplateMapper.delete(id);
	}

}
