package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Car.FIND_ALL_CARS, query = "select c from Car c")
public class Car {

	protected static final String FIND_ALL_CARS = "find_all_cars";
	
	@Id
	private String carId;
	private String carModel;
	private String carBrand;
	
	public Car(){}
	
	public Car(String carId, String carModel, String carBrand) {
		super();
		this.carId = carId;
		this.carModel = carModel;
		this.carBrand = carBrand;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	
}
