package com.spring.rest.spring_rest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CityService {

	@PersistenceContext
	EntityManager em;
	
	public List<City> getallCities(){
		TypedQuery<City>query = em.createNamedQuery(City.FIND_ALL_CITIES,City.class);
		List<City> results = query.getResultList();
		return results;
	}
	
	public City getCity(String id){
		return em.find(City.class, id);
	}
	
	@Transactional
	public void deleteCity(String id) {
		em.remove(em.find(City.class, id));
	}

	@Transactional
	public void addCity(City c) {
		em.persist(c);
	}
	
	@Transactional
	public void updateCity(City c){
		em.merge(c);
	}
}
