package com.trivadis.spring.user.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user")
public record UserProperties(String[] firstnames, String[] lastnames) {
}
