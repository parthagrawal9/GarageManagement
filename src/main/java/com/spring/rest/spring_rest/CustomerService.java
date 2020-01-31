package com.spring.rest.spring_rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerService {
	@PersistenceContext
	EntityManager em;

	public List<Customer> getallCustomer() {
		TypedQuery<Customer> query = em.createNamedQuery(Customer.FIND_ALL_CUSTOMERS, Customer.class);
		List<Customer> results = query.getResultList();
		return results;
	}

	public Customer getCustomer(long id) {
		return em.find(Customer.class, id);
	}

	@Transactional
	public void deleteCustomer(long id) {
		em.remove(em.find(Customer.class, id));
	}

	@Transactional
	public void addCustomer(Customer c) {
		em.persist(c);
	}

	@Transactional
	public void updateCustomer(Customer c) {
		em.merge(c);
	}
}
