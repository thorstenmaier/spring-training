package com.trivadis.spring.user.service;

import com.trivadis.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

	@Value("${user.firstnames}")
	private String[] firstnames;

	@Value("${user.lastnames}")
	private String[] lastnames;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < firstnames.length; i++) {
			users.add(new User(firstnames[i], lastnames[i]));
		}
		return users;
	}
}