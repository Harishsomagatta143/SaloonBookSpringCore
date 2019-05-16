/*@Author hsomagat
*Project name:SaloonBookApplication
*  This project is about adding saloon and assign customer to saloon
   
* This is userinterface class.abstract
*  Where user is adding saloon details,customer details and fetching those details.class
*/

package com.cg.saloon.ui;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.cg.saloon.config.JavaConfig;
import com.cg.saloon.dto.Address;
import com.cg.saloon.dto.Customer;
import com.cg.saloon.dto.Saloon;
import com.cg.saloon.exception.SaloonNotFoundException;
import com.cg.saloon.service.SaloonService;
import com.cg.saloon.service.SaloonServiceImpl;
import com.cg.saloon.util.DBUtil;
@Component
public class MyApplication {
	
	static SaloonService saloonService;
	
	
	@Autowired
	SaloonService service;
	
	@PostConstruct
	public void init() {
	MyApplication.saloonService =service;
	}
 
	@Autowired
	public static void main(String[] args)   {
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Scanner scr=new Scanner(System.in);
		
		List<Customer>custlist=new ArrayList<Customer>();
			int choice=0;
			
	        int id;
			int saloonId = 0;
			String name;
			String address;
		
			do {
		
				System.out.println("Enter the choice");
				System.out.println("1.add saloon \n2.saloon searchbyname");
				choice=scr.nextInt();
			int customerId = 0;
			switch(choice) {

			case 1:         
							//******Adding saloon*********
				  
				try {
					List<Saloon> saloons=new ArrayList<Saloon>();
				
					
					System.out.println("Enter saloon id: ");
					int id1=scr.nextInt();
					System.out.println("Enter saloon Name: ");
					name=scr.next();
					
					System.out.println("Enter saloon phonenumber: ");
					BigInteger phnumber=scr.nextBigInteger();
					System.out.println("Enter city: ");
					String city=scr.next();
					System.out.println("Enter state: ");
					String state=scr.next();
					System.out.println("Enter postalcode: ");
					Long postalcode=scr.nextLong();
					
					Address adr=(Address) app.getBean("address");
					adr.setCity(city);
					adr.setState(state);
					adr.setPostalcode(postalcode);
	
					//*****Assigning customer details to saloon****
					
					System.out.println("enter customer id");
					int id2=scr.nextInt();
					System.out.println("enter customer emailid");
					String emailid=scr.next();
					System.out.println("enter customer mobilenumber");
					BigInteger mobilenumber=scr.nextBigInteger();
					System.out.println("enter customer name");
					String name1=scr.next();
					Customer cust=(Customer) app.getBean("customer");
					
					
					cust.setId(id2);
					cust.setEmailId(emailid);
					cust.setName(name1);
					cust.setMobileNumber(mobilenumber);
					System.out.println(cust);
					custlist.add(cust);
					Saloon sal=(Saloon) app.getBean("saloon");
				
					
					sal.setId(id1);
					sal.setName(name);
					sal.setPhoneNumber(mobilenumber);
					sal.setAddress(adr);
					sal.setCustomerList(custlist);
			
						System.out.println( saloonService.addSaloon(sal));
					} catch (SaloonNotFoundException e1) {
						
						System.out.println(e1.getMessage());		
						}
					 
					    break;

			case 2:   
				try {
				List<Saloon>myList=new ArrayList<Saloon>();
				System.out.println("Enter saloon name: ");
				String name1 = scr.next();
	           myList=saloonService.searchByName(name1);
	   
	           		System.out.println(myList);//print myList
			
				
				} catch (SaloonNotFoundException e) {
					System.out.println(e.getLocalizedMessage());				
}
				 
             
				break;

			case 3:  

				//break;
			}
		}while(choice!=3);



	}
}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				