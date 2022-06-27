package com.trivadis.spring.user.service;

import com.trivadis.spring.user.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class) // kann entfallen, da in @SpringBootTest enthalten
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private LogService logService;

    @Test
    public void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        assertEquals(3, users.size());
    }
}