package com.example.flight_system.entity.impl;

import com.example.flight_system.entity.Meal;
import com.example.flight_system.entity.Shift;

public interface OrderImpl {
    String getBookingNo();
    char getSeatClass();
    Shift getShift();
    void selectMeal(Meal meal);
    boolean selectSeat(String type, int location);
}
