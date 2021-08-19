package com.dbs.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Instrument;

public interface InstrumentInterface extends CrudRepository<Instrument, String>{

}
