package com.spring.rest.spring_rest;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = Sale.FIND_ALL_SALES, query = "select s from Sale s")
public class Sale {
	
	protected static final String FIND_ALL_SALES = "find_all_sales";
	
	@Id
	@GeneratedValue
	private long saleId;
	private String customerName;
	private String customerPhone;
	private String customerEmail;
	private Date saleDate;
	private float saleTotal;
	private float discount;
	private long jobId;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<SaleData> saleData;
	
	public Sale(){}
	
	public Sale(long saleId, String customerName, String customerPhone, String customerEmail, Date saleDate,
			float saleTotal, float discount, long jobId, List<SaleData> saleData) {
		super();
		this.saleId = saleId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.saleDate = saleDate;
		this.saleTotal = saleTotal;
		this.discount = discount;
		this.jobId = jobId;
		this.saleData = saleData;
	}


	public long getSaleId() {
		return saleId;
	}

	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}

	public String getcustomerName() {
		return customerName;
	}

	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public float getSaleTotal() {
		return saleTotal;
	}

	public void setSaleTotal(float saleTotal) {
		this.saleTotal = saleTotal;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public List<SaleData> getSaleData() {
		return saleData;
	}

	public void setSaleData(List<SaleData> saleData) {
		this.saleData = saleData;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
}
//insert into sale values(1,'guru@gmail.com','Guru Iyer','8888812345',0,1,'2020-1-28',2600);insert into sale_data values(1,1,2);insert into sale_sale_data values(1,1);
