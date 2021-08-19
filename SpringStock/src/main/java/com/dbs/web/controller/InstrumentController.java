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
import com.dbs.web.service.InstrumentService;

@RestController
@CrossOrigin
@RequestMapping("/instrument")
public class InstrumentController {
	@Autowired
	private InstrumentService instrumentservice;
	
	@GetMapping("/{instrument_id}")
	public ResponseEntity<Object> findInstrumentByInstrumentId(@PathVariable String instrument_id){
		try {
			return ResponseEntity.ok(this.instrumentservice.findInstrumentByInstrumentId(instrument_id));
		}
		catch(Exception e )
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
	}
	

}
