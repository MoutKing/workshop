package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.ImprovewayTemplateMapper;
import com.delta.workshop.model.ImprovewayTemplate;
import com.delta.workshop.service.ImprovewayTemplateService;

@Service
public class ImprovewayTemplateServiceImpl implements ImprovewayTemplateService {

	@Autowired
	private ImprovewayTemplateMapper improvewayTemplateMapper;

	@Override
	public List<ImprovewayTemplate> getImprovewayTemplateByCondition(Integer industryId, Integer targetId, String customer) {
		return improvewayTemplateMapper.getImprovewayTemplateByCondition(industryId, targetId, customer);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int add(ImprovewayTemplate improvewayTemplate) {
		improvewayTemplateMapper.add(improvewayTemplate);
		return improvewayTemplate.getId();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void edit(ImprovewayTemplate improvewayTemplate) {
		improvewayTemplate.setEditTime(new Date());
		improvewayTemplateMapper.edit(improvewayTemplate);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		improvewayTemplateMapper.delete(id);
	}

}
