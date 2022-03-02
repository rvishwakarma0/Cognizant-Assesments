package com.emanager.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emanager.security.model.AuthRequest;
import com.emanager.security.service.MyUserDetailsService;
import com.emanager.security.util.JwtUtil;


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
	public String saveUser(@RequestBody AuthRequest user, @RequestParam("role") String role) throws Exception {
		if(role.equalsIgnoreCase("USER")) {
			userDetailsService.saveUser(user);
			return "user created";
		}
		else if(role.equalsIgnoreCase("ADMIN")) {
			userDetailsService.saveAdmin(user);
			return "user created";
		}
		throw new Exception("unknown role given");
	}
}
