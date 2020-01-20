package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class SaleService {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Sale> getallSales() {
		TypedQuery<Sale> query = em.createNamedQuery(Sale.FIND_ALL_SALES, Sale.class);
		List<Sale> results = query.getResultList();
		return results;
	}
	
	public Sale getSale(String id) {
		return em.find(Sale.class, id);
	}

	@Transactional
	public void deleteSale(String id) {
		em.remove(em.find(Sale.class, id));
	}

	@Transactional
	public void addSale(Sale s) {
		em.persist(s);
	}

	@Transactional
	public void updateSale(Sale s) {
		em.merge(s);
	}
}
