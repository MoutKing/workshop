package com.delta.workshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.workshop.mapper.CaseMapper;
import com.delta.workshop.model.Case;
import com.delta.workshop.model.NodePicture;
import com.delta.workshop.model.NodeTree;
import com.delta.workshop.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService {
	
	@Autowired
	private CaseMapper caseMapper;

	@Override
	public List<Case> getConditionTree(Integer workshopId) {
		return caseMapper.getConditionTree(workshopId);
	}

	@Override
	public List<NodeTree> getNodeTree(Integer featureId, Integer mainprocesssiteId) {
		return caseMapper.getNodeTree(featureId,mainprocesssiteId);
	}

	@Override
	public List<NodePicture> getNodePicture(Integer nodeId) {
		return caseMapper.getNodePicture(nodeId);
	}

}
