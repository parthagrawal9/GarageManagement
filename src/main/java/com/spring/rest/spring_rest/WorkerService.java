package com.spring.rest.spring_rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class WorkerService {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Worker> getallWorkers() {
		TypedQuery<Worker> query = em.createNamedQuery(Worker.FIND_ALL_WORKERS, Worker.class);
		List<Worker> results = query.getResultList();
		return results;
	}
	
	public Worker getWorker(String id) {
		return em.find(Worker.class, id);
	}

	@Transactional
	public void deleteWorker(String id) {
		em.remove(em.find(Worker.class, id));
	}

	@Transactional
	public void addWorker(Worker w) {
		em.persist(w);
	}

	@Transactional
	public void updateWorker(Worker w) {
		em.merge(w);
	}
}
