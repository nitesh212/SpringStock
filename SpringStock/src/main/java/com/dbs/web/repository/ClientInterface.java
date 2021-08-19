package com.dbs.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Client;

public interface ClientInterface extends CrudRepository<Client, String>{

}
