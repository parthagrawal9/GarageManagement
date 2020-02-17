package com.spring.rest.spring_rest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class UsersService {
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void addUsers(Users u) {
		em.persist(u);
	}

}
