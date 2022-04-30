package com.example.flightsystem.entity.impl;

public interface LoginImpl {

	    boolean loginByBookingNo(String bookingNo);
	    boolean loginBySurnameAndId(String surname, String id);
	    boolean loginById(String id);
	    
}
