package com.dbs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.beans.Buyer;
import com.dbs.web.beans.Client;
import com.dbs.web.beans.Seller;
import com.dbs.web.repository.ClientRepository;
import com.dbs.web.response.ResponsePage;
import com.dbs.web.service.BuyerService;
import com.dbs.web.service.ClientService;
import com.dbs.web.service.SellerService;
import com.dbs.web.service.TransactionFinal;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class APIController {
	@Autowired
	private BuyerService buyerservice;
	@Autowired
	private SellerService sellerservice;
	@Autowired
	private TransactionFinal transfinal;
	@Autowired
	private ClientService clientservice;
	
	@PostMapping("/buyer")
	public ResponseEntity<ResponsePage> insertBuyer(
			@RequestBody Buyer buyer)
	{
		try {
			
			double k  = buyer.getPriceinput()*buyer.getQuantity();
			System.out.println(k);
			double kkk = buyer.getClient().getMaximum_transaction_limit();
			System.out.println(kkk);
			double kk = kkk - k;
			System.out.println(kk);
			Client c = buyer.getClient();
			c.setMaximum_transaction_limit(kk);
			this.clientservice.addTransaction(c);
			System.out.println(c);
			this.transfinal.buyerfinal(buyer);
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
			this.transfinal.sellerfinal(seller);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponsePage(201, "Transaction inserted"));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePage(400, e.getMessage()));
		}
	}
	
}
