package com.dbs.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Buyer;
import com.dbs.web.beans.Instrument;

public interface BuyerInterface extends CrudRepository<Buyer, Integer> {
	public List<Buyer> findByPriceinputAndInstrument(double priceinput, Instrument instrument);

}