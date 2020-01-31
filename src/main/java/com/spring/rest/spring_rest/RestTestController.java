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

@CrossOrigin(allowCredentials="true", origins="*", allowedHeaders="*", methods={RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.PUT,RequestMethod.TRACE})
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
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
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
	public ResponseEntity<StandardResponse> deleteCustomerById(@PathVariable("id") long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
		
	//JOB SERVICE
	@RequestMapping("/api/jobs")
	public List<Job> getAllJobs() {
		return jobService.getallJob();
	}
	
	@RequestMapping("/api/jobs/Completed")
	public List<Job> getAllCompletedJobs() {
		return jobService.getallCompletedPendingJobs("Completed");
	}

	@RequestMapping("/api/jobs/Pending")
	public List<Job> getAllPendingJobs() {
		return jobService.getallCompletedPendingJobs("Pending");
	}
	

	@RequestMapping("/api/job/{id}")
	public ResponseEntity<Job> getJob(@PathVariable("id") long id) {
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
	public ResponseEntity<StandardResponse> deleteJobById(@PathVariable("id") long id) {
		jobService.deleteJob(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
		
	//Vendor SERVICE
	@RequestMapping("/api/vendors")
	public List<Vendor> getAllVendors() {
		return vendorService.getallVendor();
	}

	@RequestMapping("/api/vendor/{id}")
	public ResponseEntity<Vendor> getVendor(@PathVariable("id") long id) {
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
	public ResponseEntity<StandardResponse> deleteVendorById(@PathVariable("id") long id) {
		vendorService.deleteVendor(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
		
	//INVENTORY SERVICE
	@RequestMapping("/api/inventory")
	public List<Inventory> getAllInventory() {
		return inventoryService.getallInventory();
	}

	@RequestMapping("/api/inventory/{id}")
	public ResponseEntity<Inventory> getInventory(@PathVariable("id") long id) {
		return new ResponseEntity<Inventory>(inventoryService.getInventory(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/inventory", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addInventory(@RequestBody(required = true) Inventory inventory) {
		inventoryService.addInventory(inventory);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/inventory", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateInventory(@RequestBody(required = true) Inventory inventory) {
		inventoryService.updateInventory(inventory);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/inventory/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteInventoryById(@PathVariable("id") long id) {
		inventoryService.deleteInventory(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
		
	//SERVICE SERVICE
	@RequestMapping("/services")
	public List<Service> getAllService() {
		return serviceService.getallServices();
	}

	@RequestMapping("/service/{id}")
	public ResponseEntity<Service> getService(@PathVariable("id") long id) {
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
	public ResponseEntity<StandardResponse> deleteServiceById(@PathVariable("id") long id) {
		serviceService.deleteService(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	//SALE SERVICE
	@RequestMapping("/api/sales")
	public List<Sale> getAllSales() {
		return saleService.getallSales();
	}

	@RequestMapping("/api/sale/{id}")
	public ResponseEntity<Sale> getSale(@PathVariable("id") long id) {
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
	public ResponseEntity<StandardResponse> deleteSaleById(@PathVariable("id") long id) {
		saleService.deleteSale(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	//WORKER SERVICE
	@RequestMapping("/api/workers")
	public List<Worker> getAllWorkers() {
		return workerService.getallWorkers();
	}
	

	@RequestMapping("/api/worker/{id}")
	public ResponseEntity<Worker> getWorker(@PathVariable("id") long id) {
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
	public ResponseEntity<StandardResponse> deleteWorkerById(@PathVariable("id") long id) {
		workerService.deleteWorker(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	//EXPENSE SERVICE
	@RequestMapping("/api/expenses")
	public List<Expense> getAllExpenses() {
		return expenseService.getallExpenses();
	}

	@RequestMapping("/api/expense/{id}")
	public ResponseEntity<Expense> getExpense(@PathVariable("id") long id) {
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
	public ResponseEntity<StandardResponse> deleteExpenseById(@PathVariable("id") long id) {
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
			
//	@Autowired
//	private QuizService quizService;
//	@Autowired
//	private CountryService countryService;
//	@Autowired
//	private WorkerService workerService;
//	@Autowired
//	private EmployerService employerService;
//	@Autowired
//	private EmployerjobService employerjobService;
//	@Autowired
//	private JobService jobService;
//	@Autowired////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	private ClientService clientService;
//	@Autowired
//	private FleetService fleetService;
//	@Autowired
//	private StateService stateService;
//	@Autowired
//	private DriverService driverService;
//	@Autowired
//	private OrdersService ordersService;
//	@Autowired
//	private MaintenanceService maintenanceService;
//	@Autowired
//	private RtoTaxService rtoTaxService;
//	@Autowired
//	private CityService cityService;
//	@Autowired
//	private DistanceService distanceService;
//	@Autowired
//	private DeliveryService deliveryService;
//	@Autowired
//	private TripExpenseService tripExpenseService;
//	@Autowired
//	private NotesService notesService;
//	@Autowired
//	private TaskService taskService;
//	@Autowired
//	private InsuranceService insuranceService;
//
//	
//	String getMD5(String msg){
//		try {  
//            MessageDigest md = MessageDigest.getInstance("MD5"); 
//            byte[] messageDigest = md.digest(msg.getBytes()); 
//            BigInteger no = new BigInteger(1, messageDigest); 
//            String hashtext = no.toString(16); 
//            while (hashtext.length() < 32) { 
//                hashtext = "0" + hashtext; 
//            } 
//            return hashtext; 
//        }  
//        catch (NoSuchAlgorithmException e) { 
//            throw new RuntimeException(e); 
//        }
//	}
//	
//	
//	
//	
//	//LOGIN SERVICE
//	@RequestMapping("/logins")
//	public List<Login> getAllLoginData() {
//		return loginService.getallLogins();
//	}
//	
//	@RequestMapping(value = "/logintest", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> testUser(@RequestBody(required = true) Login login) {
//		try{
//			Login temp = loginService.getLogin(login.getUsername());
//			if(temp.getPassword().equals(getMD5(login.getPassword()))) return new ResponseEntity<StandardResponse>(new StandardResponse(temp.getType()), HttpStatus.OK);
//			else return new ResponseEntity<StandardResponse>(new StandardResponse("False"), HttpStatus.OK);
//		}catch(Exception e){
//			return new ResponseEntity<StandardResponse>(new StandardResponse("User not found"), HttpStatus.OK);
//		}
//	}
//
//	@RequestMapping("/logins/{username}")
//	public ResponseEntity<Login> getLogin(@PathVariable("username") String username) {
//		return new ResponseEntity<Login>(loginService.getLogin(username), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/logins/{username}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteLoginByUsername(@PathVariable("username") String username) {
//		loginService.deleteLogin(username);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/logins", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addLogin(@RequestBody(required = true) Login login) {
//		login.setPassword(getMD5(login.getPassword()));
//		loginService.addLogin(login);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/logins", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateLogin(@RequestBody(required = true) Login login) {
//		login.setPassword(getMD5(login.getPassword()));
//		loginService.updateLogin(login);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//	
//	// COUNTRY SERVICE
//	@RequestMapping("/countries")
//	public List<Country> getAllCountriesData() {
//		return countryService.getallCountries();
//	}
//
//	@RequestMapping("/countries/{id}")
//	public ResponseEntity<Country> getCountry(@PathVariable("id") String id) {
//		return new ResponseEntity<Country>(countryService.getCountry(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/countries", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addCountry(@RequestBody(required = true) Country country) {
//		countryService.addCountry(country);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/countries", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateCountry(@RequestBody(required = true) Country country) {
//		countryService.updateCountry(country);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/countries/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteCountryById(@PathVariable("id") String id) {
//		countryService.deleteCountry(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//		
//	// WORKER SERVICE
//	@RequestMapping("/workers")
//	public List<Worker> getAllWorkersData() {
//		return workerService.getallWorkers();
//	}
//
//	@RequestMapping("/workers/{id}")
//	public ResponseEntity<Worker> getWorker(@PathVariable("id") String id) {
//		return new ResponseEntity<Worker>(workerService.getWorker(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/workers", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addWorker(@RequestBody(required = true) Worker worker) {
//		workerService.addWorker(worker);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/workers", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateWorker(@RequestBody(required = true) Worker worker) {
//		workerService.updateWorker(worker);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/workers/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteWorkerById(@PathVariable("id") String id) {
//		workerService.deleteWorker(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//	
//	// EMPLOYER SERVICE
//	@RequestMapping("/employers")
//	public List<Employer> getAllEmployersData() {
//		return employerService.getallEmployers();
//	}
//
//	@RequestMapping("/employers/{id}")
//	public ResponseEntity<Employer> getEmployer(@PathVariable("id") String id) {
//		return new ResponseEntity<Employer>(employerService.getEmployer(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/employers", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addEmployer(@RequestBody(required = true) Employer employer) {
//		employerService.addEmployer(employer);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/employers", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateEmployer(@RequestBody(required = true) Employer employer) {
//		employerService.updateEmployer(employer);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/employers/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteEmployerById(@PathVariable("id") String id) {
//		employerService.deleteEmployer(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//	
//	// EMPLOYERJOB SERVICE
//	@RequestMapping("/employerjobs")
//	public List<Employerjob> getAllEmployerjobsData() {
//		return employerjobService.getallEmployerjobs();
//	}
//
//	@RequestMapping("/employerjobs/{id}")
//	public ResponseEntity<Employerjob> getEmployerjob(@PathVariable("id") String id) {
//		return new ResponseEntity<Employerjob>(employerjobService.getEmployerjob(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/employerjobs", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addEmployerjob(@RequestBody(required = true) Employerjob employerjob) {
//		employerjobService.addEmployerjob(employerjob);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/employerjobs", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateEmployerjob(@RequestBody(required = true) Employerjob employerjob) {
//		employerjobService.updateEmployerjob(employerjob);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/employerjobs/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteEmployerjobById(@PathVariable("id") String id) {
//		employerjobService.deleteEmployerjob(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//	
//	// JOBS SERVICE
//	@RequestMapping("/jobs")
//	public List<Job> getAllJobsData() {
//		return jobService.getallJobs();
//	}
//
//	@RequestMapping("/jobs/{id}")
//	public ResponseEntity<Job> getJob(@PathVariable("id") String id) {
//		return new ResponseEntity<Job>(jobService.getJob(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/jobs", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addjob(@RequestBody(required = true) Job job) {
//		jobService.addJob(job);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/jobs", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateJob(@RequestBody(required = true) Job job) {
//		jobService.updateJob(job);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/jobs/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteJobById(@PathVariable("id") String id) {
//		jobService.deleteJob(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	//REPORTS
//	@RequestMapping("/jobs/total")
//	public int getJobsCount() {
//		return jobService.getJobCount();
//	}
//	
//	@RequestMapping("/jobs/totalactive")
//	public int getActiveJobsCount() {
//		return jobService.getActiveJobsCount();
//	}
//	
//	@RequestMapping("/employers/total")
//	public int getEmployersCount() {
//		return employerService.getEmployerCount();
//	}
//	
//	@RequestMapping("/workers/total")
//	public int getWorkersCount() {
//		return workerService.getWorkerCount();
//	}
//	@RequestMapping("/jobs/status")
//	public List<Report> getActiveInactiveCount() {
//		return jobService.getActiveInactiveCount();
//	}
//	
//	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	// CLIENT SERVICE
//	@RequestMapping("/clients")
//	public List<Client> getAllClientData() {
//		return clientService.getallClients();
//	}
//
//	@RequestMapping("/clients/{id}")
//	public ResponseEntity<Client> getClient(@PathVariable("id") String id) {
//		return new ResponseEntity<Client>(clientService.getClient(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteClientById(@PathVariable("id") String id) {
//		clientService.deleteClient(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/clients", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addClient(@RequestBody(required = true) Client client) {
//		clientService.addClient(client);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/clients", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateClient(@RequestBody(required = true) Client client) {
//		clientService.updateEmployee(client);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// FLEET SERVICE
//	@RequestMapping("/fleets")
//	public List<Fleet> getAllFleetData() {
//		return fleetService.getAllFleets();
//	}
//
//	@RequestMapping("/fleets/{id}")
//	public ResponseEntity<Fleet> getFleet(@PathVariable("id") String id) {
//		return new ResponseEntity<Fleet>(fleetService.getFleet(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/fleets/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteFleetById(@PathVariable("id") String id) {
//		fleetService.deleteFleet(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/fleets", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addFleet(@RequestBody(required = true) Fleet fleet) {
//		fleetService.addFleet(fleet);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/fleets", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateFleet(@RequestBody(required = true) Fleet fleet) {
//		fleetService.updateFleet(fleet);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// STATES SERVICE
//	@RequestMapping("/states")
//	public List<State> getAllStatesData() {
//		return stateService.getallStates();
//	}
//
//	@RequestMapping("/states/{id}")
//	public ResponseEntity<State> getState(@PathVariable("id") String id) {
//		return new ResponseEntity<State>(stateService.getState(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/states", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addState(@RequestBody(required = true) State state) {
//		stateService.addState(state);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/states", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateState(@RequestBody(required = true) State state) {
//		stateService.updateState(state);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/states/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteStateById(@PathVariable("id") String id) {
//		stateService.deleteState(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// DRIVER SERVICE
//	@RequestMapping("/drivers")
//	public List<Driver> getAllDriverData() {
//		return driverService.getallDrivers();
//	}
//
//	@RequestMapping("/drivers/{id}")
//	public ResponseEntity<Driver> getDriver(@PathVariable("id") String id) {
//		return new ResponseEntity<Driver>(driverService.getDriver(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/drivers/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteDriverById(@PathVariable("id") String id) {
//		driverService.deleteDriver(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/drivers", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addDriver(@RequestBody(required = true) Driver driver) {
//		driverService.addDriver(driver);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/drivers", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateDriver(@RequestBody(required = true) Driver driver) {
//		driverService.updateDriver(driver);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// ORDER SERVICE
//	@RequestMapping("/orders")
//	public List<Orders> getAllOrderData() {
//		return ordersService.getallOrders();
//	}
//
//	@RequestMapping("/orders/{id}")
//	public ResponseEntity<Orders> getOrder(@PathVariable("id") String id) {
//		return new ResponseEntity<Orders>(ordersService.getOrder(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteOrderById(@PathVariable("id") String id) {
//		ordersService.deleteOrder(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/orders", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addOrder(@RequestBody(required = true) Orders order) {
//		ordersService.addOrder(order);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/orders", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateOrder(@RequestBody(required = true) Orders order) {
//		ordersService.updateOrder(order);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// MAINTENANCE SERVICE
//	@RequestMapping("/maintenance")
//	public List<Maintenance> getAllMaintenanceData() {
//		return maintenanceService.getallMaintenance();
//	}
//
//	@RequestMapping("/maintenance/{id}")
//	public ResponseEntity<Maintenance> getMaintenance(@PathVariable("id") String id) {
//		return new ResponseEntity<Maintenance>(maintenanceService.getMaintenance(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/maintenance/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteMaintenanceById(@PathVariable("id") String id) {
//		maintenanceService.deleteMaintenance(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/maintenance", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addMaintenance(@RequestBody(required = true) Maintenance maintenance) {
//		maintenanceService.addMaintenance(maintenance);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/maintenance", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateMaintenance(@RequestBody(required = true) Maintenance maintenance) {
//		maintenanceService.updateMaintenance(maintenance);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// RTO TAX SERVICE
//	@RequestMapping("/rtotax")
//	public List<Rto> getAllRtoTaxData() {
//		return rtoTaxService.getallRtoTax();
//	}
//
//	@RequestMapping("/rtotax/{id}")
//	public ResponseEntity<Rto> getRtoTax(@PathVariable("id") String id) {
//		return new ResponseEntity<Rto>(rtoTaxService.getRtoTax(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/rtotax/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteRtoTaxById(@PathVariable("id") String id) {
//		rtoTaxService.deleteRtoTax(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/rtotax", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addRtoTax(@RequestBody(required = true) Rto rtoTax) {
//		rtoTaxService.addRtoTax(rtoTax);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/rtotax", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateRtoTax(@RequestBody(required = true) Rto rtoTax) {
//		rtoTaxService.updateRtoTax(rtoTax);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// CITY SERVICE
//	@RequestMapping("/cities")
//	public List<City> getAllCityData() {
//		return cityService.getallCities();
//	}
//
//	@RequestMapping("/cities/{id}")
//	public ResponseEntity<City> getCity(@PathVariable("id") String id) {
//		return new ResponseEntity<City>(cityService.getCity(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/cities/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteCityById(@PathVariable("id") String id) {
//		cityService.deleteCity(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/cities", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addCity(@RequestBody(required = true) City city) {
//		cityService.addCity(city);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/cities", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateCity(@RequestBody(required = true) City city) {
//		cityService.updateCity(city);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//	
//	
//
//	// DISTANCE SERVICE
//	@RequestMapping("/distances")
//	public List<Distance> getAllDistanceData() {
//		return distanceService.getallDistance();
//	}
//
//	@RequestMapping("/distances/{id}")
//	public ResponseEntity<Distance> getDistance(@PathVariable("id") String id) {
//		return new ResponseEntity<Distance>(distanceService.getDistance(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/distances/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteDistanceById(@PathVariable("id") String id) {
//		distanceService.deleteDistance(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/distances", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addDistance(@RequestBody(required = true) Distance distance) {
//		distanceService.addDistance(distance);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/distances", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateDistance(@RequestBody(required = true) Distance distance) {
//		distanceService.updateD(distance);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// DELIVERY
//	@RequestMapping("/deliveries")
//	public List<Delivery> getAllDeliveries() {
//		return deliveryService.getallDelivery();
//	}
//
//	@RequestMapping("/deliveries/{id}")
//	public ResponseEntity<Delivery> getDelivery(@PathVariable("id") String id) {
//		return new ResponseEntity<Delivery>(deliveryService.getDelivery(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/deliveries/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteDeliveryById(@PathVariable("id") String id) {
//		deliveryService.deleteDelivery(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/deliveries", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addDelivery(@RequestBody(required = true) Delivery delivery) {
//		deliveryService.addDelivery(delivery);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/deliveries", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateDelivery(@RequestBody(required = true) Delivery delivery) {
//		deliveryService.updateDelivery(delivery);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// TRIP EXPENSE
//
//	@RequestMapping("/tripexpenses")
//	public List<TripExpense> getAllTripExpense() {
//		return tripExpenseService.getallTripExpense();
//	}
//
//	@RequestMapping("/tripexpenses/{id}")
//	public ResponseEntity<TripExpense> getTripExpense(@PathVariable("id") String id) {
//		return new ResponseEntity<TripExpense>(tripExpenseService.getTripExpense(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/tripexpenses/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteTripExpenseById(@PathVariable("id") String id) {
//		tripExpenseService.deleteTripExpense(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/tripexpenses", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addTripExpense(@RequestBody(required = true) TripExpense tripExpense) {
//		tripExpenseService.addTripExpense(tripExpense);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/tripexpenses", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateTripExpense(@RequestBody(required = true) TripExpense tripExpense) {
//		tripExpenseService.updateTripExpense(tripExpense);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// NOTES
//
//	@RequestMapping("/notes")
//	public List<Notes> getAllNotes() {
//		return notesService.getallNotes();
//	}
//
//	@RequestMapping("/notes/{id}")
//	public ResponseEntity<Notes> getNote(@PathVariable("id") String id) {
//		return new ResponseEntity<Notes>(notesService.getNote(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteNoteById(@PathVariable("id") String id) {
//		notesService.deleteNote(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/notes", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addNote(@RequestBody(required = true) Notes note) {
//		notesService.addNote(note);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/notes", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateNote(@RequestBody(required = true) Notes note) {
//		notesService.updateNote(note);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// TASKS
//	@RequestMapping("/tasks")
//	public List<Task> getAllTasks() {
//		return taskService.getallTasks();
//	}
//
//	@RequestMapping("/tasks/{id}")
//	public ResponseEntity<Task> getTask(@PathVariable("id") String id) {
//		return new ResponseEntity<Task>(taskService.getTask(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteTaskById(@PathVariable("id") String id) {
//		taskService.deleteTask(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/tasks", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addTask(@RequestBody(required = true) Task task) {
//		taskService.addTask(task);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/tasks", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateTask(@RequestBody(required = true) Task task) {
//		taskService.updateTask(task);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// INSURANCE
//	@RequestMapping("/insurance")
//	public List<Insurance> getAllInsurance() {
//		return insuranceService.getallInsurance();
//	}
//
//	@RequestMapping("/insurance/{id}")
//	public ResponseEntity<Insurance> getInsurance(@PathVariable("id") String id) {
//		return new ResponseEntity<Insurance>(insuranceService.getInsurance(id), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/insurance/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<StandardResponse> deleteInsuranceById(@PathVariable("id") String id) {
//		insuranceService.deleteInsurance(id);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/insurance", method = RequestMethod.POST)
//	public ResponseEntity<StandardResponse> addInsurance(@RequestBody(required = true) Insurance insurance) {
//		insuranceService.addInsurance(insurance);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/insurance", method = RequestMethod.PUT)
//	public ResponseEntity<StandardResponse> updateInsurance(@RequestBody(required = true) Insurance insurance) {
//		insuranceService.updateInsurance(insurance);
//		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//	}
//
//	// REPORTS STATS
//	@RequestMapping("/fleets/total")
//	public int getFleetCount() {
//		return fleetService.getFleetCount();
//	}
//
//	@RequestMapping("/fleets/totalprice")
//	public long getAllFleetPrice() {
//		return fleetService.getFleetPrice();
//	}
//
//	@RequestMapping("/drivers/total")
//	public int getDriverCount() {
//		return driverService.getDriverCount();
//	}
//
//	@RequestMapping("/deliver/{status}")
//	public int getCompletedPendingDeliveryCount(@PathVariable("status") String status) {
//		return deliveryService.getCompletedPendingCount(status);
//	}
//
//	@RequestMapping("/staticreports/delivery")
//	public List<Report> getCompletedPendingDeliveryCount() {
//		return deliveryService.getCompletedPendingCount();
//	}
//
//	@RequestMapping("/orders/kmstravelled")
//	public int getTotalKmsTravelled() {
//		return ordersService.getTotalDistanceCompleted();
//	}
//
//	@RequestMapping("/orders/reports/monthcount/{date1}/{date2}")
//	public int getOrdersPerMonthCount(@PathVariable("date1") String d1, @PathVariable("date2") String d2)
//			throws ParseException {
//		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
//		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		sdf.format(date1);
//		sdf.format(date2);
//		return ordersService.getOrdersPerMonthCount(date1, date2);
//	}
//
//	@RequestMapping("/staticreports/orderperclient")
//	public List<Report> getOrderCountPerClient() {
//		return ordersService.getTotalOrdersPerClient();
//	}
//
//	// MAIN REPORTS
//	@RequestMapping("/orders/reports/month/{date1}/{date2}")
//	public List<Orders> getOrdersPerMonth(@PathVariable("date1") String d1, @PathVariable("date2") String d2)
//			throws ParseException {
//		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(d1);
//		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(d2);
//		return ordersService.getOrdersPerMonth(date1, date2);
//	}
//
//	@RequestMapping("/orders/reports/client/{id}")
//	public List<Orders> getOrdersPerClient(@PathVariable("id") String cid) {
//		return ordersService.getOrdersPerClient(cid);
//	}
//
//	@RequestMapping("/orders/reports/fleet/{id}")
//	public List<Orders> getOrdersPerFleet(@PathVariable("id") String cid) {
//		return ordersService.getOrdersPerFleet(cid);
//	}
//
//	@RequestMapping("/orders/reports/order/{status}")
//	public List<Orders> getOrdersPendingCompleted(@PathVariable("status") String status) {
//		return ordersService.getOrdersCompletedPending(status);
//	}
//	
//	@RequestMapping("/tripexpense/reports/{id}")
//	public TripExpense getTripExpenseByDeliveryId(@PathVariable("id") String id) {
//		return tripExpenseService.getTripExpenseByDeliveryId(id);
//	}
//
//	////////////////////////////////////////////////////////////////////////////////////////////
//	
//		@RequestMapping("/quiz")
//		public List<Quiz> getAllQuizData() {
//			return quizService.getallQuiz();
//		}
//
//		@RequestMapping("/quiz/{id}")
//		public ResponseEntity<Quiz> getQuiz(@PathVariable("id") String id) {
//			return new ResponseEntity<Quiz>(quizService.getQuiz(id), HttpStatus.OK);
//		}
//
//		@RequestMapping(value = "/quiz", method = RequestMethod.POST)
//		public ResponseEntity<StandardResponse> addQuiz(@RequestBody(required = true) Quiz quiz) {
//			quizService.addQuiz(quiz);
//			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//		}
//
//		@RequestMapping(value = "/quiz", method = RequestMethod.PUT)
//		public ResponseEntity<StandardResponse> updateQuiz(@RequestBody(required = true) Quiz quiz) {
//			quizService.updateQuiz(quiz);
//			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//		}
//
//		@RequestMapping(value = "/quiz/{id}", method = RequestMethod.DELETE)
//		public ResponseEntity<StandardResponse> deleteQuizById(@PathVariable("id") String id) {
//			quizService.deleteQuiz(id);
//			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
//		}
}