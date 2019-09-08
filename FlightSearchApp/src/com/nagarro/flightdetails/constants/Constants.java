package com.nagarro.flightdetails.constants;
/**
 * Interface where all the constants used in the application,
 * are declared
 *
 */
public interface Constants {

	String PATH = "D:/Old_Flights";
	String INPUT_DEP_LOC = "Enter departure location:";
	String INPUT_ARR_LOC = "Enter arrival location:";
	String INPUT_DATE = "Enter date (DD-MM-YYYY):";
	String INPUT_CLASS = "Enter Class (E/B):";
	char SEAT_AVALABLE ='Y';
	String New_PATH = "D:/New_Flights";
	String SEARCH_STATUS="Press 1 to search flights:";
	String SEARCH_PREFERNCE="Please enter your search Preference:";
	String SORT_CHOICE= " 1 - Sort by flight fare , 2 - Sort by flight duration and fare (both)";
	String DUPLICATE_LOCATIONS="Arrival and Departure locations cannot be same !";
	String ALPHA_REG = "[a-zA-Z]+";
	String LOC_ERROR = "Entered location is not in correct format !!";
	String DEP_LOC_ERROR = "Flight from entered departure location not found !";
	String ARR_LOC_ERROR = "Flight to entered arrival location not found !";
	String CLASS_ERROR = "Entered class is not correct !";
	String NO_FLIGHT = "No Flight on entered date !";
	String IMPROPER_DATE = "Date not in appropriate(dd-MM-yyyy) format !";
	String DATE_FORMAT = "dd-MM-yyyy";
	String ECONOMY = "e";
	String BUSINESS = "b";
	String PRESS_ZERO = "Press 0 to try again. Press any other key to exit.";
	String HEADER_SPECIFIER = "%20s %20s %20s %20s %19s %20s";
	String DEPARTURE_HEADER ="DEPARTURE LOCATION";
	String ARRIVAL_HEADER = "ARRIVAL LOCATION";
	String CLASS_HEADER ="FLIGHT CLASS";
	String FARE_HEADER = "FLIGHT FARE";
	String DATE_HEADER = "FLIGHT DATE";
	String DURATION_HEADER = "FLIGHT DURATION";
	String TERMINATOR = "---------------------------------------------------------------------------------------------------------------------------------";
	String OUTPUT_SPECIFIER = "%12s %20s %22s %23.2f %22s %14s";

}
