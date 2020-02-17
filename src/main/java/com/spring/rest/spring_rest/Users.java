package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	private String username;
	private String password;
	private boolean enabled;
	
	public Users(){}
			
	public Users(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	
}
