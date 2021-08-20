package com.dbs.web.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seller_id;
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	private double priceinput;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="instrument_id")
	private Instrument instrument;
	
	public Seller() {
		// TODO Auto-generated constructor stub
	}
	
	public Seller(Client client, double priceinput, int quantity, Instrument instrument) {
		super();
		this.client = client;
		this.priceinput = priceinput;
		this.quantity = quantity;
		this.instrument = instrument;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public double getPriceinput() {
		return priceinput;
	}
	public void setPriceinput(double priceinput) {
		this.priceinput = priceinput;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	
}
