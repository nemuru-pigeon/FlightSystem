package com.example.flightsystem.entity.impl;

import com.example.flightsystem.entity.Meal;
import com.example.flightsystem.entity.Shift;

public interface OrderImpl {
    String getBookingNo();
    char getSeatClass();
    Shift getShift();
    void selectMeal(Meal meal);
    boolean selectSeat(String type, int location);
}
