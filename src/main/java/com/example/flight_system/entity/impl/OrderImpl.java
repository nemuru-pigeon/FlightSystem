package com.example.flight_system.entity.impl;

import com.example.flight_system.entity.Meal;
import com.example.flight_system.entity.Payment;
import com.example.flight_system.entity.Shift;

import java.util.List;

public interface OrderImpl {
    String getBookingNo();
    char getSeatClass();
    int getCarryOnBaggage();
    int getCheckInBaggage();
    String getSeat();
    Meal getMeal();
    List<Payment> getPayments();
    Shift getShift();
    boolean selectMeal(String id);
    boolean selectSeat(String type, int location);
}
