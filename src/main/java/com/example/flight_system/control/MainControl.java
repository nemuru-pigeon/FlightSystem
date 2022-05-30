package com.example.flight_system.control;

import com.example.flight_system.VO.MealInformation;
import com.example.flight_system.VO.OrderInformation;
import com.example.flight_system.VO.PaymentInformation;
import com.example.flight_system.VO.SeatSituation;
import com.example.flight_system.control.impl.MainControlImpl;
import com.example.flight_system.entity.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title      : MainControl.java
 * Description: This class designs the main control of the system.
 *
 * The main logic of the system is done by this class.
 *
 * @author Yuqi Zhang
 * @author Yudong Zhu
 * @author Hongjun Sheng
 * @author Yufei Wu
 * @version 5.0
 */
public class MainControl implements MainControlImpl {
    private final DataControl dataControl = new DataControl();
    private final OutputControl outputControl = new OutputControl();
    private Passenger passenger;
    private Order order;

    /**
     * login in by booking number
     * @param bookingNo the booking number of the order which the passenger
     *                  want to check in
     * @return whether the data are read correctly and the entities successfully initialised
     */
    @Override
    public boolean loginByBookingNo(String bookingNo) {
        List<Map<String, String>> orderList = dataControl.getAllOrders();
        String id = null;
        for (Map<String, String> orderMap : orderList) {
            if (orderMap.get("booking_no").equals(bookingNo)) {
                id = orderMap.get("pid");
                break;
            }
        }
        if (id == null) {
            return false;
        }

        return loginById(id) && selectOrder(bookingNo);
    }

    /**
     * login in by surname and ID
     * @param surname the surname of the passenger
     * @param id the ID of the passenger
     * @return whether the data are read correctly and the entities successfully initialised
     */
    @Override
    public boolean loginBySurnameAndId(String surname, String id) {
        List<Map<String, String>> passengerList = dataControl.getAllPassengers();
        for (Map<String, String> passengerMap : passengerList) {
            if (passengerMap.get("surname").equals(surname) && passengerMap.get("id").equals(id)) {
                passenger = new Passenger(passengerMap);
                return true;
            }
        }
        return false;
    }

    /**
     * login by ID
     * @param id the id of the passenger
     * @return whether the data are read correctly and the entities successfully initialised
     */
    @Override
    public boolean loginById(String id) {
        List<Map<String, String>> passengerList = dataControl.getAllPassengers();
        for (Map<String, String> passengerMap : passengerList) {
            if (passengerMap.get("id").equals(id)) {
                passenger = new Passenger(passengerMap);
                return true;
            }
        }
        return false;
    }

    /**
     * deliver all the messages needed in UI5, i.e. the page in which
     * passengers can select which order they want to check in
     * @return information to be shown
     */
    @Override
    public List<OrderInformation> showOrders() {
        List<OrderInformation> orderInformationList = new ArrayList<>();
        OrderInformation orderInformation;
        List<Order> orders;
        if (order != null) {
            orders = new ArrayList<>();
            orders.add(order);
        } else {
            orders = passenger.getOrders();
        }
        Shift shift;
        ScheduledFlight scheduledFlight;

        for (Order passengerOrder : orders) {
            orderInformation = new OrderInformation();
            orderInformation.setPassengerId(passenger.getId());
            orderInformation.setPassengerName(passenger.getGivenName() + " " + passenger.getSurname());
            orderInformation.setBookingNo(passengerOrder.getBookingNo());
            orderInformation.setSeatClass(passengerOrder.getSeatClass());
            shift = passengerOrder.getShift();
            orderInformation.setDate(shift.getDate());
            scheduledFlight = shift.getScheduledFlight();
            orderInformation.setFlightNo(scheduledFlight.getFlightNo());
            orderInformation.setDepartureTime(scheduledFlight.getDepartureTime());
            orderInformation.setBoardingTime(scheduledFlight.getBoardingTime());
            orderInformation.setDestination(scheduledFlight.getDestination());
            orderInformationList.add(orderInformation);
        }

        return orderInformationList;
    }

    /**
     * select the order which the passenger want to check in
     * @param bookingNo booking number of the order
     * @return whether the passenger successfully select the order
     */
    @Override
    public boolean selectOrder(String bookingNo) {
        order = passenger.selectOrder(bookingNo);
        return order != null;
    }

    /**
     * show the seat situation
     * @return information containing the seat situation
     */
    @Override
    public SeatSituation showSeat() {
        SeatSituation seatSituation = new SeatSituation();
        Shift shift = order.getShift();
        FlightType flightType = shift.getFlight().getType();

        seatSituation.setStructure(flightType.getStructure());
        seatSituation.setFirst(shift.getFirst());
        seatSituation.setBusiness(shift.getBusiness());
        seatSituation.setEconomy(shift.getEconomy());
        seatSituation.setCostlyEconomy(shift.getCostlyEconomy());

        return seatSituation;
    }

    /**
     * select the seat
     * @param type The type of seat selected. The range is first, business, economy and costly_economy.
     * @param location where the passenger select the seat
     * @return whether the passenger select the seat successfully
     */
    @Override
    public boolean selectSeat(String type, int location) {
        return order.selectSeat(type, location);
    }

    /**
     * obtain the type of the seat
     * @return the type of the seat. Return type is char because it is the initial of the four types
     */
    @Override
    public char getSeatClass() {
        return order.getSeatClass();
    }

    /**
     * obtain the type of the flight
     * @return the type of the flight
     */
    @Override
    public String getFlightType() {
        return order.getShift().getFlight().getType().getType();
    }

    /**
     * display all meals that don't need extra cost
     * @return information of meals that don't need extra cost
     */
    @Override
    public List<MealInformation> showNormalMeal() {
        List<MealInformation> normalMeals = new ArrayList<>();
        MealInformation mealInformation;

        List<Map<String, String>> mealList = dataControl.getAllMeals();
        for (Map<String, String> mealMap : mealList) {
            if (mealMap.get("price").equals("0.00")) {
                mealInformation = new MealInformation();
                mealInformation.setId(mealMap.get("id"));
                mealInformation.setName(mealMap.get("name"));
                normalMeals.add(mealInformation);
            }
        }

        return normalMeals;
    }

    /**
     * display all meals that need extra cost
     * @return information of meals that need extra cost
     */
    @Override
    public List<MealInformation> showExtraMeal() {
        List<MealInformation> extraMeals = new ArrayList<>();
        MealInformation mealInformation;

        List<Map<String, String>> mealList = dataControl.getAllMeals();
        for (Map<String, String> mealMap : mealList) {
            if (!mealMap.get("price").equals("0.00")) {
                mealInformation = new MealInformation();
                mealInformation.setId(mealMap.get("id"));
                mealInformation.setName(mealMap.get("name"));
                mealInformation.setPrice(Float.parseFloat(mealMap.get("price")));
                extraMeals.add(mealInformation);
            }
        }

        return extraMeals;
    }

    /**
     * select the meal
     * @param id the id of the meal
     * @return whether the meal is selected successfully
     */
    @Override
    public boolean selectMeal(String id) {
        return order.selectMeal(id);
    }

    /**
     * show all payments
     * @return information of the payments
     */
    @Override
    public List<PaymentInformation> showPayment() {
        List<PaymentInformation> paymentInformationList = new ArrayList<>();
        PaymentInformation paymentInformation;
        List<Payment> payments = order.getPayments();

        for (Payment payment : payments) {
            paymentInformation = new PaymentInformation();
            paymentInformation.setId(payment.getId());
            paymentInformation.setDate(payment.getDate());
            paymentInformation.setDetail(payment.getDetail());
            paymentInformation.setPrice(payment.getPrice());
            paymentInformationList.add(paymentInformation);
        }

        return paymentInformationList;
    }

    /**
     * the pay action
     * @param cardNum the number of the bank card
     * @param vcc2Code the VCC2 code of the bank card
     * @param amount the amount of money
     * @return whether the pay action is successful
     */
    @Override
    public boolean pay(String cardNum, int vcc2Code, float amount) {
        return outputControl.pay(cardNum, vcc2Code, amount);
    }

    /**
     * the passenger verify (conform) the ID
     * @param id the ID of the passenger
     * @return whether the passenger verify the ID successfully
     */
    @Override
    public boolean verifyId(String id) {
        return passenger.getId().equals(id);
    }

    /**
     * update the data to the json files
     * @return whether update successfully
     */
    @Override
    public boolean updateDate() {
        boolean result = dataControl.updateOrder(order);
        for (Payment payment : order.getPayments()) {
            result = result && dataControl.updatePayment(payment);
        }
        return result;
    }

    /**
     * print the boarding pass, the tickets and the tags
     * @return whether the print action is successful
     */
    @Override
    public boolean print() {
        Map<String, String> passInf = new HashMap<>();
        Shift shift = order.getShift();
        ScheduledFlight scheduledFlight = shift.getScheduledFlight();
        String bookingNo = order.getBookingNo();
        String id = passenger.getId();
        passInf.put("booking_no", bookingNo);
        passInf.put("flight", scheduledFlight.getFlightNo());
        passInf.put("seat", order.getSeat());
        passInf.put("class", String.valueOf(order.getSeatClass()));
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf1.format(shift.getDate());
        passInf.put("date", dateString);
        passInf.put("from", scheduledFlight.getPlaceOfDeparture());
        passInf.put("to", scheduledFlight.getDestination());
        passInf.put("name", passenger.getGivenName() + " " + passenger.getSurname());
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        String departureTimeString = sdf2.format(scheduledFlight.getDepartureTime());
        passInf.put("departure time", departureTimeString);

        boolean result = outputControl.printBoardingPass(passInf);
        int carryOnBaggage = order.getCarryOnBaggage();
        int checkInBaggage = order.getCheckInBaggage();
        if (carryOnBaggage != 0) {
            result = result && outputControl.printTags(bookingNo, id, carryOnBaggage);
        }
        if (checkInBaggage != 0) {
            result = result && outputControl.printTickets(bookingNo, id, checkInBaggage);
        }

        return result;
    }

    /**
     * If the operator quits without finish the hole process,
     * the reserved seat needs to be cancelled.
     * @return whether the reserved seat is successfully cancelled
     */
    @Override
    public boolean exitCheckIn() {
        return order.getShift().cancelSeatSelection();
    }
}
