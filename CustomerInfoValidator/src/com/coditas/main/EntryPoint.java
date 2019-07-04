package com.coditas.main;

import java.util.Scanner;

import com.coditas.customer.RegisterCustomer;
public class EntryPoint {
	
	public static void main(String args[]) {
		
		Scanner in = null;
		String passwd = null;
		String emailId = null;
	    String str[] = {"year", "month", "day" };
	    String date = "";

	    
		in = new Scanner(System.in);
		// Accept email
		System.out.println("Enter email");
		emailId = in.nextLine();
	
		// Accept password
		System.out.println("Enter password");
		passwd = in.nextLine();

		// Accept date
		System.out.println("Enter date of birth");
	    for(int i=0; i<3; i++) {
	        System.out.println("Enter " + str[i] + ": ");
	        date = date + in.next() + "/";
	    }
	    
	    date = date.substring(0, date.length()-1);		
		RegisterCustomer rc = new RegisterCustomer(emailId, passwd, date);
		//System.out.println("Customer Registered");

		in.close();
	}
}
