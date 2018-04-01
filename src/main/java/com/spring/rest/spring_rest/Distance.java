package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Distance.FIND_ALL_DISTANCE, query = "select d from Distance d")
public class Distance {

	protected static final String FIND_ALL_DISTANCE = "find_all_distance";

	@Id
	private String City_id1;
	private String City_id2;
	int distance;

	public Distance() {
	}

	public Distance(String city_id1, String city_id2, int distance) {
		City_id1 = city_id1;
		City_id2 = city_id2;
		this.distance = distance;
	}

	public String getCity_id1() {
		return City_id1;
	}

	public void setCity_id1(String city_id1) {
		City_id1 = city_id1;
	}

	public String getCity_id2() {
		return City_id2;
	}

	public void setCity_id2(String city_id2) {
		City_id2 = city_id2;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
