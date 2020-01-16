package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	String name;
	
	Role(){
		
	}
	
	Role(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
