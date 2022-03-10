package com.cognizant.moviecuriser.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.moviecuriser.model.User;

import com.cognizant.moviecuriser.security.model.CustomUserDetails;
import com.cognizant.moviecuriser.security.model.AuthUser;
import com.cognizant.moviecuriser.security.repository.AuthUserRepository;
import com.cognizant.moviecuriser.service.CustomerService;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	AuthUserRepository userRepo;
	
	@Autowired
	CustomerService userService;
	
	private static PasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthUser user=userRepo.findUserByUsername(username);
		return new CustomUserDetails(user);
	}

	public User saveUser(User user) {
		AuthUser authUser = user.getAuthUser();
		authUser.setPassword(bcryptEncoder.encode(authUser.getPassword()));
		userRepo.save(authUser);
		userService.createUser(user); //call to create a normal
		return user;
	}
}

