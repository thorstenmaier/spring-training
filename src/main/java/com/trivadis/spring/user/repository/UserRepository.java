package com.trivadis.spring.user.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trivadis.spring.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Set<User> findByLastname(String lastname);

	User findByFirstnameAndLastname(String firstname, String lastname);

	Set<User> findByLastnameLikeOrderByLastnameDesc(String lastnameLike);

}
