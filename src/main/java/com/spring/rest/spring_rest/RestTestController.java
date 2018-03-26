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

	@RequestMapping("/clients")
	public List<Client> getAllClientData() {
		return clientService.getallClients();
	}
	
	@RequestMapping("/clients/{id}")
	public ResponseEntity<Client> get(@PathVariable("id") String id) {
	   return new ResponseEntity<Client>(clientService.getClient(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/clients/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StandardResponse> deleteEmpById(@PathVariable("id")Integer id){
		clientService.deleteClient(id);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"),HttpStatus.OK);
	}
	
	@RequestMapping(value="/clients", method=RequestMethod.POST)
	public ResponseEntity<StandardResponse> addEmp(@RequestBody(required=true) Client client){
		clientService.addClient(client);
		return new ResponseEntity<StandardResponse>(new StandardResponse("OK"),HttpStatus.OK);
	}
}











