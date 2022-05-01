package com.example.flight_system.entity;

import com.example.flight_system.entity.impl.PassengerImpl;

import java.util.List;

public class Passenger implements PassengerImpl {
    private String id;
    private String surname;
    private String givenName;
    private List<Order> orders;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getGivenName() {
        return givenName;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public Order selectOrder(String bookingNo) {
        for (Order order : orders) {
            if (order.getBookingNo().equals(bookingNo)) {
                return order;
            }
        }
        return null;
    }
}
