package com.example.flight_system.entity.impl;

import com.example.flight_system.entity.Order;

import java.util.List;

public interface PassengerImpl {
    String getId();
    String getSurname();
    String getGivenName();
    List<Order> getOrders();
    Order selectOrder(String bookingNo);
}
