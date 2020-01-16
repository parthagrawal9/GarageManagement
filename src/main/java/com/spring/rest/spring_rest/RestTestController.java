package com.spring.rest.spring_rest;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RestTestController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private CustomerService customerService;
	
//	HEALTH
	@RequestMapping("/health")
	public String getHealth() {
		return "OK";
	}
	
	//AUTH TEST
	@RequestMapping("/")
	public String home(){
		return "Hello";
	}
	
	@RequestMapping("/api")
	public String privateArea(){
		return "Private";
	}
	
	//LOGIN & USER
	@RequestMapping(value = "/api/adduser", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addLogin(@RequestBody(required = true) Login login) {
//		MD5 md = new MD5();
//		login.setUserPassword(md.getMd5(login.getUserPassword()));
		login.setUserPassword(login.getUserPassword());
		loginService.addLogin(login);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	@RequestMapping("/api/logins")
	public List<Login> getAllLoginData() {
		return loginService.getallLogins();
	}
	
	@RequestMapping("/api/logins/{username}")
	public ResponseEntity<Login> getLogin(@PathVariable("username") String username) {
		return new ResponseEntity<Login>(loginService.getLogin(username), HttpStatus.OK);
	}
	
		
	
//	 	CUSTOMER SERVICE
		@RequestMapping("/api/customers")
		public List<Customer> getAllCustomersData() {
			return customerService.getallCustomer();
		}
	
		@RequestMapping("/api/customer/{id}")
		public ResponseEntity<Customer> getCustomer(@PathVariable("id") String id) {
			return new ResponseEntity<Customer>(customerService.getCustomer(id), HttpStatus.OK);
		}
	
		@RequestMapping(value = "/api/customers", method = RequestMethod.POST)
		public ResponseEntity<StandardResponse> addCustomer(@RequestBody(required = true) Customer customer) {
			customerService.addCustomer(customer);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}
	
		@RequestMapping(value = "/api/customers", method = RequestMethod.PUT)
		public ResponseEntity<StandardResponse> updateCustomer(@RequestBody(required = true) Customer customer) {
			customerService.updateCustomer(customer);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}
	
		@RequestMapping(value = "/api/customers/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<StandardResponse> deleteCustomerById(@PathVariable("id") String id) {
			customerService.deleteCustomer(id);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}
	

}