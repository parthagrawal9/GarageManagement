package com.spring.rest.spring_rest;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class JobService {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Job> getallJob() {
		TypedQuery<Job> query = em.createNamedQuery(Job.FIND_ALL_JOBS, Job.class);
		List<Job> results = query.getResultList();
		return results;
	}

	public int getCompletedPendingCount(String status) {
		return ((Number) em.createQuery("SELECT COUNT(j) FROM Job d WHERE j.status = '" + status + "'")
				.getSingleResult()).intValue();
	}
	
	public ArrayList<StatReport> getCompletedPendingCount() {
		ArrayList<StatReport> l = new ArrayList<StatReport>();
		String status = "Completed";
		int n1 = ((Number)em.createQuery("SELECT COUNT(j) FROM Job d WHERE j.status = '" + status + "'").getSingleResult()).intValue();
		StatReport r1 = new StatReport("Completed", n1);
		status = "Pending";
		int n2 = ((Number)em.createQuery("SELECT COUNT(j) FROM Job d WHERE j.status = '" + status + "'").getSingleResult()).intValue();
		StatReport r2 = new StatReport("Pending", n2);
		l.add(r1);l.add(r2);
		return l;
	}
	

	public Job getJob(String id) {
		return em.find(Job.class, id);
	}

	@Transactional
	public void deleteJob(String id) {
		em.remove(em.find(Job.class, id));
	}

	@Transactional
	public void addJob(Job j) {
		em.persist(j);
	}

	@Transactional
	public void updateJob(Job j) {
		em.merge(j);
	}
}
