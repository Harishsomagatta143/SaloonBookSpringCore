package com.cg.saloon.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.cg.saloon.dto.Address;
import com.cg.saloon.dto.Customer;
import com.cg.saloon.dto.Saloon;

public class DBUtil {
	public static List<Saloon> sal=new ArrayList<Saloon>();
	public static List<Customer> cus=new ArrayList<Customer>();
	public static List<Customer> cusOne=new ArrayList<Customer>();
	public static Address adr=null;
static {
	adr=new Address("hyd","telangana",123654);
	Customer customer=new Customer(123,"harish","harish@gmail.com",new BigInteger("5454545465"));
	cus.add(customer);
	Customer customerOne=new Customer(124,"sai","sai@gmail.com",new BigInteger("878977"));
	cusOne.add(customerOne);
	
	
}
}
