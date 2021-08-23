package com.dbs.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Custodian {
	@Id
	private String custodian_id;
	private String name;
	private String username;
	private String password;
	private String role;
	private boolean isActive;
	
	public Custodian() {
		System.out.println("Custodian Called!!!");
	}
	
	

	public Custodian(String custodian_id, String name, String password, String role, boolean isActive,String username) {
		super();
		this.custodian_id = custodian_id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
		this.username=username;
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
	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	@Override
	public String toString() {
		return "Custodian [custodian_id=" + custodian_id + ", name=" + name + ", password=" + password + "]";
	}
	
	

}
