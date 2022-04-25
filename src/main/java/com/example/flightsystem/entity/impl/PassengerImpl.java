package com.example.flightsystem.entity.impl;

import com.example.flightsystem.entity.Order;

import java.util.List;

public interface PassengerImpl {
    String getId();
    String getSurname();
    String getGivenName();
    List<Order> getOrders();
    Order selectOrder(String bookingNo);
}
