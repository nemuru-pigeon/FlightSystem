package com.example.flightsystem.control;

import com.example.flightsystem.JavaBean.OrderInformation;
import com.example.flightsystem.JavaBean.SeatSituation;
import com.example.flightsystem.control.impl.ControlImpl;
import com.example.flightsystem.entity.Meal;
import com.example.flightsystem.entity.Order;
import com.example.flightsystem.entity.Passenger;
import com.example.flightsystem.entity.Payment;

import java.util.List;

public class Control implements ControlImpl {
    private Passenger passenger;
    private Order order;
    private List<Meal> meals;

    @Override
    public boolean loginByBookingNo(String bookingNo) {
        return false;
    }

    @Override
    public boolean loginBySurnameAndId(String surname, String id) {
        return false;
    }

    @Override
    public boolean loginById(String id) {
        return false;
    }

    @Override
    public List<OrderInformation> showOrders() {
        return null;
    }

    @Override
    public void selectOrder(String bookingNo) {

    }

    @Override
    public SeatSituation showSeat() {
        return null;
    }

    @Override
    public boolean selectSeat(String type, int location) {
        return false;
    }

    @Override
    public List<Meal> showNormalMeal() {
        return null;
    }

    @Override
    public List<Meal> showExtraMeal() {
        return null;
    }

    @Override
    public void selectMeal(int id) {

    }

    @Override
    public List<Payment> showPayment() {
        return null;
    }

    @Override
    public boolean pay(String cardNum, String vcc2Code) {
        return false;
    }

    @Override
    public boolean verifyId(String id) {
        return false;
    }

    @Override
    public boolean print() {
        return false;
    }
}
