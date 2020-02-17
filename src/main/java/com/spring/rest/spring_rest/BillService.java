package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class BillService {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Bill> getallBills() {
		TypedQuery<Bill> query = em.createNamedQuery(Bill.FIND_ALL_BILLS, Bill.class);
		List<Bill> results = query.getResultList();
		return results;
	}
	
	public Bill getBillBySaleId(long id) {
		List<Bill> results = em.createQuery("select b from Bill b where b.saleId ="+id).getResultList();
		return results.get(0);
	}
	
	public Bill getBill(long id) {
		return em.find(Bill.class, id);
	}

	@Transactional
	public void deleteBill(long id) {
		em.remove(em.find(Bill.class, id));
	}

	@Transactional
	public void addBill(Bill b) {
		em.persist(b);
	}

	@Transactional
	public void updateBill(Bill b) {
		em.merge(b);
	}
}
