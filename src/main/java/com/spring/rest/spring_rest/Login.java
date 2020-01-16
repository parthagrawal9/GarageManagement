package com.spring.rest.spring_rest;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = Login.FIND_ALL_LOGINS, query = "select l from Login l")
public class Login {
	
	protected static final String FIND_ALL_LOGINS = "find_all_logins";
	
	@Id
	@GeneratedValue
	private Long userId;
	private String userName;
	private String userPassword;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Role> userRoles;
	
	public Login(){};

	public Login(String userName, String userPassword, List<Role> userRoles) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRoles = userRoles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}
	
}
