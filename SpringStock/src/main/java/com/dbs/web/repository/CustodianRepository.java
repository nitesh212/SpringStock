package com.dbs.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Custodian;

public interface CustodianRepository extends CrudRepository<Custodian, String>{
	public Optional<Custodian> findCustodianByUsername(String username);
}
