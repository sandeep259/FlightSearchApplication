package com.nagarro.flightdetails;

/**
 * Class to initialize the processing of application
 *
 */
public class FlightDetailsApp {

	/**
	 * Main function to start the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		try {
			Launcher launch = new Launcher();
			launch.launchapp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Application terminated...");
			System.exit(0);
		}

	}

}
