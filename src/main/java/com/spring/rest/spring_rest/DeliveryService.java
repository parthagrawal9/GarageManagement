package com.spring.rest.spring_rest;

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
