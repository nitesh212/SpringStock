package com.dbs.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Instrument;
import com.dbs.web.beans.Seller;

public interface SellerInterface extends CrudRepository<Seller, Integer>{
	public List<Seller> findByPriceinputAndInstrument(double priceinput, Instrument instrument);
}
