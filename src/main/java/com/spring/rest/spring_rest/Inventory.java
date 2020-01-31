package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Inventory.FIND_ALL_INVENTORY, query = "select i from Inventory i")
public class Inventory {
	
	protected static final String FIND_ALL_INVENTORY = "find_all_inventory"; 
	
	@Id
	@GeneratedValue
	private long id;
	private String itemName;
	private String itemCompany;
	private String itemNumber;
	private String itemType;
	private String carBrand;
	private String carModel;
	private float itemPuchasePrice;
	private float itemSellingPrice;
	private int itemQty;
	private String rackNo;
	private String itemDesc;
	private long vendorId;
	
	public Inventory(){}

	public Inventory(long itemId, String itemName, String itemCompany, String itemNumber, String itemType,
			String carBrand, String carModel, float itemPuchasePrice, float itemSellingPrice, int itemQty,
			String rackNo, String itemDesc, long vendorId) {
		super();
		this.id = itemId;
		this.itemName = itemName;
		this.itemCompany = itemCompany;
		this.itemNumber = itemNumber;
		this.itemType = itemType;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.itemPuchasePrice = itemPuchasePrice;
		this.itemSellingPrice = itemSellingPrice;
		this.itemQty = itemQty;
		this.rackNo = rackNo;
		this.itemDesc = itemDesc;
		this.vendorId = vendorId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public float getItemPuchasePrice() {
		return itemPuchasePrice;
	}

	public void setItemPuchasePrice(float itemPuchasePrice) {
		this.itemPuchasePrice = itemPuchasePrice;
	}

	public float getItemSellingPrice() {
		return itemSellingPrice;
	}

	public void setItemSellingPrice(float itemSellingPrice) {
		this.itemSellingPrice = itemSellingPrice;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public String getRackNo() {
		return rackNo;
	}

	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	public long getvendorId() {
		return vendorId;
	}

	public void setvendorId(long vendorId) {
		this.vendorId = vendorId;
	}
	
}

//insert into inventory values(1,'Honda','All','Servo','Servo Oil for all Honda cars','Servo Oil','Servo123',300,3,450,'Lubricant','2A','1');
