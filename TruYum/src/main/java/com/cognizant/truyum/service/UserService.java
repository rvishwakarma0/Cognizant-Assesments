package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.exceptions.CartNotFOundException;
import com.cognizant.truyum.exceptions.MenuITemNotFoundException;
import com.cognizant.truyum.exceptions.UserNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.security.model.AuthUser;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User getUserById(int uid) throws Exception {
		Optional<User> optional = userRepository.findById(uid);
		if(optional.isPresent())
			return optional.get();	//return menu-item
		else 
			throw new UserNotFoundException("User not found for "+ uid);
	}
	
	public User createUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	public User getUser() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		for(User u: userRepository.findAll()) {
			if(u.getAuthUser().getUsername().equalsIgnoreCase(username))
				return u;
		}
		return null;
	}
}