package com.cognizant.truyum.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.security.model.AuthRequest;
import com.cognizant.truyum.security.model.AuthUser;
import com.cognizant.truyum.security.service.MyUserDetailsService;
import com.cognizant.truyum.security.util.JwtUtil;
import com.cognizant.truyum.service.UserService;


@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@PostMapping("/login")
	public String authenticate(@RequestBody AuthRequest authRequest) throws Exception{
		try {
			authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Inavlid username/password...");
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}
	
	@PostMapping("/register")
	public User createUser(@RequestBody User user) throws Exception {
		return userDetailsService.saveUser(user);
	}
}
