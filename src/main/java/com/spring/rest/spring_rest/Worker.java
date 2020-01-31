package com.spring.rest.spring_rest;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Worker.FIND_ALL_WORKERS, query = "select w from Worker w")
public class Worker {
	
	protected static final String FIND_ALL_WORKERS = "find_all_workers"; 
	
	@Id
	@GeneratedValue
	private long workerId;
	private String workerName;
	private String workerPhone;
	private String workerEmail;
	private double workerSalary;
	private Date workerJoiningDate;
	
	public Worker(){}
	
	public Worker(long workerId, String workerName, String workerPhone, String workerEmail, double workerSalary,
			Date workerJoiningDate) {
		super();
		this.workerId = workerId;
		this.workerName = workerName;
		this.workerPhone = workerPhone;
		this.workerEmail = workerEmail;
		this.workerSalary = workerSalary;
		this.workerJoiningDate = workerJoiningDate;
	}

	public long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerPhone() {
		return workerPhone;
	}

	public void setWorkerPhone(String workerPhone) {
		this.workerPhone = workerPhone;
	}

	public String getWorkerEmail() {
		return workerEmail;
	}

	public void setWorkerEmail(String workerEmail) {
		this.workerEmail = workerEmail;
	}

	public double getWorkerSalary() {
		return workerSalary;
	}

	public void setWorkerSalary(double workerSalary) {
		this.workerSalary = workerSalary;
	}

	public Date getWorkerJoiningDate() {
		return workerJoiningDate;
	}

	public void setWorkerJoiningDate(Date workerJoiningDate) {
		this.workerJoiningDate = workerJoiningDate;
	}
	
	
	
}
