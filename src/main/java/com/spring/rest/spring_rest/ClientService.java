package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ClientService {

	@PersistenceContext
	EntityManager em;
	
	public List<Client> getallClients(){
		TypedQuery<Client>query = em.createNamedQuery(Client.FIND_ALL_CLIENTS,Client.class);
		List<Client> results = query.getResultList();
		return results;
	}
	
	public Client getClient(String id){
		return em.find(Client.class, id);
	}
	
	@Transactional
	public void deleteClient(int id) {
		em.remove(em.find(Client.class, id));
	}

	@Transactional
	public void addClient(Client c) {
		em.persist(c);
	}
}
