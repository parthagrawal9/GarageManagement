package com.spring.rest.spring_rest;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersService {

	@PersistenceContext
	EntityManager em;

	public List<Orders> getallOrders() {
		TypedQuery<Orders> query = em.createNamedQuery(Orders.FIND_ALL_ORDERS, Orders.class);
		List<Orders> results = query.getResultList();
		return results;
	}

	public Orders getOrder(String id) {
		return em.find(Orders.class, id);
	}

	public int getTotalDistanceCompleted() {
		return ((Number) em
				.createQuery(
						"SELECT SUM(o.distance) from Orders o WHERE o.Oid in (SELECT d.oId from Delivery d where d.status='Completed')")
				.getSingleResult()).intValue();
	}

	public List<Orders> getOrdersPerMonth(Date d1, Date d2) {
		System.out.println(d1 + "Date : " + d2);
		Query query = em.createQuery("select o from Orders o where o.Order_date BETWEEN '" + d1 + "' AND '" + d2 + "'");
		@SuppressWarnings("unchecked")
		List<Orders> results = query.getResultList();
		return results;
	}
	
	public List<Orders> getOrdersPerClient(String cid) {
		Query query = em.createQuery("select o from Orders o where o.Cid = '"+cid+"'");
		@SuppressWarnings("unchecked")
		List<Orders> results = query.getResultList();
		return results;
	}
	
	public List<Orders> getOrdersPerFleet(String fid) {
		Query query = em.createQuery("select o from Orders o where o.Oid in (SELECT d.oId from Delivery d WHERE d.fId='"+fid+"')");
		@SuppressWarnings("unchecked")
		List<Orders> results = query.getResultList();
		return results;
	}
	
	public List<Orders> getOrdersCompletedPending(String status) {
		Query query = em.createQuery("select o from Orders o where o.Oid in (SELECT d.oId from Delivery d WHERE d.status='"+status+"')");
		@SuppressWarnings("unchecked")
		List<Orders> results = query.getResultList();
		return results;
	}

	@Transactional
	public void deleteOrder(String id) {
		em.remove(em.find(Orders.class, id));
	}

	@Transactional
	public void addOrder(Orders o) {
		em.persist(o);
	}

	@Transactional
	public void updateOrder(Orders o) {
		em.merge(o);
	}
}
