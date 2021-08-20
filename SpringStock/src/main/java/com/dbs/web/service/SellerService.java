package com.dbs.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Seller;
import com.dbs.web.repository.SellerInterface;

@Service
public class SellerService {
	
	@Autowired
	private SellerInterface sellerrepo;
	
	public boolean addSeller(Seller seller) throws Exception {
		try {
			this.sellerrepo.save(seller);
			
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
