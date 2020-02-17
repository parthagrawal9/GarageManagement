package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BillLine {
	
	@Id
	@GeneratedValue
	private long billLineId;
	private int qty;	
	private String inventoryName;
	private long inventoryId;
	private float itemSellingPrice;
	private String itemCompany;
	private String itemNumber;
	
	public BillLine(){}
	
	public BillLine(long billLineId, int qty, String inventoryName, long inventoryId, float itemSellingPrice,
			String itemCompany, String itemNumber) {
		super();
		this.billLineId = billLineId;
		this.qty = qty;
		this.inventoryName = inventoryName;
		this.inventoryId = inventoryId;
		this.itemSellingPrice = itemSellingPrice;
		this.itemCompany = itemCompany;
		this.itemNumber = itemNumber;
	}
	public long getBillLineId() {
		return billLineId;
	}
	public void setBillLineId(long billLineId) {
		this.billLineId = billLineId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public float getItemSellingPrice() {
		return itemSellingPrice;
	}
	public void setItemSellingPrice(float itemSellingPrice) {
		this.itemSellingPrice = itemSellingPrice;
	}
	public String getItemCompany() {
		return itemCompany;
	}
	public void setItemCompany(String itemCompany) {
		this.itemCompany = itemCompany;
	}
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
}
