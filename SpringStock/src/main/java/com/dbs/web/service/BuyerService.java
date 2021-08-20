package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Buyer;
import com.dbs.web.beans.Instrument;
import com.dbs.web.beans.Seller;
import com.dbs.web.repository.BuyerInterface;

@Service
public class BuyerService {
	
	@Autowired
	private BuyerInterface buyerrepo;
	
	public List<Buyer> findBuyer(double n, Instrument ins) {
		List<Buyer> collaterals = new ArrayList<Buyer>();
		this.buyerrepo.findByPriceinputAndInstrument(n, ins).forEach(collateral-> collaterals.add(collateral));
		return collaterals;
	}
	
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
