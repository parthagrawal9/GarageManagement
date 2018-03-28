package com.spring.rest.spring_rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private FleetService fleetService;
	@Autowired
	private StateService stateService;
	@Autowired
	private DriverService driverService;
	@Autowired
	private OrdersService ordersService;

	// CLIENT SERVICE
	@RequestMapping("/clients")
	public List<Client> getAllClientData() {
		return clientService.getallClients();
	}

	@RequestMapping("/clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") String id) {
		return new ResponseEntity<Client>(clientService.getClient(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteClientById(@PathVariable("id") String id) {
		clientService.deleteClient(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addClient(@RequestBody(required = true) Client client) {
		clientService.addClient(client);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateClient(@RequestBody(required = true) Client client) {
		clientService.updateEmployee(client);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	// FLEET SERVICE
	@RequestMapping("/fleets")
	public List<Fleet> getAllFleetData() {
		return fleetService.getAllFleets();
	}

	@RequestMapping("/fleets/{id}")
	public ResponseEntity<Fleet> getFleet(@PathVariable("id") String id) {
		return new ResponseEntity<Fleet>(fleetService.getFleet(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/fleets/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteFleetById(@PathVariable("id") String id) {
		fleetService.deleteFleet(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/fleets", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addFleet(@RequestBody(required = true) Fleet fleet) {
		fleetService.addFleet(fleet);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/fleets/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateFleet(@RequestBody(required = true) Fleet fleet) {
		fleetService.updateFleet(fleet);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	// STATES SERVICE
	@RequestMapping("/states")
	public List<State> getAllStatesData() {
		return stateService.getallStates();
	}

	@RequestMapping("/states/{id}")
	public ResponseEntity<State> getState(@PathVariable("id") String id) {
		return new ResponseEntity<State>(stateService.getState(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/states", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addState(@RequestBody(required = true) State state) {
		stateService.addState(state);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/states/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateState(@RequestBody(required = true) State state) {
		stateService.updateState(state);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/states/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteStateById(@PathVariable("id") String id) {
		stateService.deleteState(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	// DRIVER SERVICE
	@RequestMapping("/drivers")
	public List<Driver> getAllDriverData() {
		return driverService.getallDrivers();
	}

	@RequestMapping("/drivers/{id}")
	public ResponseEntity<Driver> getDriver(@PathVariable("id") String id) {
		return new ResponseEntity<Driver>(driverService.getDriver(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/drivers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteDriverById(@PathVariable("id") String id) {
		driverService.deleteDriver(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/drivers", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addDriver(@RequestBody(required = true) Driver driver) {
		driverService.addDriver(driver);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/drivers/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateDriver(@RequestBody(required = true) Driver driver) {
		driverService.updateDriver(driver);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
	
	//ORDER SERVICE
	@RequestMapping("/orders")
	public List<Orders> getAllOrderData() {
		return ordersService.getallOrders();
	}

	@RequestMapping("/orders/{id}")
	public ResponseEntity<Orders> getOrder(@PathVariable("id") String id) {
		return new ResponseEntity<Orders>(ordersService.getOrder(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteOrderById(@PathVariable("id") String id) {
		ordersService.deleteOrder(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public ResponseEntity<StandardResponse> addOrder(@RequestBody(required = true) Orders order) {
		ordersService.addOrder(order);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateOrder(@RequestBody(required = true) Orders order) {
		ordersService.updateOrder(order);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
	}
}
