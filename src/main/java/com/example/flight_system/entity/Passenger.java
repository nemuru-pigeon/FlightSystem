package com.example.flight_system.entity;

import com.example.flight_system.control.DataControl;
import com.example.flight_system.entity.impl.PassengerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Passenger implements PassengerImpl {
    private final DataControl dataControl = new DataControl();

    private String id;
    private String surname;
    private String givenName;
    private List<Order> orders;

    public Passenger(Map<String, String> passenger) {
        id = passenger.get("id");
        surname = passenger.get("surname");
        givenName = passenger.get("givenName");

        orders = new ArrayList<>();
        List<Map<String, String>> orderList = dataControl.getAllOrders();
        for (Map<String, String> orderMap : orderList) {
            if (orderMap.get("pid").equals(id) && orderMap.get("check_in_status").equals("false")) {
                orders.add(new Order(orderMap));
            }
        }
    }

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
