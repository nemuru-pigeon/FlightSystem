package com.example.flight_system.control;

import com.example.flight_system.VO.OrderInformation;
import com.example.flight_system.VO.SeatSituation;
import com.example.flight_system.control.impl.MainControlImpl;
import com.example.flight_system.entity.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainControl implements MainControlImpl {
    private final DataControl dataControl = new DataControl();
    private final OutputControl outputControl = new OutputControl();
    private Passenger passenger;
    private Order order;
    private List<Meal> meals;

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

    @Override
    public List<OrderInformation> showOrders() {
        List<OrderInformation> orderInformationList = new ArrayList<>();
        OrderInformation orderInformation;
        List<Order> orders = passenger.getOrders();
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

    @Override
    public boolean selectOrder(String bookingNo) {
        order = passenger.selectOrder(bookingNo);
        return order != null;
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
        List<Map<String, String>> passengerList = dataControl.getAllPassengers();
        for (Map<String, String> passengerMap : passengerList) {
            if (passengerMap.get("id").equals(id)) {
                return true;
            }
        }
        return false;
    }

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
}
