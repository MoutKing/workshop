package com.delta.workshop.service;

import java.util.List;
import java.util.Set;

import com.delta.workshop.model.User;

public interface UserService {

	List<User> get();

	void add(User user);

	void edit(User user);

	void delete(String userId);

	User getByUsernameAndPassword(String userId);

	Set<String> getRolesByUserId(String userId);


}
