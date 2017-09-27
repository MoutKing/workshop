package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.PainpointMapper;
import com.delta.workshop.model.Painpoint;
import com.delta.workshop.service.PainpointService;
@Service
public class PainpointServiceImpl implements PainpointService {
	
	@Autowired
	private PainpointMapper painpointMapper;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int add(Painpoint painpoint) {
		painpointMapper.add(painpoint);
		return painpoint.getId();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void edit(Painpoint painpoint) {
		painpoint.setEditTime(new Date());
		painpointMapper.edit(painpoint);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void delete(Integer id) {
		painpointMapper.delete(id);
		
	}

	@Override
	public List<Painpoint> getAll(Integer workshopId, Integer groupId) {
		return painpointMapper.getAll(workshopId,groupId);
	}


	@Override
	public List<Painpoint> getPainpointDisplayInfo(Integer workshopId) {
		return painpointMapper.getPainpointDisplayInfo(workshopId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteDisplay(Integer id) {
		painpointMapper.deleteDisplay(id);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void editDisplay(Painpoint painpoint) {
		painpoint.setEditTime(new Date());
		painpointMapper.editDisplay(painpoint);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int addDisplay(Painpoint painpoint) {
		painpointMapper.addDisplayBySelf(painpoint);
		return painpoint.getId();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addRelation(List<Painpoint> painpoints) {
		if(painpoints!= null){
			painpointMapper.clearRelation(painpoints);
			painpointMapper.addDisplayBytemplate(painpoints);
		}
		
		
	}
}
