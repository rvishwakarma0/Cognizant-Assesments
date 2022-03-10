package com.cognizant.truyum.security.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private AuthUser user;
		
	public CustomUserDetails() {
		super();
	}
	
	public CustomUserDetails(AuthUser user) {
		super();
		this.user = user;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	/*	return Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	*/
		
		List<SimpleGrantedAuthority> rolesList=new ArrayList<>();
		for(String role:user.getRole().split(",")) {
			rolesList.add(new SimpleGrantedAuthority(role));
			}
		return rolesList;
	}
		
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isActive();
	}

}
