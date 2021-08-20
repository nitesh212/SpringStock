package com.dbs.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Buyer;

public interface BuyerInterface extends CrudRepository<Buyer, Integer> {

}