package com.example.flightsystem.control;

import com.example.flightsystem.VO.OrderInformation;
import com.example.flightsystem.VO.SeatSituation;
import com.example.flightsystem.control.impl.ControlImpl;
import com.example.flightsystem.entity.*;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Control implements ControlImpl {
    private Passenger passenger;
    private Order order;
    private List<Meal> meals;
    private Login login;

    @Override
    public boolean loginByBookingNo(String bookingNo) {
        return login.loginByBookingNo(bookingNo);
    }


    @Override
    public boolean loginBySurnameAndId(String surname, String id) {
        return login.loginBySurnameAndId(surname, id);

    }

    @Override
    public boolean loginById(String id) {
        return login.loginById(id);
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
        PrintInformation printInformation;
        printInformation = new PrintInformation();
        printInformation.setPassengerName(passenger.getGivenName() + " " + passenger.getSurname());
        printInformation.setPassengerId(passenger.getId());
        passengerOrder=passenger.getOrders();
        printInformation.setSeatClass(passengerOrder.getSeatClass());
        shift = passengerOrder.getShift();
        printInformation.setDate(shift.getDate());
        scheduledFlight = shift.getScheduledFlight();
        printInformation.setFlightNo(scheduledFlight.getFlightNo());
        printInformation.setDepartureTime(scheduledFlight.getDepartureTime());
        printInformation.setBoardingTime(scheduledFlight.getBoardingTime());
        printInformation.setDestination(scheduledFlight.getDestination());
        printInformation.setcarryOnBaggage(passengerOrder.getcarryOnBaggage);
        printInformation.setCheckInBaggage(passengerOrder.getCheckInBaggage);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("PrintInformation.txt"));
            out.write(printInformation);
            out.close();
            System.out.println("Successful！");
            return true;
        } catch (IOException e) {
            return false;
        }
}
