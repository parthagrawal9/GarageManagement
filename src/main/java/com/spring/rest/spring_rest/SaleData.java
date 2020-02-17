package com.spring.rest.spring_rest;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SaleData {
	@Id
	@GeneratedValue
	private Long id;
	private int qty;	
	private long inventoryId;
	
	public SaleData(){};
	
	public SaleData(Long id, int qty, long inventory) {
		super();
		this.id = id;
		this.qty = qty;
		this.inventoryId = inventory;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(long inventory) {
		this.inventoryId = inventory;
	}
}
