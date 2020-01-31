package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Service.FIND_ALL_SERVICES, query = "select s from Service s")
public class Service {
	
	protected static final String FIND_ALL_SERVICES = "find_all_services"; 
	
	@Id
	@GeneratedValue
	private long serviceId;
	private String serviceName;
	private String serviceDescription;
	
	public Service(){}

	public Service(long serviceId, String serviceName, String serviceDescription) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	
	
}
