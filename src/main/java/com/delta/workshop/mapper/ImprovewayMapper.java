package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.Improveway;

@Mapper
public interface ImprovewayMapper {

	List<Improveway> getbyGroup(@Param("workshopId")Integer workshopId,@Param("groupId")Integer groupId);

	void add(Improveway improveway);

	void edit(Improveway improveway);

	void delete(Integer id);

	List<Improveway> getImprovewaytDisplayInfo(Integer workshopId);

	void clearRelation(List<Improveway> improveways);

	void addDisplayBytemplate(List<Improveway> improveways);
}
