package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class InventoryService {
	@PersistenceContext
	EntityManager em;
	
	public List<Inventory> getallInventory() {
		TypedQuery<Inventory> query = em.createNamedQuery(Inventory.FIND_ALL_INVENTORY, Inventory.class);
		List<Inventory> results = query.getResultList();
		return results;
	}
	

	public Inventory getInventory(String id) {
		return em.find(Inventory.class, id);
	}

	@Transactional
	public void deleteInventory(String id) {
		em.remove(em.find(Inventory.class, id));
	}

	@Transactional
	public void addInventory(Inventory i) {
		em.persist(i);
	}

	@Transactional
	public void updateInventory(Inventory i) {
		em.merge(i);
	}
}
