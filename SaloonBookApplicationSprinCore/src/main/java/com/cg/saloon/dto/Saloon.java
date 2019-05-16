/*@Author hsomagat
*Project name:SaloonBookApplication
*  This is saloon class where set saloon details
*/

package com.cg.saloon.dto;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(value="prototype")
public class Saloon {
	
	private int id;
	private String name;
	@Autowired
	private Address address; 
	private BigInteger phoneNumber; 
	@Autowired
	private  List<Customer> customerList;
	
	public Saloon(int id, String name, Address address, BigInteger phoneNumber,List<Customer> customerList) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.customerList = customerList;
	}
	public Saloon() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	@Override
	public String toString() {
		return "Saloon [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ",customerList=" + customerList + "]";
	}
	

	
	
}
