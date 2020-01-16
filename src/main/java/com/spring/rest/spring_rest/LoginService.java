package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class LoginService {

	@PersistenceContext
	EntityManager em;
	
	public List<Login> getallLogins(){
		TypedQuery<Login>query = em.createNamedQuery(Login.FIND_ALL_LOGINS,Login.class);
		List<Login> results = query.getResultList();
		return results;
	}
	
	public Login getLogin(String username){
		return em.find(Login.class, username);
	}
	
	@Transactional
	public void deleteLogin(String username) {
		em.remove(em.find(Login.class, username));
	}

	@Transactional
	public void addLogin(Login l) {
		em.persist(l);
	}
	
	@Transactional
	public void updateLogin(Login l){
		em.merge(l);
	}
}
