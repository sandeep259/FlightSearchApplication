package com.nagarro.flightdetails.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Vector;
import java.util.regex.Pattern;
import com.nagarro.flightdetails.Launcher;
import com.nagarro.flightdetails.constants.Constants;
import com.nagarro.flightdetails.model.FlightDetails;
import com.nagarro.flightdetails.services.FlightService;

/**
 * Class to provide flight related functionalities like populate data,
 *  calculate fare of flights
 */
public class FlightServiceImpl implements FlightService{

	/**
	 *  Function to initialize the transfer of data file to data_records
	 *    
	 */

	@Override
	public void initializeAvailableFlights() {
		File folder = new File(Constants.PATH);

		File[] files = folder.listFiles();

		for (File file : files)

		{
			populate(file, Launcher.data_records);
		}

	}

	/**
	 * Function to add new flights in the data_records
	 */

	@Override
	public synchronized void addNewFlights() {
		File folder = new File(Constants.New_PATH);

		File[] files = folder.listFiles();

		for (File file : files)

		{
			populate(file, Launcher.data_records);
			file.renameTo(new File(Constants.PATH+file.getName()));
		}

	}

	/**
	 * Transfer the data of file to data_records
	 * @param file
	 * @param data_records
	 */
	private void populate(File file, Vector<FlightDetails> data_records) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			br.readLine();
			String line = null;

			while ((line = br.readLine()) != null) {

				FlightDetails fileList = new FlightDetails();
				String[] list = line.split(Pattern.quote("|"));
				int a = 0;
				fileList.setFlightnum(list[a++]);
				fileList.setDep_loc(list[a++]);
				fileList.setArr_loc(list[a++]);
				SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT);
				try {
					fileList.setValid_till(formatter.parse(list[a++]));
				} catch (ParseException e) {

					e.printStackTrace();
				}
				fileList.setFlight_time(list[a++]);
				fileList.setFlight_dur(list[a++]);
				fileList.setFare(Double.parseDouble(list[a++]));
				fileList.setSeatavail(list[a++].charAt(0));
				fileList.setCategory(list[a++]);

				if (CheckDuplicateUtil(fileList, data_records) == false) {
					data_records.add(fileList);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Check if any record is present multiple times in the data records or not
	 * @param fileList
	 * @param data_records
	 * @return
	 */
	private boolean CheckDuplicateUtil(FlightDetails fileList, Vector<FlightDetails> data_records) {
		for (int j = 0; j < data_records.size(); j++) {
			if (data_records.get(j).getFlightnum().equals(fileList.getFlightnum())
					&& data_records.get(j).getValid_till().equals(fileList.getValid_till())
					&& data_records.get(j).getFlight_time().equals(fileList.getFlight_time())) {
				return true;
			} else
				continue;
		}
		return false;
	}

	/**
	 * Function to search the entered input in the data records
	 * 
	 */

	@Override
	public void search() {
		Vector<FlightDetails> result=new Vector<>();
		for(FlightDetails f:Launcher.data_records) {
			if(f.getDep_loc().equalsIgnoreCase(InputServiceImpl.entry.getDeparture()) && 
					f.getArr_loc().equalsIgnoreCase(InputServiceImpl.entry.getArrival()) && 
					(f.getCategory().contains(InputServiceImpl.entry.getClasspref())) &&
					f.getValid_till().compareTo(InputServiceImpl.entry.getFlightdate())<=0 &&
					f.getSeatavail()==Constants.SEAT_AVALABLE) {
				f.setFare(calculateFare(f.getFare()));
				result.add(f);

			}

		}
		if(InputServiceImpl.choice==1) {
			Collections.sort(result);
		}else {
			Collections.sort(result,new DurationAndFareComparator());
		}

		SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT);
		System.out.println(Constants.TERMINATOR);
		System.out.printf(Constants.HEADER_SPECIFIER, Constants.DEPARTURE_HEADER , Constants.ARRIVAL_HEADER , Constants.CLASS_HEADER , Constants.FARE_HEADER , Constants.DATE_HEADER , Constants.DURATION_HEADER);
		System.out.println();
		System.out.println(Constants.TERMINATOR);
		result.forEach(f->{
			System.out.format(Constants.OUTPUT_SPECIFIER,f.getDep_loc() , f.getArr_loc() , InputServiceImpl.entry.getClasspref() , f.getFare() , formatter.format(f.getValid_till()) , f.getFlight_dur());
			System.out.println();
		});
		System.out.println(Constants.TERMINATOR);
	}

	/**
	 * Function to calculate the fare of flight
	 * @param fare
	 * @return double 
	 */

	@Override
	public double calculateFare(double fare) {
		if(InputServiceImpl.entry.getClasspref().equalsIgnoreCase("b")) {
			return (0.4*fare) + fare;
		}else {
			return fare;
		}
	} 




}
