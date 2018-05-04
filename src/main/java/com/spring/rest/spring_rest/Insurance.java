package com.spring.rest.spring_rest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/*
 * create table Insurance (
	Iid VARCHAR(5) primary key,
	Fid VARCHAR(5) references Fleet(Fid),
	insurance_due_date date,
	insurance_amt int
	previous_insurance_date date
)
 */
@Entity
@NamedQuery(name=Insurance.FIND_ALL_INSURANCE,query="select i from Insurance i")
public class Insurance {
	
	protected static final String FIND_ALL_INSURANCE= "find_all_insurance";
	
	@Id
	private String insuranceId;
	private String fleetId;
	private Date insuranceDueDate;
	private Date previousInsuranceDate;
	private int insuranceAmount;
	
	public Insurance(String insuranceId, String fleetId, Date insuranceDueDate, Date previousInsuranceDate,
			int insuranceAmount) {
		this.insuranceId = insuranceId;
		this.fleetId = fleetId;
		this.insuranceDueDate = insuranceDueDate;
		this.previousInsuranceDate = previousInsuranceDate;
		this.insuranceAmount = insuranceAmount;
	}

	public Insurance(){}
	
	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getFleetId() {
		return fleetId;
	}
	public void setFleetId(String fleetId) {
		this.fleetId = fleetId;
	}
	public Date getInsuranceDueDate() {
		return insuranceDueDate;
	}
	public void setInsuranceDueDate(Date insuranceDueDate) {
		this.insuranceDueDate = insuranceDueDate;
	}
	public Date getPreviousInsuranceDate() {
		return previousInsuranceDate;
	}
	public void setPreviousInsuranceDate(Date previousInsuranceDate) {
		this.previousInsuranceDate = previousInsuranceDate;
	}

	public int getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(int insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
}
