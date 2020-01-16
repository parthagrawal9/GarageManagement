package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Address.FIND_ALL_ADDRESSES, query = "select a from Address a")
public class Address {
	
	protected static final String FIND_ALL_ADDRESSES = "find_all_addresses";

	@Id
	private String addressId;
	private String addressLine;
	private String addressCity;
	private String addressState;
	private String addressCountry;
	
	public Address(){}
	
	public Address(String addressId, String addressLine, String addressCity, String addressState,
			String addressCountry) {
		super();
		this.addressId = addressId;
		this.addressLine = addressLine;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
}
