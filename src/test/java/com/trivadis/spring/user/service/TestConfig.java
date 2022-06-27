package com.trivadis.spring.user.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public UserService userService(LogService logService) {
        return new UserServiceImpl(logService);
    }

    @Bean
    public LogService logService() {
        return s -> {};
    }
}
