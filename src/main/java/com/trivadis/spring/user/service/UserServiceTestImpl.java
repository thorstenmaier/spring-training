package com.trivadis.spring.user.service;

import com.trivadis.spring.user.domain.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("test")
public class UserServiceTestImpl implements UserService {

	public List<User> getAllUsers() {
		return Arrays.asList(new User("TestGuenther", "TestNubert"));
	}
}