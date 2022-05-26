package com.example.flight_system.control.impl;

import com.example.flight_system.VO.MealInformation;
import com.example.flight_system.VO.OrderInformation;
import com.example.flight_system.VO.PaymentInformation;
import com.example.flight_system.VO.SeatSituation;
import com.example.flight_system.entity.Meal;
import com.example.flight_system.entity.Payment;

import java.util.List;

public interface MainControlImpl {
    boolean loginByBookingNo(String bookingNo);
    boolean loginBySurnameAndId(String surname, String id);
    boolean loginById(String id);
    List<OrderInformation> showOrders();
    boolean selectOrder(String bookingNo);
    SeatSituation showSeat();
    boolean selectSeat(String type, int location);
    List<MealInformation> showNormalMeal();
    List<MealInformation> showExtraMeal();
    boolean selectMeal(String id);
    List<PaymentInformation> showPayment();
    boolean pay(String cardNum, int vcc2Code, float amount);
    boolean verifyId(String id);
    boolean updateDate();
    boolean print();
    boolean exitCheckIn();
}
