package com.trivadis.spring.user.service;

import com.trivadis.spring.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

	private LogService logService;

	public UserServiceImpl(LogService logService) {
		this.logService = logService;
	}

	public List<User> getAllUsers() {
		logService.log("getAllUsers called");
		return Arrays.asList(new User("Guenther", "Nubert"), new User("Bud", "Spencer"),
				new User("Dieter", "Develop"));
	}
}