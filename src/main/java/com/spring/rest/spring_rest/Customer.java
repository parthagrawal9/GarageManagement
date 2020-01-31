package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Customer.FIND_ALL_CUSTOMERS, query = "select c from Customer c")
public class Customer {
    
	protected static final String FIND_ALL_CUSTOMERS = "find_all_customers";   
	    
	@Id    
	@GeneratedValue
	private long cutomerId;     
	private String customerName;                                            
	private String customerPhone;
	private String customerAddressId;
	private long customerCarId;
	
	public Customer(){}

	public Customer(long cutomerId, String customerName, String customerPhone, String customerAddressId,
			long customerCarId) {
		super();
		this.cutomerId = cutomerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddressId = customerAddressId;
		this.customerCarId = customerCarId;
	}

	public long getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(long cutomerId) {
		this.cutomerId = cutomerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddressId() {
		return customerAddressId;
	}

	public void setCustomerAddressId(String customerAddressId) {
		this.customerAddressId = customerAddressId;
	}

	public long getCustomerCarId() {
		return customerCarId;
	}

	public void setCustomerCarId(long customerCarId) {
		this.customerCarId = customerCarId;
	}
}