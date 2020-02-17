package com.spring.rest.spring_rest;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class RoleService {
	@PersistenceContext
	EntityManager em;
	
	public List<Authorities> getUserRoles(String username) {
		
		List<Authorities> l = em.createQuery("SELECT a FROM Authorities a WHERE a.username = '" + username + "'").getResultList();
		
		return l;
	}
	
}
