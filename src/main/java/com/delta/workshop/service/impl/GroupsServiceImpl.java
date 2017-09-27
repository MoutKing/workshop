package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.GroupsMapper;
import com.delta.workshop.mapper.UserMapper;
import com.delta.workshop.model.GroupMember;
import com.delta.workshop.model.Groups;
import com.delta.workshop.model.User;
import com.delta.workshop.service.GroupsService;

@Service
public class GroupsServiceImpl implements GroupsService {

	private static final int ROLEID = 3;
	private static final String DEFAULTPASSWORD = "123456";

	@Autowired
	private GroupsMapper groupsMapper;

	@Autowired
	private UserMapper userMapper;

	/*
	 * 增加组的同时，增加用于这个组用户登录的账号
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void add(Groups groups) {

		groupsMapper.add(groups);

		User user = new User();
		user.setUserId(groups.getName());
		user.setName(groups.getName());
		user.setPassword(DEFAULTPASSWORD);
		user.setRoleId(ROLEID);
		user.setWorkshopId(groups.getWorkshopId());
		user.setGroupId(groups.getId());

		userMapper.add(user);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		groupsMapper.delete(id);
		userMapper.deleteGroupAccount(id);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void edit(Groups groups) {
		groups.setEditTime(new Date());
		groupsMapper.edit(groups);

		User user = new User();
		user.setUserId(groups.getName());
		user.setName(groups.getName());
		user.setWorkshopId(groups.getWorkshopId());
		user.setGroupId(groups.getId());

		userMapper.editGroupAccount(user);

	}

	@Override
	public List<Groups> getAll(Integer workshopId) {
		return groupsMapper.getAll(workshopId);
	}

	@Override
	public void deleteMember(Integer id) {
		groupsMapper.deleteMember(id);

	}

	@Override
	public List<GroupMember> getAllMember(Integer workshopId, Integer groupId) {

		return groupsMapper.getAllMember(workshopId, groupId);
	}

	@Override
	public void addMember(GroupMember groupMember) {
		groupsMapper.addMember(groupMember);

	}

	@Override
	public void editMember(GroupMember groupMember) {
		groupsMapper.editMember(groupMember);
	}

}
