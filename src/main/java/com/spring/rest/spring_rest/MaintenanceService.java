package com.spring.rest.spring_rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class MaintenanceService {

	@PersistenceContext
	EntityManager em;
	
	public List<Maintenance> getallMaintenance(){
		TypedQuery<Maintenance>query = em.createNamedQuery(Maintenance.FIND_ALL_MAINTENANCE,Maintenance.class);
		List<Maintenance> results = query.getResultList();
		return results;
	}
	
	public Maintenance getMaintenance(String id){
		return em.find(Maintenance.class, id);
	}
	
	@Transactional
	public void deleteMaintenance(String id) {
		em.remove(em.find(Maintenance.class, id));
	}

	@Transactional
	public void addMaintenance(Maintenance m) {
		em.persist(m);
	}
	
	@Transactional
	public void updateMaintenance(Maintenance m){
		em.merge(m);
	}
}
