package com.delta.workshop.service;

import com.delta.workshop.model.User;

public interface LoginService {

	User login(User requestUser);

	void logout();

}
