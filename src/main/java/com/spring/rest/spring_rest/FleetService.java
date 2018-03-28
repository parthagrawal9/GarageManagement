package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class FleetService {

	@PersistenceContext
	EntityManager em;

	public List<Fleet> getAllFleets() {
		TypedQuery<Fleet> query = em.createNamedQuery(Fleet.FIND_ALL_FLEETS, Fleet.class);
		List<Fleet> results = query.getResultList();
		return results;
	}

	public Fleet getFleet(String id) {
		return em.find(Fleet.class, id);
	}

	@Transactional
	public void deleteFleet(String id) {
		em.remove(em.find(Fleet.class, id));
	}

	@Transactional
	public void addFleet(Fleet c) {
		em.persist(c);
	}

	@Transactional
	public void updateFleet(Fleet f) {
		em.merge(f);
	}
}
