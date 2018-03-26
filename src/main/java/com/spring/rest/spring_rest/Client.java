package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Client.FIND_ALL_CLIENTS, query = "select c from Client c")
public class Client {
	
	protected static final String FIND_ALL_CLIENTS = "find_all_clients";
	
	@Id
	private String Cid;
	private String company_name;
	private String address;
	private String owner_name;
	
	public Client(String cid, String company_name, String address, String owner_name) {
		Cid = cid;
		this.company_name = company_name;
		this.address = address;
		this.owner_name = owner_name;
	}
	
	public Client(){};
	
	public String getCid() {
		return Cid;
	}

	public void setCid(String cid) {
		Cid = cid;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	
}
