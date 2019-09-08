package com.nagarro.flightdetails;

import java.util.Vector;

import com.nagarro.flightdetails.model.FlightDetails;
import com.nagarro.flightdetails.services.FlightService;
import com.nagarro.flightdetails.services.InputService;
import com.nagarro.flightdetails.services.impl.FlightServiceImpl;
import com.nagarro.flightdetails.services.impl.InputServiceImpl;

/**
 * Class to always search for new files
 * 
 */
class SearchNewFiles implements Runnable {

	/**
	 * Function to run a thread which looks for new files to add in data_records
	 */

	@Override
	public void run() {
		while (true) {
			FlightService newfile = new FlightServiceImpl();
			newfile.addNewFlights();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

/**
 * Class to initialize the data_records vector
 *
 */
public class Launcher {

	/* Initialize vector */
	public static Vector<FlightDetails> data_records = new Vector<>();

	/**
	 * Function to launch the flight search application
	 */

	@SuppressWarnings("deprecation")
	public void launchapp() {
		FlightService flight = new FlightServiceImpl();
		flight.initializeAvailableFlights();
		SearchNewFiles search = new SearchNewFiles();
		Thread t1 = new Thread(search);
		t1.start();

		InputService input = new InputServiceImpl();
		input.enter();
		flight.search();
		t1.stop();
		

	}

}
