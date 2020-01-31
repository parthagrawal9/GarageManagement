package com.spring.rest.spring_rest;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.NamedQueries;

@Entity
@NamedQueries({
	@org.hibernate.annotations.NamedQuery(name = Job.FIND_ALL_JOBS, query = "select j from Job j"),
	@org.hibernate.annotations.NamedQuery(name = Job.FIND_ALL_COMPLETED_JOBS, query = "select j from Job j WHERE j.status='Completed'"),
	@org.hibernate.annotations.NamedQuery(name = Job.FIND_ALL_PENDING_JOBS, query = "select j from Job j WHERE j.status='Pending'")
})
public class Job {
	
	protected static final String FIND_ALL_JOBS = "find_all_jobs";
	protected static final String FIND_ALL_COMPLETED_JOBS = "find_all_completed_jobs";
	protected static final String FIND_ALL_PENDING_JOBS = "find_all_pending_jobs";
	
	@Id
	@GeneratedValue
	private long jobId;
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
	private long workerId;
	
	public Job(){
		
	}

	public Job(long jobId, Date jobStartDate, Date jobEndDate, String carNo, String carBrand, String carModel,
			String carFuelType, float carKM, String carChasisNo, String carEngineNo, int carFuel, String customerName,
			String customerPhone, String customerEmail, String customerAddress, String jobDescription, String status,
			float bill, long workerId) {
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

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
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
	
	public long getWorkerId(){
		return workerId;
	}
	
	public void setWorkerId(long workerId){
		this.workerId = workerId;
	}
}

//insert into job values (1,2000,'Honda','Chasis_1','Engine_1',20,'Petrol',50000,'Civic','KA 01 AA 1234', 'Taverekere Main Road','customer1@gmail.com','Customer 1','9999998888','This is temp job','2019-10-10','2019-11-10','Pending',20);
