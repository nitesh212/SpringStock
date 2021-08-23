package com.dbs.web.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dbs.web.beans.Client;

public interface ClientRepository extends CrudRepository<Client, String>{
	@Query(nativeQuery = true, value = "select sum(price*quantity) from transaction t join client c on t.client_buyer = c.client_id where c.custodian_id = :custid ")
    double findAllByBuy(@Param("custid") String custid);
	
	@Query(nativeQuery = true, value = "select sum(price*quantity) from transaction t join client c on t.client_seller = c.client_id where c.custodian_id = :custid ")
    double findAllSell(@Param("custid") String custid);
}
