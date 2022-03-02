package com.emanager.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanager.security.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findUserByUsername(String username);
}
