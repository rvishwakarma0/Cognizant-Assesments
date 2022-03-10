package com.emanager.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private String roles;
	private boolean active;
	
	public User(String username, String password, String roles, boolean active) {
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.active = active;
	}
	
}
