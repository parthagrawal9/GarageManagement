package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ServiceService {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Service> getallServices() {
		TypedQuery<Service> query = em.createNamedQuery(Service.FIND_ALL_SERVICES, Service.class);
		List<Service> results = query.getResultList();
		return results;
	}
	
	public Service getService(long id) {
		return em.find(Service.class, id);
	}

	@Transactional
	public void deleteService(long id) {
		em.remove(em.find(Service.class, id));
	}

	@Transactional
	public void addService(Service s) {
		em.persist(s);
	}

	@Transactional
	public void updateService(Service s) {
		em.merge(s);
	}
}
