package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.Case;
import com.delta.workshop.model.NodePicture;
import com.delta.workshop.model.NodeTree;

@Mapper
public interface CaseMapper {

	List<Case> getConditionTree(Integer workshopId);

	List<NodeTree> getNodeTree(@Param("featureId")Integer featureId, @Param("mainprocesssiteId")Integer mainprocesssiteId);

	List<NodePicture> getNodePicture(Integer nodeId);

}
