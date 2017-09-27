package com.delta.workshop.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.delta.workshop.model.User;
import com.delta.workshop.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public User login(User requestUser) {
		UsernamePasswordToken token = new UsernamePasswordToken(requestUser.getUserId(), requestUser.getPassword());
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			currentUser.login(token);
		}
		User user = (User) currentUser.getPrincipal();
		
		return user;
	}

	@Override
	public void logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
	}

}
