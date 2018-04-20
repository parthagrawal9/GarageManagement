package com.spring.rest.spring_rest;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = Fleet.FIND_ALL_FLEETS, query = "select f from Fleet f"),
	@NamedQuery(name = Fleet.FIND_TOTAL_FLEETS, query = "select COUNT(f) from Fleet f"),
	@NamedQuery(name = Fleet.FIND_TOTAL_FLEETS_PRICE, query = "select SUM(f.price) from Fleet f")
})
public class Fleet {
	
	protected static final String FIND_ALL_FLEETS = "find_all_fleets";
	protected static final String FIND_TOTAL_FLEETS = "find_total_fleets";
	protected static final String FIND_TOTAL_FLEETS_PRICE = "find_total_fleets_price";
	
	@Id
	private String fid;
	private String company;
	private int wheels;
	private String model_no;
	private String chasis_no;
	private Date date_of_purchase;
	private int price;
	
	public Fleet(){}
	
	public Fleet(String fleetId, String company, int wheels, String modelNo, String chasisNo, Date dateOfPurchase,
			int fleetPrice) {
		this.fid = fleetId;
		this.company = company;
		this.wheels = wheels;
		this.model_no = modelNo;
		this.chasis_no = chasisNo;
		this.date_of_purchase = dateOfPurchase;
		this.price = fleetPrice;
	}
	
	public String getFleetId() {
		return fid;
	}
	public void setFleetId(String fleetId) {
		this.fid = fleetId;
	}
	public String getComapny() {
		return company;
	}
	public void setComapny(String comapny) {
		this.company = comapny;
	}
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	public String getModelNo() {
		return model_no;
	}
	public void setModelNo(String modelNo) {
		this.model_no = modelNo;
	}
	public String getChasisNo() {
		return chasis_no;
	}
	public void setChasisNo(String chasisNo) {
		this.chasis_no = chasisNo;
	}
	public Date getDateOfPurchase() {
		return date_of_purchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.date_of_purchase = dateOfPurchase;
	}
	public int getFleetPrice() {
		return price;
	}
	public void setFleetPrice(int fleetPrice) {
		this.price = fleetPrice;
	}
}
