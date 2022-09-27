package com.trivadis.spring.user.service;

import com.trivadis.spring.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

	private final UserProperties userProperties;

	public UserServiceImpl(UserProperties userProperties) {
		this.userProperties = userProperties;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < userProperties.firstnames().length; i++) {
			users.add(new User(userProperties.firstnames()[i], userProperties.lastnames()[i]));
		}
		return users;
	}
}