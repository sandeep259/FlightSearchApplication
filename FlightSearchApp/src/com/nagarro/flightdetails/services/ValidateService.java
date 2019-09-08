package com.nagarro.flightdetails.services;
/**
 * Interface where all the validation methods
 * are declared
 */

public interface ValidateService {

	boolean checkDuplicate(String dep,String arr);
	
	void validatedate(String date);

	void validatechar(String cls);
	
	void validateString(String str,int i);
	
	void validateDeparture(String dep);
	
	void validateArrival(String arr);

}
