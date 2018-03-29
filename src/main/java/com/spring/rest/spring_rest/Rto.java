package com.spring.rest.spring_rest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Rto.FIND_ALL_RTO_TAXES, query="select r from Rto r")
public class Rto {

	protected static final String FIND_ALL_RTO_TAXES = "find_all_rto_taxes";
	
	@Id
	private String Rto_id;
	private String fId; 
	private Date tax_due_date;
	private float tax_amt;
	private Date previous_tax_date;
	
	
	public Rto(){}
	
	public Rto(String rto_id, String fId, Date tax_due_date, float taxe_amt, Date previous_tax_date) {
		Rto_id = rto_id;
		this.fId = fId;
		this.tax_due_date = tax_due_date;
		this.tax_amt = taxe_amt;
		this.previous_tax_date = previous_tax_date;
	}
	public String getRto_id() {
		return Rto_id;
	}
	public void setRto_id(String rto_id) {
		Rto_id = rto_id;
	}
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public Date getTax_due_date() {
		return tax_due_date;
	}
	public void setTax_due_date(Date tax_due_date) {
		this.tax_due_date = tax_due_date;
	}
	public float getTax_amt() {
		return tax_amt;
	}
	public void setTax_amt(float taxe_amt) {
		this.tax_amt = taxe_amt;
	}
	public Date getPrevious_tax_date() {
		return previous_tax_date;
	}
	public void setPrevious_tax_date(Date previous_tax_date) {
		this.previous_tax_date = previous_tax_date;
	}
	
	
}
