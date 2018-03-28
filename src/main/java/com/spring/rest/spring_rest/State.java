package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=State.FIND_ALL_STATES,query="select s from State s")
public class State {
	
	protected static final String FIND_ALL_STATES = "find_all_states";
	
	@Id
	private String state_id;
	private String state_name;
	
	public State(){};
	
	public State(String state_id, String state_name) {
		this.state_id = state_id;
		this.state_name = state_name;
	}
	public String getState_id() {
		return state_id;
	}
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
}
