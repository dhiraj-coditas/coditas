package com.coditas.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import com.coditas.exceptions.CustomException;;
public class RegisterCustomer{
	
	public RegisterCustomer(String emailId, String passwrod, String date) {
		try {
			// Check null params
			if (emailId == null || passwrod == null || date == null) {
				throw new CustomException("Null Parameter");
			}
			
			// Check email id
			if (!isValidEmail(emailId)) {
				throw new CustomException("Invalid email id");
			}
			
			// Check password
			if (!isValidPassword(passwrod)) {
				String msg = "Invalid/Weak Password: Password should contain alpha numeric characters and *,#,$";
				throw new CustomException(msg);
			}
			
			// Check date of birth
			if (!isValidDate(date)) {
				throw new CustomException("Invalid date of birth");
			}

			Date dateOfBirth = createDateFromString(date);
			Customer c = new Customer();
			c.CreateNewCustomer(emailId, passwrod, dateOfBirth);
			System.out.println("Customer id: "+c.getCustomerId());
			System.out.println("Email id: "+c.getEmailID());
			System.out.println("Password: "+c.getPassword());
			System.out.println("Date of Birth: "+c.getDateOfBirth());
		}
		catch (CustomException ce) {
			System.out.println("Caught: "+ce);
		}

				
	}
	public boolean isValidEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{1,7}$";
                              
        if (email == null) 
            return false;
        int emailLength = email.length();
        if (emailLength < 7 || emailLength > 20)
        	return false;
        Pattern pat = Pattern.compile(emailRegex); 
        return pat.matcher(email).matches(); 
    }
	
	public boolean isValidPassword(String passwd) 
    {
		//String passRegex = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*#$]).{5,10})";
		String passRegex = "((?=.*[a-zA-Z0-9])(?=.*[*#$]).{5,10})";
        if (passwd == null)
            return false;
		Pattern pat = Pattern.compile(passRegex);
        return pat.matcher(passwd).matches(); 
    }

	public boolean isValidDate(String date) throws CustomException {
	    // Parse the input for actual date

	    Date startDate = createDateFromString("1985/01/01");
	    Date endDate = createDateFromString("1995/12/31");
	    Date dateOfBirth = createDateFromString(date);

		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(dateOfBirth);
		cal.getTime();
	    return !(dateOfBirth.before(startDate) || dateOfBirth.after(endDate));
	}
	
	public static Date createDateFromString(String str) throws CustomException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    Date parsedDate = null;

	    try {
	        parsedDate = dateFormat.parse(str);
	    } catch (ParseException e) {
	    	throw new CustomException("Parsing failed");
	    }
		
	    return parsedDate;
	}
}

