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
	@Autowired
	private MaintenanceService maintenanceService;
	@Autowired
	private RtoTaxService rtoTaxService;
	@Autowired
	private CityService cityService;
	@Autowired 
	private DistanceService distanceService;


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

	@RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
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

	@RequestMapping("/fleets/total")
	public int getFleetCount() {
		return fleetService.getFleetCount();
	}
	
	@RequestMapping("/fleets/totalprice")
	public long getAllFleetPrice() {
		return fleetService.getFleetPrice();
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

	@RequestMapping("/drivers/total")
	public int getDriverCount() {
		return driverService.getDriverCount();
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
	
	// MAINTENANCE SERVICE
		@RequestMapping("/maintenance")
		public List<Maintenance> getAllMaintenanceData() {
			return maintenanceService.getallMaintenance();
		}

		@RequestMapping("/maintenance/{id}")
		public ResponseEntity<Maintenance> getMaintenance(@PathVariable("id") String id) {
			return new ResponseEntity<Maintenance>(maintenanceService.getMaintenance(id), HttpStatus.OK);
		}

		@RequestMapping(value = "/maintenance/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<StandardResponse> deleteMaintenanceById(@PathVariable("id") String id) {
			maintenanceService.deleteMaintenance(id);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}

		@RequestMapping(value = "/maintenance", method = RequestMethod.POST)
		public ResponseEntity<StandardResponse> addMaintenance(@RequestBody(required = true) Maintenance maintenance) {
			maintenanceService.addMaintenance(maintenance);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}

		@RequestMapping(value = "/maintenance/{id}", method = RequestMethod.PUT)
		public ResponseEntity<StandardResponse> updateMaintenance(@RequestBody(required = true) Maintenance maintenance) {
			maintenanceService.updateMaintenance(maintenance);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}
		
		// RTO TAX SERVICE
		@RequestMapping("/rtotax")
		public List<Rto> getAllRtoTaxData() {
			return rtoTaxService.getallRtoTax();
		}

		@RequestMapping("/rtotax/{id}")
		public ResponseEntity<Rto> getRtoTax(@PathVariable("id") String id) {
			return new ResponseEntity<Rto>(rtoTaxService.getRtoTax(id), HttpStatus.OK);
		}

		@RequestMapping(value = "/rtotax/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<StandardResponse> deleteRtoTaxById(@PathVariable("id") String id) {
			rtoTaxService.deleteRtoTax(id);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}

		@RequestMapping(value = "/rtotax", method = RequestMethod.POST)
		public ResponseEntity<StandardResponse> addRtoTax(@RequestBody(required = true) Rto rtoTax) {
			rtoTaxService.addRtoTax(rtoTax);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}

		@RequestMapping(value = "/rtotax/{id}", method = RequestMethod.PUT)
		public ResponseEntity<StandardResponse> updateRtoTax(@RequestBody(required = true) Rto rtoTax) {
			rtoTaxService.updateRtoTax(rtoTax);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}
		
		// CITY SERVICE
		@RequestMapping("/cities")
		public List<City> getAllCityData() {
			return cityService.getallCities();
		}

		@RequestMapping("/cities/{id}")
		public ResponseEntity<City> getCity(@PathVariable("id") String id) {
			return new ResponseEntity<City>(cityService.getCity(id), HttpStatus.OK);
		}

		@RequestMapping(value = "/cities/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<StandardResponse> deleteCityById(@PathVariable("id") String id) {
			cityService.deleteCity(id);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}

		@RequestMapping(value = "/cities", method = RequestMethod.POST)
		public ResponseEntity<StandardResponse> addCity(@RequestBody(required = true) City city) {
			cityService.addCity(city);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}

		@RequestMapping(value = "/cities/{id}", method = RequestMethod.PUT)
		public ResponseEntity<StandardResponse> updateCity(@RequestBody(required = true) City city) {
			cityService.updateCity(city);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}
		
		// DISTANCE SERVICE
		@RequestMapping("/distances")
		public List<Distance> getAllDistanceData() {
			return distanceService.getallDistance();
		}

		@RequestMapping("/distances/{id}")
		public ResponseEntity<Distance> getDistance(@PathVariable("id") String id) {
			return new ResponseEntity<Distance>(distanceService.getDistance(id), HttpStatus.OK);
		}

		@RequestMapping(value = "/distances/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<StandardResponse> deleteDistanceById(@PathVariable("id") String id) {
			distanceService.deleteDistance(id);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}

		@RequestMapping(value = "/distances", method = RequestMethod.POST)
		public ResponseEntity<StandardResponse> addDistance(@RequestBody(required = true) Distance distance) {
			distanceService.addDistance(distance);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}

		@RequestMapping(value = "/distances/{id}", method = RequestMethod.PUT)
		public ResponseEntity<StandardResponse> updateDistance(@RequestBody(required = true) Distance distance) {
			distanceService.updateD(distance);
			return new ResponseEntity<StandardResponse>(new StandardResponse("OK"), HttpStatus.OK);
		}
		
		//Reports
		
}