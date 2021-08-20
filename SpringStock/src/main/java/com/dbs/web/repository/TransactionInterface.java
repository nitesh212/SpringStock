package com.dbs.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Transaction;

public interface TransactionInterface extends CrudRepository<Transaction, Integer> {

}
