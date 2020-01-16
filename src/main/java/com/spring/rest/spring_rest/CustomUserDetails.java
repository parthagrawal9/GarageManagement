package com.spring.rest.spring_rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	@PersistenceContext
	private EntityManager em;
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
//		String hash = em.createQuery("SELECT user_password(l) FROM Login l WHERE l.user_name = '" +  this.getUsername());
//		Report r1 = new Report("Completed", n1);
//		status = "Pending";
//		int n2 = ((Number)em.createQuery("SELECT COUNT(d) FROM Delivery d WHERE d.status = '" + status + "'").getSingleResult()).intValue();
//		Report r2 = new Report("Pending", n2);
//		l.add(r1);l.add(r2);
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
