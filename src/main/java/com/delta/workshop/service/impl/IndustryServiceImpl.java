package com.delta.workshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.workshop.mapper.IndustryMapper;
import com.delta.workshop.model.Industry;
import com.delta.workshop.service.IndustryService;

@Service
public class IndustryServiceImpl implements IndustryService {
	
	@Autowired
	private IndustryMapper IndustryMapper;


	@Override
	public List<Industry> getAll() {
		return IndustryMapper.getAll();
	}

}
