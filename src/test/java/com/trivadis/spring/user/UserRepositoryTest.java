package com.trivadis.spring.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.Set;

import com.trivadis.spring.user.domain.User;
import com.trivadis.spring.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindByLastname() {
		Set<User> users = userRepository.findByLastname("Spencer");
		assertEquals(1, users.size());
		Optional<User> firstUser = users.stream().findFirst();
		assertTrue(firstUser.isPresent());
		assertEquals("Bud", firstUser.get().getFirstname());
	}

	@Test
	public void testFindByFirstnameAndLastname() {
		User user = userRepository.findByFirstnameAndLastname("Dieter", "Develop");
		assertNotNull(user);
	}

	@Test
	public void testFindByLastnameLikeOrderByLastnameDesc() {
		Set<User> users = userRepository.findByLastnameLikeOrderByLastnameDesc("%r%");
		assertEquals(2, users.size());
		assertEquals("Spencer", users.stream().findFirst().get().getLastname());
	}

}
