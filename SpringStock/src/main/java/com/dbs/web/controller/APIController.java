package com.dbs.web.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.beans.Buyer;
import com.dbs.web.beans.Seller;
import com.dbs.web.response.ResponsePage;
import com.dbs.web.service.BuyerService;
import com.dbs.web.service.SellerService;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class APIController {
	@Autowired
	private BuyerService buyerservice;
	@Autowired
	private SellerService sellerservice;
	
	@PostMapping("/buyer")
	public ResponseEntity<ResponsePage> insertBuyer(
			@RequestBody Buyer buyer)
	{
		try {
			this.buyerservice.addBuyer(buyer);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponsePage(201, "Transaction inserted"));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
	}
	
	@PostMapping("/seller")
	public ResponseEntity<ResponsePage> insertSeller(
			@RequestBody Seller seller)
	{
		try {
			this.sellerservice.addSeller(seller);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponsePage(201, "Transaction inserted"));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
	}
	
}
