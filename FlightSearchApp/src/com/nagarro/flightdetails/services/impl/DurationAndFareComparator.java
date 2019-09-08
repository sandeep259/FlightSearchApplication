package com.nagarro.flightdetails.services.impl;
import com.nagarro.flightdetails.model.*;
import java.util.Comparator;

public class DurationAndFareComparator implements Comparator<FlightDetails> {

	@Override
	public int compare(FlightDetails arg0, FlightDetails arg1) {
		int res=(int)(arg0.getFare()-arg1.getFare());
		if(res==0) {
			if(Float.parseFloat(arg0.getFlight_dur())<Float.parseFloat(arg1.getFlight_dur())) {
				return -1;
			}else if(Float.parseFloat(arg0.getFlight_dur())>Float.parseFloat(arg1.getFlight_dur())) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return res;
		}
	}

}
