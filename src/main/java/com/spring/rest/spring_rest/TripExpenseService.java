package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class TripExpenseService {

	@PersistenceContext
	EntityManager em;

	public List<TripExpense> getallTripExpense() {
		TypedQuery<TripExpense> query = em.createNamedQuery(TripExpense.FIND_ALL_TRIP_EXPENSE, TripExpense.class);
		List<TripExpense> results = query.getResultList();
		return results;
	}
	public TripExpense getTripExpenseByDeliveryId(String deliveryId){
		Query query = em.createQuery("select t from TripExpense t where t.deliveryId='"+deliveryId+"'");
		return (TripExpense)em.createQuery("select t from TripExpense t where t.deliveryId='"+deliveryId+"'").getSingleResult();
	}
	
	public TripExpense getTripExpense(String id) {
		return em.find(TripExpense.class, id);
	}

	@Transactional
	public void deleteTripExpense(String id) {
		em.remove(em.find(TripExpense.class, id));
	}

	@Transactional
	public void addTripExpense(TripExpense d) {
		em.persist(d);
	}

	@Transactional
	public void updateTripExpense(TripExpense d) {
		em.merge(d);
	}
}
