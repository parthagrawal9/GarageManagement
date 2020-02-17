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
@NamedQuery(name = Bill.FIND_ALL_BILLS, query = "select b from Bill b")
public class Bill {
	
	protected static final String FIND_ALL_BILLS = "find_all_bills";
	
	@Id
	@GeneratedValue
	private long billId;
	private long saleId;
	private String customerName;
	private String customerPhone;
	private String customerEmail;
	private Date billDate;
	private float billTotal;
	private float discount;
	private long jobId;
	private String jobDescription;
	private float jobTotal;
	private Date jobStartDate;
	private Date jobEndDate;
	private String carNo;
	private String carBrand;
	private String carModel;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<BillLine> billLine;
	
	public Bill(){}
	
	public Bill(long billId, long saleId, String customerName, String customerPhone, String customerEmail,
			Date billDate, float billTotal, float discount, long jobId, String jobDescription, float jobTotal,
			Date jobStartDate, Date jobEndDate, String carNo, String carBrand, String carModel,
			List<BillLine> billLine) {
		super();
		this.billId = billId;
		this.saleId = saleId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.billDate = billDate;
		this.billTotal = billTotal;
		this.discount = discount;
		this.jobId = jobId;
		this.jobDescription = jobDescription;
		this.jobTotal = jobTotal;
		this.jobStartDate = jobStartDate;
		this.jobEndDate = jobEndDate;
		this.carNo = carNo;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.billLine = billLine;
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

	public long getSaleId() {
		return saleId;
	}
	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}
	public long getBillId() {
		return billId;
	}
	public void setBillId(long billId) {
		this.billId = billId;
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
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public float getBillTotal() {
		return billTotal;
	}
	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
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
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public float getJobTotal() {
		return jobTotal;
	}
	public void setJobTotal(float jobTotal) {
		this.jobTotal = jobTotal;
	}
	public List<BillLine> getBillLine() {
		return billLine;
	}
	public void setBillLine(List<BillLine> billLine) {
		this.billLine = billLine;
	}
	
	
}
