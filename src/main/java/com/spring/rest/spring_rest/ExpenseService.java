package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ExpenseService {

	@PersistenceContext
	EntityManager em;
	
	public List<Expense> getallExpenses() {
		TypedQuery<Expense> query = em.createNamedQuery(Expense.FIND_ALL_EXPENSES, Expense.class);
		List<Expense> results = query.getResultList();
		return results;
	}
	

	public Expense getExpense(long id) {
		return em.find(Expense.class, id);
	}

	@Transactional
	public void deleteExpense(long id) {
		em.remove(em.find(Expense.class, id));
	}

	@Transactional
	public void addExpense(Expense i) {
		em.persist(i);
	}

	@Transactional
	public void updateExpense(Expense i) {
		em.merge(i);
	}
}
