package com.example.flight_system.control.impl;

import java.util.List;
import java.util.Map;

public interface DataControlImpl {
    List<Map<String, String>> getMaps(String path);
    List<Map<String, String>> getAllPassengers();
    List<Map<String, String>> getAllOrders();
    List<Map<String, String>> getAllPayments();
    List<Map<String, String>> getAllShifts();
    List<Map<String, String>> getAllScheduledFlights();
    List<Map<String, String>> getAllFlights();
    List<Map<String, String>> getAllFlightTypes();
}
