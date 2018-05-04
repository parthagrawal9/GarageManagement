package com.spring.rest.spring_rest;

public class Report {

	String id;
	int value;
	
	public Report(){}
	
	public Report(String id, int value) {
		super();
		this.id = id;
		this.value = value;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
