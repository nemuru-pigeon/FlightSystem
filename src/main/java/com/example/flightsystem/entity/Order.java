package com.example.flightsystem.entity;

import com.example.flightsystem.entity.impl.OrderImpl;

public class Order implements OrderImpl {
    private String bookingNo;

    @Override
    public void selectMeal(Meal meal) {

    }

    @Override
    public boolean selectSeat(String type, int location) {
        return false;
    }
}
