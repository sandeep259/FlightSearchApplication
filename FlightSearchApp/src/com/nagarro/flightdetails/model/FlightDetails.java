package com.nagarro.flightdetails.model;

import java.util.Comparator;
import java.util.Date;

/**
 * This is a pojo class for the FlightDetails application
 *
 */
public class FlightDetails implements Comparable<FlightDetails>{
	private String flightnum;
	private String dep_loc;
	private String arr_loc;
	private Date valid_till;
	private String flight_time;
	private String flight_dur;
	private double fare;
	private char seatavail;
	private String category;

	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = flightnum;
	}

	public String getDep_loc() {
		return dep_loc;
	}

	public void setDep_loc(String dep_loc) {
		this.dep_loc = dep_loc;
	}

	public String getArr_loc() {
		return arr_loc;
	}

	public void setArr_loc(String arr_loc) {
		this.arr_loc = arr_loc;
	}

	public Date getValid_till() {
		return valid_till;
	}

	public void setValid_till(Date valid_till) {
		this.valid_till = valid_till;
	}

	public String getFlight_time() {
		return flight_time;
	}

	public void setFlight_time(String flight_time) {
		this.flight_time = flight_time;
	}

	public String getFlight_dur() {
		return flight_dur;
	}

	public void setFlight_dur(String flight_dur) {
		this.flight_dur = flight_dur;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public char getSeatavail() {
		return seatavail;
	}

	public void setSeatavail(char seatavail) {
		this.seatavail = seatavail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int compareTo(FlightDetails arg0) {
		return (int)(this.getFare()-arg0.getFare());
	}




}
