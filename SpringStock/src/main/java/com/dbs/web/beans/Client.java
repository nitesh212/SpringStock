package com.dbs.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Client {
	@Id
	private String client_id;
	private String cilent_name;
	private double maximum_transaction_limit;
	
	@ManyToOne
	@JoinColumn(name="custodian_id")
	private Custodian custodian_id;

	public Client() {
		System.out.println("Client is Called!!!");
	}
	public Client(String client_id, String cilent_name, double maximum_transaction_limit, Custodian custodian_id) {
		super();
		this.client_id = client_id;
		this.cilent_name = cilent_name;
		this.maximum_transaction_limit = maximum_transaction_limit;
		this.custodian_id = custodian_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getCilent_name() {
		return cilent_name;
	}

	public void setCilent_name(String cilent_name) {
		this.cilent_name = cilent_name;
	}

	public double getMaximum_transaction_limit() {
		return maximum_transaction_limit;
	}

	public void setMaximum_transaction_limit(double maximum_transaction_limit) {
		this.maximum_transaction_limit = maximum_transaction_limit;
	}

	public Custodian getCustodian_id() {
		return custodian_id;
	}

	public void setCustodian_id(Custodian custodian_id) {
		this.custodian_id = custodian_id;
	}

	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", cilent_name=" + cilent_name + ", maximum_transaction_limit="
				+ maximum_transaction_limit + ", custodian_id=" + custodian_id + "]";
	}
	
	

}
