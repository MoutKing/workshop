package com.delta.workshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.workshop.mapper.TargetMapper;
import com.delta.workshop.model.Target;
import com.delta.workshop.service.TargetService;

@Service
public class TargetServiceImpl implements TargetService {
	
	@Autowired
	private TargetMapper targetMapper;


	@Override
	public List<Target> getAll() {
		return targetMapper.getAll();
	}

}
