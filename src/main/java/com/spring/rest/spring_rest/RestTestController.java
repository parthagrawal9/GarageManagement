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
	@Autowired
	private JobService jobService;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private WorkerService workerService;
	@Autowired
	private ExpenseService expenseService;
	
	//HEALTH
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
		//MD5 md = new MD5();
		//login.setUserPassword(md.getMd5(login.getUserPassword()));
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
	
		
	
	//CUSTOMER SERVICE
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
	
		
	//JOB SERVICE
	@RequestMapping("/api/jobs")
	public List<Job> getAllJobs() {
		return jobService.getallJob();
	}

	@RequestMapping("/api/job/{id}")
	public ResponseEntity<Job> getJob(@PathVariable("id") String id) {
		return new ResponseEntity<Job>(jobService.getJob(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/jobs", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addJob(@RequestBody(required = true) Job job) {
		jobService.addJob(job);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/jobs", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateJob(@RequestBody(required = true) Job job) {
		jobService.updateJob(job);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/jobs/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteJobById(@PathVariable("id") String id) {
		jobService.deleteJob(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
		
	//Vendor SERVICE
	@RequestMapping("/api/vendors")
	public List<Vendor> getAllVendors() {
		return vendorService.getallVendor();
	}

	@RequestMapping("/api/vendor/{id}")
	public ResponseEntity<Vendor> getVendor(@PathVariable("id") String id) {
		return new ResponseEntity<Vendor>(vendorService.getVendor(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/vendors", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addVendor(@RequestBody(required = true) Vendor vendor) {
		vendorService.addVendor(vendor);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/vendors", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateVendor(@RequestBody(required = true) Vendor vendor) {
		vendorService.updateVendor(vendor);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/vendors/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteVendorById(@PathVariable("id") String id) {
		vendorService.deleteVendor(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
		
	//INVENTORY SERVICE
	@RequestMapping("/api/inventory")
	public List<Inventory> getAllInventory() {
		return inventoryService.getallInventory();
	}

	@RequestMapping("/api/inventory/{id}")
	public ResponseEntity<Inventory> getInventory(@PathVariable("id") String id) {
		return new ResponseEntity<Inventory>(inventoryService.getInventory(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/Inventory", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addInventory(@RequestBody(required = true) Inventory inventory) {
		inventoryService.addInventory(inventory);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/Inventory", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateInventory(@RequestBody(required = true) Inventory inventory) {
		inventoryService.updateInventory(inventory);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/Inventory/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteInventoryById(@PathVariable("id") String id) {
		inventoryService.deleteInventory(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
		
	//SERVICE SERVICE
	@RequestMapping("/services")
	public List<Service> getAllService() {
		return serviceService.getallServices();
	}

	@RequestMapping("/service/{id}")
	public ResponseEntity<Service> getService(@PathVariable("id") String id) {
		return new ResponseEntity<Service>(serviceService.getService(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/services", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addService(@RequestBody(required = true) Service service) {
		serviceService.addService(service);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/services", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateService(@RequestBody(required = true) Service Service) {
		serviceService.updateService(Service);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/services/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteServiceById(@PathVariable("id") String id) {
		serviceService.deleteService(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	//SALE SERVICE
	@RequestMapping("/api/sales")
	public List<Sale> getAllSales() {
		return saleService.getallSales();
	}

	@RequestMapping("/api/sale/{id}")
	public ResponseEntity<Sale> getSale(@PathVariable("id") String id) {
		return new ResponseEntity<Sale>(saleService.getSale(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/sales", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addSale(@RequestBody(required = true) Sale sale) {
		saleService.addSale(sale);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/sales", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateSale(@RequestBody(required = true) Sale sale) {
		saleService.updateSale(sale);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/sales/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteSaleById(@PathVariable("id") String id) {
		saleService.deleteSale(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	//WORKER SERVICE
	@RequestMapping("/api/workers")
	public List<Worker> getAllWorkers() {
		return workerService.getallWorkers();
	}

	@RequestMapping("/api/worker/{id}")
	public ResponseEntity<Worker> getWorker(@PathVariable("id") String id) {
		return new ResponseEntity<Worker>(workerService.getWorker(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/worker", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addWorker(@RequestBody(required = true) Worker worker) {
		workerService.addWorker(worker);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/worker", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateWorker(@RequestBody(required = true) Worker worker) {
		workerService.updateWorker(worker);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/worker/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteWorkerById(@PathVariable("id") String id) {
		workerService.deleteWorker(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	//EXPENSE SERVICE
	@RequestMapping("/api/expenses")
	public List<Expense> getAllExpenses() {
		return expenseService.getallExpenses();
	}

	@RequestMapping("/api/expense/{id}")
	public ResponseEntity<Expense> getExpense(@PathVariable("id") String id) {
		return new ResponseEntity<Expense>(expenseService.getExpense(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/expense", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addExpense(@RequestBody(required = true) Expense expense) {
		expenseService.addExpense(expense);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/expense", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateExpense(@RequestBody(required = true) Expense expense) {
		expenseService.updateExpense(expense);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/expense/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteExpenseById(@PathVariable("id") String id) {
		expenseService.deleteExpense(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	//STAT REPORT
	@RequestMapping("/api/statreport/job/{status}")
	public int getCompletedPendingJobCount(@PathVariable("status") String status) {
		return jobService.getCompletedPendingCount(status);
	}

	@RequestMapping("/api/statreport/job")
	public List<StatReport> getCompletedPendingJobCount() {
		return jobService.getCompletedPendingCount();
	}

}