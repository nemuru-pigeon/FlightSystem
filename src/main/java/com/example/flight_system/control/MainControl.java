package com.example.flight_system.control;

import com.example.flight_system.VO.OrderInformation;
import com.example.flight_system.VO.SeatSituation;
import com.example.flight_system.control.impl.MainControlImpl;
import com.example.flight_system.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainControl implements MainControlImpl {
    private final DataControl dataControl = new DataControl();
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
        return false;
    }

    @Override
    public boolean print() {
//        PrintInformation printInformation;
//        printInformation = new PrintInformation();
//        printInformation.setPassengerName(passenger.getGivenName() + " " + passenger.getSurname());
//        printInformation.setPassengerId(passenger.getId());
//        passengerOrder = passenger.getOrders();
//        printInformation.setSeatClass(passengerOrder.getSeatClass());
//        shift = passengerOrder.getShift();
//        printInformation.setDate(shift.getDate());
//        scheduledFlight = shift.getScheduledFlight();
//        printInformation.setFlightNo(scheduledFlight.getFlightNo());
//        printInformation.setDepartureTime(scheduledFlight.getDepartureTime());
//        printInformation.setBoardingTime(scheduledFlight.getBoardingTime());
//        printInformation.setDestination(scheduledFlight.getDestination());
//        printInformation.setcarryOnBaggage(passengerOrder.getcarryOnBaggage);
//        printInformation.setCheckInBaggage(passengerOrder.getCheckInBaggage);
//        try {
//            BufferedWriter out = new BufferedWriter(new FileWriter("PrintInformation.txt"));
//            out.write(printInformation);
//            out.close();
//            System.out.println("Successful！");
//            return true;
//        } catch (IOException e) {
//            return false;
//        }
        return false;
    }
}
