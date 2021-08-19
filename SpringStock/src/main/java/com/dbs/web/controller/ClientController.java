package com.dbs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.response.ResponsePage;
import com.dbs.web.service.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService clientservice;
	
	@GetMapping("/{client_id}")
	public ResponseEntity<Object> findClientByClientId(@PathVariable String client_id){
		try {
			return ResponseEntity.ok(this.clientservice.findClientByClientId(client_id));
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
	}

}
