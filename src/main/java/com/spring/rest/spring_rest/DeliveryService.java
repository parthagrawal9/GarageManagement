package com.spring.rest.spring_rest;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryService {

	@PersistenceContext
	EntityManager em;

	public List<Delivery> getallDelivery() {
		TypedQuery<Delivery> query = em.createNamedQuery(Delivery.FIND_ALL_DELIVERY, Delivery.class);
		List<Delivery> results = query.getResultList();
		return results;
	}

	public int getCompletedPendingCount(String status) {
		return ((Number) em.createQuery("SELECT COUNT(d) FROM Delivery d WHERE d.status = '" + status + "'")
				.getSingleResult()).intValue();
	}
	
	public ArrayList<Report> getCompletedPendingCount() {
		ArrayList<Report> l = new ArrayList<Report>();
		String status = "Completed";
		int n1 = ((Number)em.createQuery("SELECT COUNT(d) FROM Delivery d WHERE d.status = '" +  status+ "'").getSingleResult()).intValue();
		Report r1 = new Report("Completed", n1);
		status = "Pending";
		int n2 = ((Number)em.createQuery("SELECT COUNT(d) FROM Delivery d WHERE d.status = '" + status + "'").getSingleResult()).intValue();
		Report r2 = new Report("Pending", n2);
		l.add(r1);l.add(r2);
		return l;
	}
	

	public Delivery getDelivery(String id) {
		return em.find(Delivery.class, id);
	}

	@Transactional
	public void deleteDelivery(String id) {
		em.remove(em.find(Delivery.class, id));
	}

	@Transactional
	public void addDelivery(Delivery d) {
		em.persist(d);
	}

	@Transactional
	public void updateDelivery(Delivery d) {
		em.merge(d);
	}
}
