package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.GroupMember;
import com.delta.workshop.model.Groups;

public interface GroupsService {

	void add(Groups groups);

	void delete(Integer id);

	void edit(Groups groups);

	List<Groups> getAll(Integer workshopId);

	void addMember(GroupMember groupMember);

	void deleteMember(Integer id);

	List<GroupMember> getAllMember(Integer workshopId, Integer groupId);

	void editMember(GroupMember groupMember);

}
