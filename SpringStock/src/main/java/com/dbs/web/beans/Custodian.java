package com.dbs.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Custodian {
	@Id
	private String custodian_id;
	private String name;
	private String password;
	
	public Custodian() {
		System.out.println("Custodian Called!!!");
	}
	public Custodian(String custodian_id, String name, String password) {
		super();
		this.custodian_id = custodian_id;
		this.name = name;
		this.password = password;
	}
	

	public String getCustodian_id() {
		return custodian_id;
	}
	public void setCustodian_id(String custodian_id) {
		this.custodian_id = custodian_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Custodian [custodian_id=" + custodian_id + ", name=" + name + ", password=" + password + "]";
	}
	
	

}
