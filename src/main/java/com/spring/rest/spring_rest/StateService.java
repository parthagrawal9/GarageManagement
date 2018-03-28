package com.spring.rest.spring_rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class StateService {

	@PersistenceContext
	EntityManager em;
	
	public List<State> getallStates(){
		TypedQuery<State>query = em.createNamedQuery(State.FIND_ALL_STATES,State.class);
		List<State> results = query.getResultList();
		return results;
	}
	
	public State getState(String id) {
		return em.find(State.class, id);
	}

	@Transactional
	public void deleteState(String id) {
		em.remove(em.find(State.class, id));
	}
	
	@Transactional
	public void addState(State s) {
		em.persist(s);
	}
	
	@Transactional
	public void updateState(State s){
		em.merge(s);
	}
}
