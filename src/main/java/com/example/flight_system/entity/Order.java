package com.example.flight_system.entity;

import com.example.flight_system.control.DataControl;
import com.example.flight_system.entity.impl.OrderImpl;

import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * initialize by json data
     * @param order the json data in Map<String, String> format
     */
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
    public int getCarryOnBaggage() {
        return carryOnBaggage;
    }

    @Override
    public int getCheckInBaggage() {
        return checkInBaggage;
    }

    @Override
    public String getSeat() {
        return seat;
    }

    @Override
    public Meal getMeal() {
        return meal;
    }

    @Override
    public List<Payment> getPayments() {
        return payments;
    }

    @Override
    public Shift getShift() {
        return shift;
    }

    /**
     * select the meal and record the selection
     * @param id the id of the meal
     * @return whether the selection is successful
     */
    @Override
    public boolean selectMeal(String id) {
        List<Map<String, String>> mealList = dataControl.getAllMeals();
        for (Map<String, String> mealMap : mealList) {
            if (mealMap.get("id").equals(id)) {
                meal = new Meal(mealMap);

                for (Payment payment : payments) {
                    if (payment.getId().equals(bookingNo + "ME")) {
                        payments.remove(payment);
                        break;
                    }
                }

                if (!mealMap.get("price").equals("0.00")) {
                    // add a new payment
                    Map<String, String> paymentMap = new HashMap<>();
                    Date date = new Date();

                    paymentMap.put("id", bookingNo + "ME");
                    paymentMap.put("detail", "Choose extra payed meal");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    paymentMap.put("date", sdf.format(date));
                    paymentMap.put("price", mealMap.get("price"));

                    Payment payment = new Payment(paymentMap);
                    payments.add(payment);
                }

                return true;
            }
        }
        return false;
    }

    /**
     * select the seat and record the selection
     * @param type The type of seat selected. The range is first, business, economy and costly_economy.
     * @param location where the passenger select the seat
     * @return whether the passenger select the seat successfully
     */
    @Override
    public boolean selectSeat(String type, int location) {
        for (Payment payment : payments) {
            if (payment.getId().equals(bookingNo + "SE")) {
                payments.remove(payment);
                break;
            }
        }

        // record the location of the seat
        int typeInt;
        switch (type) {
            case "first":
                typeInt = 49;
                break;
            case "business":
                typeInt = 50;
                break;
            case "economy":
                typeInt = 51;
                break;
            case "costlyEconomy":
                typeInt = 52;

                // add a new payment
                Map<String, String> paymentMap = new HashMap<>();
                Date date = new Date();

                paymentMap.put("id", bookingNo + "SE");
                paymentMap.put("detail", "Choose extra payed seat");
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                paymentMap.put("date", sdf1.format(date));
                paymentMap.put("price", "5.0");

                Payment payment = new Payment(paymentMap);
                payments.add(payment);

                break;
            default:
                return false;
        }
        int[][] structure = shift.getFlight().getType().getStructure();
        int count = 0;
        int rowNum = structure.length;
        int columnNum = structure[0].length;
        label1:
        for (int i=0; i<rowNum; i++) {
            for (int j=0; j<columnNum; j++) {
                if (structure[i][j] == typeInt) {
                    count++;
                }
                if (count == location) {
                    int columnCount = 0;
                    for (int k=0; k<j; k++) {
                        if (structure[i][k] != 48) {
                            columnCount++;
                        }
                    }
                    seat = String.format("%02d", (i+1)) + (char) ('A'+columnCount);
                    break label1;
                }
            }
        }

        // change the seating situation on the same flight
        return shift.updateSeatSituation(type, location);
    }
}
