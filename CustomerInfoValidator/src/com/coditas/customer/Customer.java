package com.coditas.customer;

import java.util.Date;

public class Customer {
	private static int count = 0;
	private int customerId;
	private String  emailID;
	private String password;
	private Date dateOfBirth;

	public void CreateNewCustomer(String emailID, String password, Date dateOfBirth) {
		this.customerId = ++count;
		this.emailID = emailID;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	public int getCustomerId() {
		return this.customerId;
	}
	
	public String getEmailID() {
		return this.emailID;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}

