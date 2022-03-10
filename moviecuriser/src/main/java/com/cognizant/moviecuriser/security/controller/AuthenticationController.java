package com.cognizant.moviecuriser.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecuriser.model.User;
import com.cognizant.moviecuriser.security.model.AuthRequest;
import com.cognizant.moviecuriser.security.service.MyUserDetailsService;
import com.cognizant.moviecuriser.security.util.JwtUtil;


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
