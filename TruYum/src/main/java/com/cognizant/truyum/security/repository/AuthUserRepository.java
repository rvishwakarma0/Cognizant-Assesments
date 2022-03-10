package com.cognizant.truyum.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.security.model.AuthUser;




@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer>{

	AuthUser findUserByUsername(String username);
}
