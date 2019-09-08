package com.nagarro.flightdetails.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.nagarro.flightdetails.Launcher;
import com.nagarro.flightdetails.constants.Constants;
import com.nagarro.flightdetails.services.ValidateService;

/**
 * Class to validate the input entered by user
 * 
 *
 */

public class ValidateServiceImpl implements ValidateService {

	/**
	 * Check if the entered date is in correct format or not
	 * 
	 * @param date
	 */

	@Override
	public void validatedate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT);

		Date userDate = null;
		try {
			userDate = formatter.parse(date);
			InputServiceImpl.entry.setFlightdate(validatedate(userDate));
		} catch (ParseException e) {
			System.err.println(Constants.IMPROPER_DATE);
			InputServiceImpl.entry.setValidation(false);
		}

	}

	/**
	 * Validate the input date with respect to date from data records
	 * 
	 * @param userDate
	 * @return Date
	 */

	private Date validatedate(Date userDate) {
		for (int j = 0; j < Launcher.data_records.size(); j++) {
			if (Launcher.data_records.get(j).getValid_till().equals(userDate)) {
				return userDate;
			}
		}
		System.err.println(Constants.NO_FLIGHT);
		InputServiceImpl.entry.setValidation(false);
		return null;

	}

	/**
	 * Check if the entered class preference is character or not
	 * 
	 * @param cls
	 * 
	 */

	@Override
	public void validatechar(String cls) {
		if (Pattern.matches(Constants.ALPHA_REG, cls) && cls.length() == 1
				&& (cls.equalsIgnoreCase(Constants.ECONOMY) || cls.equalsIgnoreCase(Constants.BUSINESS))) {
			if (validateClass(cls.toUpperCase())) {
				InputServiceImpl.entry.setClasspref(cls.toUpperCase());
			}
		} else {
			System.err.println(Constants.CLASS_ERROR);
			InputServiceImpl.entry.setValidation(false);
		}

	}

	/**
	 * Check if the entered class preference is valid or not.
	 * 
	 * @param upperCase
	 * @return boolean
	 */

	private boolean validateClass(String upperCase) {
		if (upperCase.contains("E") || upperCase.contains("B")) {
			return true;
		} else {
			System.err.println(Constants.CLASS_ERROR);
			return false;
		}
	}

	/**
	 * Check if entered input is string or not
	 * 
	 * @param str,i
	 */

	@Override
	public void validateString(String str, int i) {
		if (Pattern.matches(Constants.ALPHA_REG, str) && str.length() == 3) {
			if (i == 1) {
				validateDeparture(str);
			} else {
				validateArrival(str);
			}
		} else {
			System.err.println(Constants.LOC_ERROR);
			InputServiceImpl.entry.setValidation(false);
		}
	}

	/**
	 * Validate entered departure location with respect to data records
	 * 
	 * @param dep
	 * 
	 */
	public void validateDeparture(String dep) {
		boolean flag = false;
		for (int i = 0; i < Launcher.data_records.size(); i++) {
			if (Launcher.data_records.get(i).getDep_loc().equalsIgnoreCase(dep)) {
				InputServiceImpl.entry.setDeparture(dep);
				flag = true;
			}
		}
		if (!flag) {
			InputServiceImpl.entry.setValidation(false);
			System.err.println(Constants.DEP_LOC_ERROR);
		}
	}

	/**
	 * Validate arrival location with respect to data records
	 * 
	 * @param arr
	 *
	 */

	@Override
	public void validateArrival(String arr) {
		boolean flag = false;
		for (int i = 0; i < Launcher.data_records.size(); i++) {
			if (Launcher.data_records.get(i).getArr_loc().equalsIgnoreCase(arr)) {
				InputServiceImpl.entry.setArrival(arr);
				flag = true;
			}
		}
		if (!flag) {
			InputServiceImpl.entry.setValidation(false);
			System.err.println(Constants.ARR_LOC_ERROR);
		}
	}

	/**
	 * Check if two locations are duplicate or not
	 * @param dep
	 * @param arr
	 * @return
	 * 
	 */

	@Override
	public boolean checkDuplicate(String dep, String arr) {
		return dep.equalsIgnoreCase(arr);
	}

}
