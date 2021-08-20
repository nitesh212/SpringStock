package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Buyer;
import com.dbs.web.beans.Seller;
import com.dbs.web.beans.Transaction;
import com.dbs.web.repository.BuyerInterface;
import com.dbs.web.repository.SellerInterface;
import com.dbs.web.repository.TransactionInterface;

import ch.qos.logback.core.net.SyslogOutputStream;


@Service
public class TransactionFinal {
	
	@Autowired
	private SellerService sellerservice;
	
	@Autowired
	private BuyerService buyerservice;
	
	@Autowired
	private SellerInterface selrepo;
	
	
	@Autowired
	private BuyerInterface buyerrepo;
	
	@Autowired
	private TransactionInterface transrepo;
	
	@Autowired
	private TransactionService transservice;
	
	public void buyerfinal(Buyer buyer) throws Exception {
		List <Seller> s = new ArrayList<Seller>();
		s = sellerservice.findSeller(buyer.getPriceinput(), buyer.getInstrument());
		int buyerquantity = buyer.getQuantity();
		
		for(Seller i : s) {
			if(buyerquantity>=i.getQuantity()) {
//				buyer.setQuantity(buyerquantity-i.getQuantity());\
				buyerquantity = buyerquantity - i.getQuantity();
				Transaction t = new Transaction();
				t.setBuyer(buyer.getClient());
				t.setSeller(i.getClient());
				t.setPrice(i.getPriceinput());
				t.setQuantity(i.getQuantity());
				t.setInstrument(i.getInstrument());
				this.transrepo.save(t);
				this.selrepo.delete(i);
				System.out.println("****************************");
			}

			else {
				if(buyerquantity != 0) {
				Transaction t = new Transaction();
				t.setBuyer(buyer.getClient());
				t.setSeller(i.getClient());
				t.setPrice(i.getPriceinput());
				t.setQuantity(buyerquantity);
				t.setInstrument(i.getInstrument());
				this.transservice.addTransaction(t);
				i.setQuantity(i.getQuantity()-buyerquantity);
				buyerquantity=0;
				this.selrepo.save(i);
				break;
				}
			}
					
		}
		if(buyerquantity!=0) {
			buyer.setQuantity(buyerquantity);
			this.buyerrepo.save(buyer);
		}
		
	}
	
	public void sellerfinal(Seller seller) throws Exception {
		List <Buyer> s = new ArrayList<Buyer>();
		s = buyerservice.findBuyer(seller.getPriceinput(), seller.getInstrument());
		int sellerquantity = seller.getQuantity();
		
		for(Buyer i : s ) {
			if(sellerquantity>=i.getQuantity()) {
//				buyer.setQuantity(buyerquantity-i.getQuantity());\
				sellerquantity = sellerquantity - i.getQuantity();
				Transaction t = new Transaction();
				t.setBuyer(i.getClient());
				t.setSeller(seller.getClient());
				t.setPrice(i.getPriceinput());
				t.setQuantity(i.getQuantity());
				t.setInstrument(i.getInstrument());
				this.transservice.addTransaction(t);
				this.buyerrepo.delete(i);
			}

			else {
				if(sellerquantity!=0 ) {
					Transaction t = new Transaction();
					t.setBuyer(i.getClient());
					t.setSeller(seller.getClient());
					t.setPrice(i.getPriceinput());
					t.setQuantity(sellerquantity);
					t.setInstrument(i.getInstrument());
					this.transservice.addTransaction(t);
					i.setQuantity(i.getQuantity()- sellerquantity);
					sellerquantity=0;
					this.buyerrepo.save(i);
					break;
				}
			}
					
		}
		if(sellerquantity!=0) {
			seller.setQuantity(sellerquantity);
			this.selrepo.save(seller);
		}
		
	}
	
	

}
