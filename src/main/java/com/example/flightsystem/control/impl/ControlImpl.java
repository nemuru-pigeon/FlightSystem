package com.example.flightsystem.control.impl;

import com.example.flightsystem.JavaBean.OrderInformation;
import com.example.flightsystem.JavaBean.SeatSituation;
import com.example.flightsystem.entity.Meal;
import com.example.flightsystem.entity.Payment;

import java.util.List;

public interface ControlImpl {
    boolean loginByBookingNo(String bookingNo);
    boolean loginBySurnameAndId(String surname, String id);
    boolean loginById(String id);
    List<OrderInformation> showOrders();
    void selectOrder(String bookingNo);
    SeatSituation showSeat();
    boolean selectSeat(String type, int location);
    List<Meal> showNormalMeal();
    List<Meal> showExtraMeal();
    void selectMeal(int id);
    List<Payment> showPayment();
    boolean pay(String cardNum, String vcc2Code);
    boolean verifyId(String id);
    boolean print();
}
