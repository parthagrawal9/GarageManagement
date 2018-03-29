package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class RtoTaxService {

	@PersistenceContext
	EntityManager em;
	
	public List<Rto> getallRtoTax(){
		TypedQuery<Rto>query = em.createNamedQuery(Rto.FIND_ALL_RTO_TAXES,Rto.class);
		List<Rto> results = query.getResultList();
		return results;
	}
	
	public Rto getRtoTax(String id){
		return em.find(Rto.class, id);
	}
	
	@Transactional
	public void deleteRtoTax(String id) {
		em.remove(em.find(Rto.class, id));
	}

	@Transactional
	public void addRtoTax(Rto r) {
		em.persist(r);
	}
	
	@Transactional
	public void updateRtoTax(Rto r){
		em.merge(r);
	}
}
