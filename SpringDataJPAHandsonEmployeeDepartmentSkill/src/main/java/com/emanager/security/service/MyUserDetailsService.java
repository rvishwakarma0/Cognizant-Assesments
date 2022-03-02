package com.emanager.security.service;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emanager.security.model.AuthRequest;
import com.emanager.security.model.CustomUserDetails;
import com.emanager.security.model.User;
import com.emanager.security.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	private static PasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findUserByUsername(username);
		return new CustomUserDetails(user);
	}

	public void saveUser(AuthRequest ar) {
		User u = new User(ar.getUsername(),ar.getPassword(), "USER", true);
		u.setPassword(bcryptEncoder.encode(ar.getPassword()));
		userRepo.save(u);
	}

	public void saveAdmin(AuthRequest ar) {
		User u = new User(ar.getUsername(),ar.getPassword(), "ADMIN", true);
		u.setPassword(bcryptEncoder.encode(ar.getPassword()));
		userRepo.save(u);
	}
}

