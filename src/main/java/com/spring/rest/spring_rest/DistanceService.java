package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class DistanceService {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Distance> getallDistance(){
		TypedQuery<Distance>query = em.createNamedQuery(Distance.FIND_ALL_DISTANCE,Distance.class);
		List<Distance> results = query.getResultList();
		return results;
	}
	
	public Distance getDistance(String id){
		return em.find(Distance.class, id);
	}
	
	@Transactional
	public void deleteDistance(String id) {
		em.remove(em.find(Distance.class, id));
	}

	@Transactional
	public void addDistance(Distance c) {
		em.persist(c);
	}
	
	@Transactional
	public void updateD(Distance c){
		em.merge(c);
	}
}
