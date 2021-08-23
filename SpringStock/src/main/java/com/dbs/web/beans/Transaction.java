package com.dbs.web.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction;
	@ManyToOne
	@JoinColumn(name="client_seller")
	private Client seller;
	@ManyToOne
	@JoinColumn(name="client_buyer")
	private Client buyer;
	private double price;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "instrument_id")
	private Instrument instrument;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Transaction(int transaction, Client seller, Client buyer, double price, int quantity,
			Instrument instrument) {
		super();
		this.transaction = transaction;
		this.seller = seller;
		this.buyer = buyer;
		this.price = price;
		this.quantity = quantity;
		this.instrument = instrument;
	}



	public Instrument getInstrument() {
		return instrument;
	}



	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}



	public int getTransaction() {
		return transaction;
	}

	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}

	public Client getSeller() {
		return seller;
	}

	public void setSeller(Client seller) {
		this.seller = seller;
	}

	public Client getBuyer() {
		return buyer;
	}

	public void setBuyer(Client buyer) {
		this.buyer = buyer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
