package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.Case;
import com.delta.workshop.model.NodePicture;
import com.delta.workshop.model.NodeTree;

public interface CaseService {

	List<Case> getConditionTree(Integer workshopId);

	List<NodeTree> getNodeTree(Integer featureId, Integer mainprocesssiteId);

	List<NodePicture> getNodePicture(Integer nodeId);

}
