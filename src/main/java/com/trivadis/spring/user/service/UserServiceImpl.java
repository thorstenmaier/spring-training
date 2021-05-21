package com.trivadis.spring.user.service;

import com.trivadis.spring.user.aop.Monitor;
import com.trivadis.spring.user.domain.User;
import com.trivadis.spring.user.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Monitor
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findUserById(Long id) {
		return userRepository.findById(id).get();
	}
}
