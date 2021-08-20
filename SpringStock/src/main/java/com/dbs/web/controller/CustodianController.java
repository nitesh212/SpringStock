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
import com.dbs.web.service.CustodianService;

@RestController
@CrossOrigin
@RequestMapping("/custodian")
public class CustodianController {
	
	@Autowired
	private CustodianService custodianservice;
	
	@GetMapping("/{custodian_id}")
	public ResponseEntity<Object> findClientByClientId(@PathVariable String custodian_id){
		try {
			return ResponseEntity.ok(this.custodianservice.findCustodianByCustodianId(custodian_id));
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
	}
	
	@GetMapping("/b/{custodian_id}")
	public ResponseEntity<Object> findClientByClientI(@PathVariable String custodian_id){
		try {
			return ResponseEntity.ok(this.custodianservice.findCustodianByCustodianI(custodian_id));
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
	}
	
	@GetMapping("/s/{custodian_id}")
	public ResponseEntity<Object> findClientByClient(@PathVariable String custodian_id){
		try {
			return ResponseEntity.ok(this.custodianservice.findCustodianByCustodian(custodian_id));
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
	}

	
}
