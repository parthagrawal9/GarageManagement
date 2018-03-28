package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class DriverService {

	@PersistenceContext
	EntityManager em;
	
	public List<Driver> getallDrivers(){
		TypedQuery<Driver>query = em.createNamedQuery(Driver.FIND_ALL_DRIVERS,Driver.class);
		List<Driver> results = query.getResultList();
		return results;
	}
	
	public Driver getDriver(String id){
		return em.find(Driver.class, id);
	}
	
	@Transactional
	public void deleteDriver(String id) {
		em.remove(em.find(Driver.class, id));
	}

	@Transactional
	public void addDriver(Driver d) {
		em.persist(d);
	}
	
	@Transactional
	public void updateDriver(Driver d){
		em.merge(d);
	}
}
