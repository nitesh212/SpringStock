package com.dbs.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Buyer;
import com.dbs.web.repository.BuyerInterface;

@Service
public class BuyerService {
	
	@Autowired
	private BuyerInterface buyerrepo;
	
	public boolean addBuyer(Buyer buyer) throws Exception {
		try {
				
			this.buyerrepo.save(buyer);
			
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return true;
	}
	
}
