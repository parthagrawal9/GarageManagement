package com.spring.rest.spring_rest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Driver.FIND_ALL_DRIVERS,query="select d from Driver d")
public class Driver {

	protected static final String FIND_ALL_DRIVERS = "find_all_drivers";
	
	@Id
	private String Did;
	private String Dname;
	private Date joining_date;
	private String id_proof;
	private byte[] photo; 
	private String address;
	private long mobile_no;
	private String license_no;
	private int salary;
	
	public Driver(){}
	
	public Driver(String did, String dname, Date joining_date, String id_proof, byte[] photo, String address,
			long mobile_no, String license_no, int salary) {
		Did = did;
		Dname = dname;
		this.joining_date = joining_date;
		this.id_proof = id_proof;
		this.photo = photo;
		this.address = address;
		this.mobile_no = mobile_no;
		this.license_no = license_no;
		this.salary = salary;
	}
	
	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public Date getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}
	public String getId_proof() {
		return id_proof;
	}
	public void setId_proof(String id_proof) {
		this.id_proof = id_proof;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getLicense_no() {
		return license_no;
	}
	public void setLicense_no(String license_no) {
		this.license_no = license_no;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public static String getFindAllDrivers() {
		return FIND_ALL_DRIVERS;
	}
}
