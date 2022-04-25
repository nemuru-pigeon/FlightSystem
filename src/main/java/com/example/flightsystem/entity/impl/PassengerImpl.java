package com.example.flightsystem.entity.impl;

import com.example.flightsystem.entity.Order;

public interface PassengerImpl {
    Order selectOrder(String bookingNo);
}
