package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = City.FIND_ALL_CITIES, query = "select c from City c")
public class City {

	protected static final String FIND_ALL_CITIES = "find_all_cities";

	@Id
	private String city_id;
	private String city_name;
	private String state_id;

	public City() {
	}

	public City(String city_id, String city_name, String state_id) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.state_id = state_id;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
}
