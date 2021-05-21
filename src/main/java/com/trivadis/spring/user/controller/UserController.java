package com.trivadis.spring.user.controller;

import java.util.List;

import com.trivadis.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.trivadis.spring.user.domain.User;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userService.findUserById(id);
	}
}
