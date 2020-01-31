package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Vendor.FIND_ALL_VENDORS, query = "select v from Vendor v")
public class Vendor {
	
	protected static final String FIND_ALL_VENDORS = "find_all_vendors"; 
	
	@Id
	@GeneratedValue
	private long vendorId;
	private String vendorName;
	private String vendorPhone;
	private String vendorEmail;
	private String vendorAddress;
	private String vendorDescription;
	
	public Vendor(){}
	
	public Vendor(long vendorId, String vendorName, String vendorPhone, String vendorEmail, String vendorAddress,
			String vendorDescription) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorPhone = vendorPhone;
		this.vendorEmail = vendorEmail;
		this.vendorAddress = vendorAddress;
		this.vendorDescription = vendorDescription;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorDescription() {
		return vendorDescription;
	}

	public void setVendorDescription(String vendorDescription) {
		this.vendorDescription = vendorDescription;
	}
}
//insert into vendor values(1,'Bengaluru','Oil Dealer','vendor1@gmail.com','Car Oil Dealers','8987657895');