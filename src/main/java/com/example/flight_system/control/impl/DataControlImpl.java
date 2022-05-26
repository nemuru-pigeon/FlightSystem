package com.example.flight_system.control.impl;

import com.example.flight_system.entity.Order;
import com.example.flight_system.entity.Payment;
import com.example.flight_system.entity.Shift;

import java.util.List;
import java.util.Map;

public interface DataControlImpl {
    List<Map<String, String>> getAllPassengers();
    List<Map<String, String>> getAllOrders();
    List<Map<String, String>> getAllPayments();
    List<Map<String, String>> getAllMeals();
    List<Map<String, String>> getAllShifts();
    List<Map<String, String>> getAllScheduledFlights();
    List<Map<String, String>> getAllFlights();
    List<Map<String, String>> getAllFlightTypes();
    boolean updateOrder(Order order);
    boolean updatePayment(Payment payment);
    boolean updateShift(Shift shift);
}
