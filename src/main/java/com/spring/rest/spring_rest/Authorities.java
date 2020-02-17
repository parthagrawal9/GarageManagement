package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQueries;

@Entity
public class Authorities {
	
	@Id
	String username;
	String authority;
	
	public Authorities(){}
	
	public Authorities(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String role) {
		this.authority = role;
	}
	
}
