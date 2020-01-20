package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class VendorService {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Vendor> getallVendor() {
		TypedQuery<Vendor> query = em.createNamedQuery(Vendor.FIND_ALL_VENDORS, Vendor.class);
		List<Vendor> results = query.getResultList();
		return results;
	}

	public Vendor getVendor(String id) {
		return em.find(Vendor.class, id);
	}

	@Transactional
	public void deleteVendor(String id) {
		em.remove(em.find(Vendor.class, id));
	}

	@Transactional
	public void addVendor(Vendor v) {
		em.persist(v);
	}

	@Transactional
	public void updateVendor(Vendor v) {
		em.merge(v);
	}

}
