package com.trivadis.spring.user.service;

import org.springframework.stereotype.Component;

@Component
public class LogServiceImpl implements LogService {
    @Override
    public void log(String message) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }
}
