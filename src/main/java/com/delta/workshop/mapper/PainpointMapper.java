package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.Painpoint;

@Mapper
public interface PainpointMapper {

	void add(Painpoint painpoint);

	void edit(Painpoint painpoint);

	void delete(Integer id);

	List<Painpoint> getAll(@Param("workshopId") Integer workshopId, @Param("groupId") Integer groupId);

	void deleteDisplay(Integer id);

	void addDisplayBySelf(Painpoint painpoint);
	
	void addDisplayBytemplate(List<Painpoint> painpoints);
	
	void editDisplay(Painpoint painpoint);

	List<Painpoint> getPainpointDisplayInfo(Integer workshopId);

	void clearRelation(List<Painpoint> painpoints);

}
