package com.example.flight_system.entity.impl;

import com.example.flight_system.entity.Meal;
import com.example.flight_system.entity.Shift;

public interface OrderImpl {
    String getBookingNo();
    char getSeatClass();
    int getCarryOnBaggage();
    int getCheckInBaggage();
    String getSeat();
    Shift getShift();
    void selectMeal(Meal meal);
    boolean selectSeat(String type, int location);
}
