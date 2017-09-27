package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.GroupMember;
import com.delta.workshop.model.Groups;

@Mapper
public interface GroupsMapper {

	void add(Groups groups);

	void delete(Integer id);

	void edit(Groups groups);

	List<Groups> getAll(Integer workshopId);

	void addMember(GroupMember groupMember);

	void deleteMember(Integer id);

	List<GroupMember> getAllMember(@Param("workshopId") Integer workshopId, @Param("groupId") Integer groupId);

	void editMember(GroupMember groupMember);

}
