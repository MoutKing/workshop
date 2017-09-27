package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.ImprovewayMapper;
import com.delta.workshop.model.Improveway;
import com.delta.workshop.service.ImprovewayService;

@Service
public class ImprovewayServiceImpl implements ImprovewayService {

	@Autowired
	private ImprovewayMapper improvewayMapper;

	@Override
	public List<Improveway> getbyGroup(Integer workshopId,Integer groupId) {
		return improvewayMapper.getbyGroup(workshopId,groupId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int add(Improveway improveway) {
		improvewayMapper.add(improveway);
		return improveway.getId();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void edit(Improveway improveway) {
		improveway.setEditTime(new Date());
		improvewayMapper.edit(improveway);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		improvewayMapper.delete(id);
	}

	@Override
	public List<Improveway> getImprovewaytDisplayInfo(Integer workshopId) {
		return improvewayMapper.getImprovewaytDisplayInfo(workshopId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addRelation(List<Improveway> improveways) {
		if(improveways!= null){
			improvewayMapper.clearRelation(improveways);
			improvewayMapper.addDisplayBytemplate(improveways);
		}
		
	}

}
