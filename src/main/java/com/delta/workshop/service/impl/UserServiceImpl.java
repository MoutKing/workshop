package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.UserMapper;
import com.delta.workshop.model.User;
import com.delta.workshop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> get() {
		return userMapper.get();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void add(User user) {
		userMapper.add(user);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void edit(User user) {
		user.setEditTime(new Date());
		userMapper.edit(user);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(String userId) {
		userMapper.delete(userId);

	}

	@Override
	public User getByUsernameAndPassword(String userId) {
		return userMapper.getByUsernameAndPassword(userId);
	}

	@Override
	public Set<String> getRolesByUserId(String userId) {
		return userMapper.getRolesByUserId(userId);
	}

}
