package com.example.flight_system.entity;

import com.example.flight_system.control.DataControl;
import com.example.flight_system.entity.impl.OrderImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order implements OrderImpl {
    private final DataControl dataControl = new DataControl();

    private String bookingNo;
    private char seatClass;
    private int carryOnBaggage;
    private int checkInBaggage;
    private String seat;
    private Meal meal;
    private List<Payment> payments;
    private boolean checkInStatus = false;
    private Shift shift;

    public Order(Map<String, String> order) {
        bookingNo = order.get("booking_no");
        seatClass = order.get("class").charAt(0);
        carryOnBaggage = Integer.parseInt(order.get("carry_on_baggage"));
        checkInBaggage = Integer.parseInt(order.get("check_in_baggage"));

        payments = new ArrayList<>();
        List<Map<String, String>> paymentList = dataControl.getAllPayments();
        for (Map<String, String> paymentMap : paymentList) {
            if (paymentMap.get("booking_no").equals(bookingNo)) {
                payments.add(new Payment(paymentMap));
                break;
            }
        }

        String shiftId = order.get("shift_id");
        List<Map<String, String>> shiftList = dataControl.getAllShifts();
        for (Map<String, String> shiftMap : shiftList) {
            if (shiftMap.get("id").equals(shiftId)) {
                shift = new Shift(shiftMap);
                break;
            }
        }
    }

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
