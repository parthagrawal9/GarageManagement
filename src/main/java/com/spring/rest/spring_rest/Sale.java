package com.spring.rest.spring_rest;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = Sale.FIND_ALL_SALES, query = "select s from Sale s")
public class Sale {
	
	protected static final String FIND_ALL_SALES = "find_all_sales";
	
	@Id
	private String saleId;
	private String customerId;
	private Date saleDate;
	private float saleTotal;
	private float discount;
	private String jobId;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Inventory> inventory;
	
	public Sale(){}

	public Sale(String saleId, String customerId, Date saleDate, float saleTotal, float discount, String jobId,
			List<Inventory> inventory) {
		super();
		this.saleId = saleId;
		this.customerId = customerId;
		this.saleDate = saleDate;
		this.saleTotal = saleTotal;
		this.discount = discount;
		this.jobId = jobId;
		this.inventory = inventory;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public float getSaleTotal() {
		return saleTotal;
	}

	public void setSaleTotal(float saleTotal) {
		this.saleTotal = saleTotal;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}
	
	
}
