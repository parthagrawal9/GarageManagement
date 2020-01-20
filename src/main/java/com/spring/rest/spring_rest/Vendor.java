package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Vendor.FIND_ALL_VENDORS, query = "select v from Vendor v")
public class Vendor {
	
	protected static final String FIND_ALL_VENDORS = "find_all_vendors"; 
	
	@Id
	private String vendorId;
	private String vendorName;
	private String vendorPhone;
	private String vendorEmail;
	private String vendorAddress;
	private String vendorDescription;
	
	public Vendor(){}
	
	public Vendor(String vendorId, String vendorName, String vendorPhone, String vendorEmail, String vendorAddress,
			String vendorDescription) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorPhone = vendorPhone;
		this.vendorEmail = vendorEmail;
		this.vendorAddress = vendorAddress;
		this.vendorDescription = vendorDescription;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
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
