package com.spring.rest.spring_rest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Orders.FIND_ALL_ORDERS,query="select o from Orders o")
public class Orders {

	protected static final String FIND_ALL_ORDERS = "find_all_orders";

	@Id
	private String Oid;
	private String Cid;
	private String client_plant_address;
	private Date Order_date;
	private float distance;
	
	public Orders(String oid, String cid, String client_plant_address, Date order_date, float distance) {
		Oid = oid;
		Cid = cid;
		this.client_plant_address = client_plant_address;
		Order_date = order_date;
		this.distance = distance;
	}
	
	public Orders(){}
	
	public String getOid() {
		return Oid;
	}
	public void setOid(String oid) {
		Oid = oid;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getClient_plant_address() {
		return client_plant_address;
	}
	public void setClient_plant_address(String client_plant_address) {
		this.client_plant_address = client_plant_address;
	}
	public Date getOrder_date() {
		return Order_date;
	}
	public void setOrder_date(Date order_date) {
		Order_date = order_date;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
}
