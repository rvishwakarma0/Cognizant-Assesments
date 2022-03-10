package com.cognizant.truyum.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="authuser")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthUser {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private String role;
	private boolean active;
	
	public AuthUser(String username, String password, String roles, boolean active) {
		this.username = username;
		this.password = password;
		this.role = roles;
		this.active = active;
	}
	
}
