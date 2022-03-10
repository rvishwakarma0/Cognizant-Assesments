package com.cognizant.moviecuriser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.moviecuriser.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
