package com.cognizant.truyum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.model.Cart;

public interface CartRepositroy extends JpaRepository<Cart, Integer> {
	
	@Query("select c from Cart c where c.user.id = ?1")
	Optional<Cart> findCartByUserId(int uid);
	
}