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
	EntityManager fleetEm;

	public List<Fleet> getAllFleets() {
		TypedQuery<Fleet> query = fleetEm.createNamedQuery(Fleet.FIND_ALL_FLEETS, Fleet.class);
		List<Fleet> results = query.getResultList();
		return results;
	}

	public Fleet getFleet(String id) {
		return fleetEm.find(Fleet.class, id);
	}

	@Transactional
	public void deleteFleet(String id) {
		fleetEm.remove(fleetEm.find(Fleet.class, id));
	}

	@Transactional
	public void addFleet(Fleet c) {
		fleetEm.persist(c);
	}

	@Transactional
	public void updateFleet(Fleet f) {
		fleetEm.merge(f);
	}
}
