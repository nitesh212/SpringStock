package com.dbs.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Client;
import com.dbs.web.beans.Transaction;
import com.dbs.web.repository.ClientRepository;
@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientrepo;
	
	public ClientService() {
		System.out.println("Client service");
	}
	
	public Client findClientByClientId(String client_id) throws Exception
	{
		Client client = null;
		try {

			Optional<Client> opt = this.clientrepo.findById(client_id);
			if(opt.isPresent())
				client = opt.get();
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("Client_id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return client;

	}
	

	public void addTransaction(Client client) throws Exception {
		try {
			this.clientrepo.save(client);
			
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
