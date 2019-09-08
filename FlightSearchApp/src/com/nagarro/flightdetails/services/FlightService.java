package com.nagarro.flightdetails.services;

/**
 * Interface where all the flight service functions
 * are declared
 */
public interface FlightService {

	void initializeAvailableFlights();

	void search();

	void addNewFlights();

	double calculateFare(double fare);

}
