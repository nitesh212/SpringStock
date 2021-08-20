package com.dbs.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Seller;
import com.dbs.web.beans.Transaction;
import com.dbs.web.repository.TransactionInterface;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionInterface transrepo;
	
	public void addTransaction(Transaction trans) throws Exception {
		try {
			this.transrepo.save(trans);
			
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(e);
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
	
	}
}
