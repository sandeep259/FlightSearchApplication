package com.nagarro.flightdetails.model;

import java.util.Date;

public class UserInput {
	private String departure;
	private String arrival;
	private String classpref;
	private Date flightdate;
	private boolean validation=true;
	public boolean getValidation() {
		return validation;
	}
	public void setValidation(boolean validation) {
		this.validation = validation;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getClasspref() {
		return classpref;
	}
	public void setClasspref(String classpref) {
		this.classpref = classpref;
	}
	public Date getFlightdate() {
		return flightdate;
	}
	public void setFlightdate(Date flightdate) {
		this.flightdate = flightdate;
	}
	
}
