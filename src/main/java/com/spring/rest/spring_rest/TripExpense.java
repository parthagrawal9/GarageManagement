package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=TripExpense.FIND_ALL_TRIP_EXPENSE,query="select t from TripExpense t")
public class TripExpense {
	
	protected final static String FIND_ALL_TRIP_EXPENSE = "find_all_trip_expense";
	
	@Id
	private String deliveryId;
	private String tripExpId;
	private int driverExp;
	private int miscExp;
	private int dieselExp;
	private int CashExp;
	private int tollExp;
	private int dailyAllowanceExp;
	private int borderCharges;
	private int repairExp;
	
	public TripExpense(){}
	
	public TripExpense(String deliveryId, String tripExpId, int driverExp, int miscExp, int dieselExp, int cashExp,
			int tollExp, int dailyAllowanceExp, int borderCharges, int repairExp) {
		super();
		this.deliveryId = deliveryId;
		this.tripExpId = tripExpId;
		this.driverExp = driverExp;
		this.miscExp = miscExp;
		this.dieselExp = dieselExp;
		CashExp = cashExp;
		this.tollExp = tollExp;
		this.dailyAllowanceExp = dailyAllowanceExp;
		this.borderCharges = borderCharges;
		this.repairExp = repairExp;
	}

	public String getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getTripExpId() {
		return tripExpId;
	}

	public void setTripExpId(String tripExpId) {
		this.tripExpId = tripExpId;
	}

	public int getDriverExp() {
		return driverExp;
	}

	public void setDriverExp(int driverExp) {
		this.driverExp = driverExp;
	}

	public int getMiscExp() {
		return miscExp;
	}

	public void setMiscExp(int miscExp) {
		this.miscExp = miscExp;
	}

	public int getDieselExp() {
		return dieselExp;
	}

	public void setDieselExp(int dieselExp) {
		this.dieselExp = dieselExp;
	}

	public int getCashExp() {
		return CashExp;
	}

	public void setCashExp(int cashExp) {
		CashExp = cashExp;
	}

	public int getTollExp() {
		return tollExp;
	}

	public void setTollExp(int tollExp) {
		this.tollExp = tollExp;
	}

	public int getDailyAllowanceExp() {
		return dailyAllowanceExp;
	}

	public void setDailyAllowanceExp(int dailyAllowanceExp) {
		this.dailyAllowanceExp = dailyAllowanceExp;
	}

	public int getBorderCharges() {
		return borderCharges;
	}

	public void setBorderCharges(int borderCharges) {
		this.borderCharges = borderCharges;
	}

	public int getRepairExp() {
		return repairExp;
	}

	public void setRepairExp(int repairExp) {
		this.repairExp = repairExp;
	}
	
}