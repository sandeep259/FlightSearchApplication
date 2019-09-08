package com.nagarro.flightdetails.services.impl;

import java.util.Scanner;

import com.nagarro.flightdetails.constants.Constants;
import com.nagarro.flightdetails.model.UserInput;
import com.nagarro.flightdetails.services.InputService;
import com.nagarro.flightdetails.services.ValidateService;

/**
 * Class to take input from the user
 * 
 */

public class InputServiceImpl implements InputService {
	public static UserInput entry = new UserInput();
	ValidateService val = new ValidateServiceImpl();
	public static int choice;

	/**
	 * Function to take input from the user
	 * 
	 */
	@Override
	public void enter() {
		/* Take input from user */
		int i = 0, j = 0;
		Scanner scan = new Scanner(System.in);
		while (j == 0) {
			while (i != 1) {

				/* Input Departure and validate */
				System.out.println(Constants.INPUT_DEP_LOC);
				String dep = scan.next();
				val.validateString(dep, 1);
				if (InputServiceImpl.entry.getValidation() == false) {
					System.out.println(Constants.PRESS_ZERO);
					break;
				}

				/* Input arrival and validate */
				System.out.println(Constants.INPUT_ARR_LOC);
				String arr = scan.next();

				val.validateString(arr, 2);
				if (InputServiceImpl.entry.getValidation() == false) {
					System.out.println(Constants.PRESS_ZERO);
					break;
				}

				if (val.checkDuplicate(dep, arr)) {
					System.out.println(Constants.DUPLICATE_LOCATIONS);
					System.out.println(Constants.PRESS_ZERO);
					break;
				}
				System.out.println(Constants.INPUT_DATE);
				String date = scan.next();
				val.validatedate(date);

				/* Input class and validate */
				if (InputServiceImpl.entry.getValidation() == false) {
					System.out.println(Constants.PRESS_ZERO);
					break;
				}
				System.out.println(Constants.INPUT_CLASS);
				String cls = scan.next();
				val.validatechar(cls);
				if (InputServiceImpl.entry.getValidation() == false) {
					System.out.println(Constants.PRESS_ZERO);
					break;
				}
				entry.setValidation(true);
				System.out.println(Constants.SEARCH_PREFERNCE);
				System.out.println(Constants.SORT_CHOICE);
				choice = scan.nextInt();
				i = 1;
				j = 1;
			}
			if (j==0) {
				InputServiceImpl.entry = null;

				
				j = scan.nextInt();
				InputServiceImpl.entry = new UserInput();
			}
	
		}

	}

}
