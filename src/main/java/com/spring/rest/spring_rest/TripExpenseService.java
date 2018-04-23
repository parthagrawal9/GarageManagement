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

//	public int getTotalofParticularTripExpense(String id) {
//		Query query = em.createQuery("select t.CashExp,t.borderCharges,t.dailyAllowanceExp,t.dieselExp,t.driverExp,t.miscExp,t.repairExp,t.tollExp from TripExpense t where t.tripExpId='"+id+"'");
//		TripExpense expense = (TripExpense)query.getSingleResult();
//		int sumOfExpense = 0;
//		sumOfExpense += expense.getBorderCharges();
//		sumOfExpense += expense.getCashExp();
//		sumOfExpense += expense.getDailyAllowanceExp();
//		sumOfExpense += expense.getDieselExp();
//		sumOfExpense += expense.getDriverExp();
//		sumOfExpense += expense.getMiscExp();
//		sumOfExpense += expense.getRepairExp();
//		sumOfExpense += expense.getTollExp();
//		return sumOfExpense;
//	}
//	
//	public TripExpense getParticularTripExpenseDetails(String id) {
//		Query query = em.createQuery("select t.CashExp,t.borderCharges,t.dailyAllowanceExp,t.dieselExp,t.driverExp,t.miscExp,t.repairExp,t.tollExp from TripExpense t where t.tripExpId='"+id+"'");
//		TripExpense expense = (TripExpense)query.getSingleResult();
//		return expense;
//	}
	
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
