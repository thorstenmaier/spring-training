package com.trivadis.spring.user;

import com.trivadis.spring.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ServiceClient {

	public ServiceClient(UserService userService) {
		System.out.println(userService.hashCode());
		userService.getAllUsers().forEach(System.out::println);
	}
}
