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
	private FleetService fleetService;

	//CLIENT SERVICE
	@RequestMapping("/clients")
	public List<Client> getAllClientData() {
		return clientService.getallClients();
	}
	
	@RequestMapping("/clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") String id) {
	   return new ResponseEntity<Client>(clientService.getClient(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/clients/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteClientById(@PathVariable("id")String id){
		clientService.deleteClient(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"),HttpStatus.OK);
	}
	
	@RequestMapping(value="/clients", method=RequestMethod.POST)
	public ResponseEntity<StandardResponse> addClient(@RequestBody(required=true) Client client){
		clientService.addClient(client);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"),HttpStatus.OK);
	}
	
	@RequestMapping(value="/client/{id}", method=RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateClient(@RequestBody(required=true) Client client){
		clientService.updateEmployee(client);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"),HttpStatus.OK);
	}

	//FLEET SERVICE
	@RequestMapping("/fleets")
	public List<Fleet> getAllFleetData() {
		return fleetService.getAllFleets();
	}
	
	@RequestMapping("/fleets/{id}")
	public ResponseEntity<Fleet> getFleet(@PathVariable("id") String id){
		return new ResponseEntity<Fleet>(fleetService.getFleet(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="/fleets/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteFleetById(@PathVariable("id") String id){
		fleetService.deleteFleet(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"),HttpStatus.OK);
	}
	
	@RequestMapping(value="/fleets", method=RequestMethod.POST)
	public ResponseEntity<StandardResponse> addFleet(@RequestBody(required=true) Fleet fleet){
		fleetService.addFleet(fleet);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"),HttpStatus.OK);
	}

	@RequestMapping(value="/fleets/{id}", method=RequestMethod.PUT)
	public ResponseEntity<StandardResponse> updateFleet(@RequestBody(required=true) Fleet fleet){
		fleetService.updateFleet(fleet);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"),HttpStatus.OK);
	}
	
}












