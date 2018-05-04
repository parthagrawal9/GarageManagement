package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class InsuranceService {

	@PersistenceContext
	EntityManager em;
	
	public List<Insurance> getallInsurance(){
		TypedQuery<Insurance>query = em.createNamedQuery(Insurance.FIND_ALL_INSURANCE,Insurance.class);
		List<Insurance> results = query.getResultList();
		return results;
	}
	
	public Insurance getInsurance(String id){
		return em.find(Insurance.class, id);
	}
	
	@Transactional
	public void deleteInsurance(String id) {
		em.remove(em.find(Insurance.class, id));
	}

	@Transactional
	public void addInsurance(Insurance i) {
		em.persist(i);
	}
	
	@Transactional
	public void updateInsurance(Insurance i){
		em.merge(i);
	}
}
