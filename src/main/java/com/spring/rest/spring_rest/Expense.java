package com.spring.rest.spring_rest;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Expense.FIND_ALL_EXPENSES, query = "select e from Expense e")
public class Expense {
	
	protected static final String FIND_ALL_EXPENSES = "find_all_expenses";
	
	@Id
	private String expenseId;
	private String expenseTitle;
	private String expenseDesc;
	private String expenseType;
	private float expenseAmount;
	private Date expenseDate;
	
	public Expense(){}
	
	public Expense(String expenseId, String expenseTitle, String expenseDesc, float expenseAmount, Date expenseDate, String expenseType) {
		super();
		this.expenseId = expenseId;
		this.expenseTitle = expenseTitle;
		this.expenseDesc = expenseDesc;
		this.expenseAmount = expenseAmount;
		this.expenseDate = expenseDate;
		this.expenseType = expenseType;
	}
	public String getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}
	public String getExpenseTitle() {
		return expenseTitle;
	}
	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	public float getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(float expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	} 
}
