package com.spring.rest.spring_rest;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Delivery.FIND_ALL_DELIVERY,query="select d from Delivery d")
public class Delivery {
	
	protected final static String FIND_ALL_DELIVERY = "find_all_delivery";
	
	@Id
	private String deliveryId;
	private String oId;
	private String fId;
	private String dId;
	private String status;
	private Date delivery_start_date;
	private Date delivery_end_date;
	
	public Delivery(){}
	
	public Delivery(String deliveryId, String oId, String fId, String dId, String status, Date delivery_start_date,
			Date delivery_end_date) {
		this.deliveryId = deliveryId;
		this.oId = oId;
		this.fId = fId;
		this.dId = dId;
		this.status = status;
		this.delivery_start_date = delivery_start_date;
		this.delivery_end_date = delivery_end_date;
	}
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDelivery_start_date() {
		return delivery_start_date;
	}
	public void setDelivery_start_date(Date delivery_start_date) {
		this.delivery_start_date = delivery_start_date;
	}
	public Date getDelivery_end_date() {
		return delivery_end_date;
	}
	public void setDelivery_end_date(Date delivery_end_date) {
		this.delivery_end_date = delivery_end_date;
	}
	
	
}
