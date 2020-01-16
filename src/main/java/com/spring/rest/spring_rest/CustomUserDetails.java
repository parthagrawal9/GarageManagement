package com.spring.rest.spring_rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.codec.digest.Sha2Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private LoginService loginService;
	private String userName;
	private String userPassword;
	Collection<? extends GrantedAuthority> authorities; 
	
	public CustomUserDetails(Login byUsername) {
		this.userName = byUsername.getUserName();
		this.userPassword = byUsername.getUserPassword();
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for(Role role : byUsername.getUserRoles()){
			auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		}
		this.authorities = auths;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
//		if(this.getUsername().equals("user")){
//			return userPassword;
//		}
//		loginService = new LoginService();
//		Login user = loginService.getLogin(userName);
//		String userHash = user.getUserPassword();
//		
//		MD5 md = new MD5();
//		String newHash = md.getMd5(userPassword);
//		
//		if(newHash.equals(userHash)){
//			return userHash;
//		}
//		else{
//			return "";
//		}
		return userPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
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
		return true;
	}

}
