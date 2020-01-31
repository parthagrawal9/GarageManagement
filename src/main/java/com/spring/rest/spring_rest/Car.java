package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Car.FIND_ALL_CARS, query = "select c from Car c")
public class Car {

	protected static final String FIND_ALL_CARS = "find_all_cars";
	
	@Id
	@GeneratedValue
	private long carId;
	private String carModel;
	private String carBrand;
	private String carNumber;
	private String carKMs;
	private String carChasisNo;
	private String carEngineNo;
	
	public Car(){}

	public Car(long carId, String carModel, String carBrand, String carNumber, String carKMs, String carChasisNo,
			String carEngineNo) {
		super();
		this.carId = carId;
		this.carModel = carModel;
		this.carBrand = carBrand;
		this.carNumber = carNumber;
		this.carKMs = carKMs;
		this.carChasisNo = carChasisNo;
		this.carEngineNo = carEngineNo;
	}



	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
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



	public String getCarNumber() {
		return carNumber;
	}



	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}



	public String getCarKMs() {
		return carKMs;
	}



	public void setCarKMs(String carKMs) {
		this.carKMs = carKMs;
	}



	public String getCarChasisNo() {
		return carChasisNo;
	}



	public void setCarChasisNo(String carChasisNo) {
		this.carChasisNo = carChasisNo;
	}



	public String getCarEngineNo() {
		return carEngineNo;
	}



	public void setCarEngineNo(String carEngineNo) {
		this.carEngineNo = carEngineNo;
	}
	
	
	
	
}
