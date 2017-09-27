package com.delta.workshop.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.User;

@Mapper
public interface UserMapper {

	void edit(User user);

	void delete(String userId);

	void add(User user);
	
	List<User> get();

	User getByUsernameAndPassword(String userId);

	Set<String> getRolesByUserId(String userId);

	void editGroupAccount(User user);

	void deleteGroupAccount(Integer groupId);

}
