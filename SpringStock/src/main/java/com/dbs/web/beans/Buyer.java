package com.dbs.web.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int buyer_id;
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	private double price_input;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="instrument_id")
	private Instrument instrument;
	
	public Buyer() {
		// TODO Auto-generated constructor stub
	}
	
	public Buyer(Client client, double price_input, int quantity, Instrument instrument) {
		super();
		this.client = client;
		this.price_input = price_input;
		this.quantity = quantity;
		this.instrument = instrument;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public double getPrice_input() {
		return price_input;
	}
	public void setPrice_input(double price_input) {
		this.price_input = price_input;
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
	@Override
	public String toString() {
		return "Buyer [client=" + client + ", price_input=" + price_input + ", quantity=" + quantity + ", instrument="
				+ instrument + "]";
	}
	
	

}
