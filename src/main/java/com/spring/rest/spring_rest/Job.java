package com.spring.rest.spring_rest;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Job.FIND_ALL_JOBS, query = "select j from Job j")
public class Job {
	
	protected static final String FIND_ALL_JOBS = "find_all_jobs"; 
	
	@Id
	private String jobId;
	private Date jobStartDate;
	private Date jobEndDate;
	private String carNo;
	private String carBrand;
	private String carModel;
	private String carFuelType;
	private float carKM;
	private String carChasisNo;
	private String carEngineNo;
	private int carFuel;
	private String customerName;
	private String customerPhone;
	private String customerEmail;
	private String customerAddress;
	private String jobDescription;
	private String status;
	private float bill;
	private String workerId;
	
	public Job(){
		
	}

	public Job(String jobId, Date jobStartDate, Date jobEndDate, String carNo, String carBrand, String carModel,
			String carFuelType, float carKM, String carChasisNo, String carEngineNo, int carFuel, String customerName,
			String customerPhone, String customerEmail, String customerAddress, String jobDescription, String status,
			float bill, String workerId) {
		super();
		this.jobId = jobId;
		this.jobStartDate = jobStartDate;
		this.jobEndDate = jobEndDate;
		this.carNo = carNo;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carFuelType = carFuelType;
		this.carKM = carKM;
		this.carChasisNo = carChasisNo;
		this.carEngineNo = carEngineNo;
		this.carFuel = carFuel;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.jobDescription = jobDescription;
		this.status = status;
		this.bill = bill;
		this.workerId = workerId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarFuelType() {
		return carFuelType;
	}

	public void setCarFuelType(String carFuelType) {
		this.carFuelType = carFuelType;
	}

	public float getCarKM() {
		return carKM;
	}

	public void setCarKM(float carKM) {
		this.carKM = carKM;
	}

	public String getCarChasisNo() {
		return carChasisNo;
	}

	public void setCarChasisNo(String carChasisNo) {
		this.carChasisNo = carChasisNo;
	}

	public String getCarEngineNo() {
		return carEngineNo;
	}

	public void setCarEngineNo(String carEngineNo) {
		this.carEngineNo = carEngineNo;
	}

	public int getCarFuel() {
		return carFuel;
	}

	public void setCarFuel(int carFuel) {
		this.carFuel = carFuel;
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

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobStatus() {
		return status;
	}

	public void setJobStatus(String jobStatus) {
		this.status = jobStatus;
	}

	public Date getJobStartDate() {
		return jobStartDate;
	}

	public void setJobStartDate(Date jobStartDate) {
		this.jobStartDate = jobStartDate;
	}

	public Date getJobEndDate() {
		return jobEndDate;
	}

	public void setJobEndDate(Date jobEndDate) {
		this.jobEndDate = jobEndDate;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}
	
	public String getWorkerId(){
		return workerId;
	}
	
	public void setWorkerId(String workerId){
		this.workerId = workerId;
	}
}
