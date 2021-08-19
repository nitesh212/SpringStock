package com.dbs.web.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instrument {
	@Id
	private String instrument_id;
	private String instrument_name;
	private int face_value;
	private LocalDate expiry_date;
	private int min_quantity;
	public Instrument(String instrument_id, String instrument_name, int face_value, LocalDate expiry_date,
			int min_quantity) {
		super();
		this.instrument_id = instrument_id;
		this.instrument_name = instrument_name;
		this.face_value = face_value;
		this.expiry_date = expiry_date;
		this.min_quantity = min_quantity;
	}
	public String getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(String instrument_id) {
		this.instrument_id = instrument_id;
	}
	public String getInstrument_name() {
		return instrument_name;
	}
	public void setInstrument_name(String instrument_name) {
		this.instrument_name = instrument_name;
	}
	public int getFace_value() {
		return face_value;
	}
	public void setFace_value(int face_value) {
		this.face_value = face_value;
	}
	public LocalDate getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}
	public int getMin_quantity() {
		return min_quantity;
	}
	public void setMin_quantity(int min_quantity) {
		this.min_quantity = min_quantity;
	}
	@Override
	public String toString() {
		return "Instrument [instrument_id=" + instrument_id + ", instrument_name=" + instrument_name + ", face_value="
				+ face_value + ", expiry_date=" + expiry_date + ", min_quantity=" + min_quantity + "]";
	}
	
	
	

}
