package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.AuthRequest;
import com.cognizant.util.JwtUtil;

@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/get-token")
	public String authenticate(@RequestBody AuthRequest authRequest) throws Exception{
		try {
			authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Inavlid username/password...");
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
