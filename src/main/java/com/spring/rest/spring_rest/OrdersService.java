package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersService {

	@PersistenceContext
	EntityManager em;
	
	public List<Orders> getallOrders(){
		TypedQuery<Orders>query = em.createNamedQuery(Orders.FIND_ALL_ORDERS,Orders.class);
		List<Orders> results = query.getResultList();
		return results;
	}
	
	public Orders getOrder(String id){
		return em.find(Orders.class, id);
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
	public void updateOrder(Orders o){
		em.merge(o);
	}
}
