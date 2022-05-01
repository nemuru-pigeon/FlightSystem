package com.example.flight_system.entity;

import com.example.flight_system.entity.impl.OrderImpl;

import java.util.List;

public class Order implements OrderImpl {
    private String bookingNo;
    private char seatClass;
    private int carryOnBaggage;
    private int checkInBaggage;
    private String seat;
    private Meal meal;
    private List<Payment> payments;
    private boolean checkInStatus;
    private Shift shift;

    @Override
    public String getBookingNo() {
        return bookingNo;
    }

    @Override
    public char getSeatClass() {
        return seatClass;
    }

    @Override
    public Shift getShift() {
        return shift;
    }

    @Override
    public void selectMeal(Meal meal) {

    }

    @Override
    public boolean selectSeat(String type, int location) {
        return false;
    }
}
