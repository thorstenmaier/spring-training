package com.trivadis.spring.user.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.trivadis.spring.user.aop.Monitor;
import com.trivadis.spring.user.domain.LogEntry;
import com.trivadis.spring.user.domain.User;
import com.trivadis.spring.user.repository.LogEntryRepository;
import com.trivadis.spring.user.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private LogEntryRepository logEntryRepository;

	public UserServiceImpl(UserRepository userRepository, LogEntryRepository logEntryRepository) {
		this.userRepository = userRepository;
		this.logEntryRepository = logEntryRepository;
	}

	@Monitor
	@RolesAllowed({"USER", "ADMIN"})
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@RolesAllowed("USER")
	public User findUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Transactional
	@RolesAllowed("ADMIN")
	public User createUser(User user) {
		logEntryRepository.save(new LogEntry("User created"));
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
