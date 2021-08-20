package com.dbs.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Custodian;
import com.dbs.web.repository.ClientRepository;
import com.dbs.web.repository.CustodianRepository;

@Service
public class CustodianService {
	@Autowired
	private CustodianRepository custodianrepo;
	@Autowired
	private ClientRepository clientrepo;
	
	public CustodianService() {
		System.out.println("Custodian Service Running!!!");
	}
	
	public double findCustodianByCustodianI(String custodian_id) throws Exception
	{
		return clientrepo.findAllByBuy(custodian_id);
		
	}
	public double findCustodianByCustodian(String custodian_id) throws Exception
	{
		return clientrepo.findAllSell(custodian_id);
		
	}
	
	public Custodian findCustodianByCustodianId(String custodian_id) throws Exception
	{
		Custodian custodian = null;
		try {

			Optional<Custodian> opt = this.custodianrepo.findById(custodian_id);
			if(opt.isPresent())
				custodian = opt.get();
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("Custodian_id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return custodian;

	}

}
