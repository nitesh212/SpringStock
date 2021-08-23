package com.dbs.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Instrument;
import com.dbs.web.repository.InstrumentRepository;

@Service
public class InstrumentService {
	
	@Autowired
	private InstrumentRepository instrumentrepo;
	
	public InstrumentService() {
		System.out.println("Instrument is Running!!!");
	}
	
	public Instrument findInstrumentByInstrumentId(String instrument_id) throws Exception
	{
		Instrument instrument = null;
		try {

			Optional<Instrument> opt = this.instrumentrepo.findById(instrument_id);
			if(opt.isPresent())
				instrument = opt.get();
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("Instrument_id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return instrument;

	}
	

}
