package com.spring.rest.spring_rest;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Maintenance.FIND_ALL_MAINTENANCE,query="select m from Maintenance m")
public class Maintenance {

	protected static final String FIND_ALL_MAINTENANCE = "find_all_maintenance";
	
	@Id
	private String mId;
	private String fId;
	private String mType;
	private float mExpense;
	private Date maintenanceDate;
	
	public Maintenance(){}
	
	public Maintenance(String mId, String fId, String mType, float mExpense, Date maintenanceDate) {
		this.mId = mId;
		this.fId = fId;
		this.mType = mType;
		this.mExpense = mExpense;
		this.maintenanceDate = maintenanceDate;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public float getmExpense() {
		return mExpense;
	}
	public void setmExpense(float mExpense) {
		this.mExpense = mExpense;
	}
	public Date getMaintenanceDate() {
		return maintenanceDate;
	}
	public void setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}
}
