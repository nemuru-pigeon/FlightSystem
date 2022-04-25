package com.example.flightsystem.JavaBean;

import java.io.Serializable;
import java.util.Date;

public class OrderInformation implements Serializable {
    private String bookingNo;
    private String passengerName;
    private String passengerId;
    private String flightNo;
    private Character seatClass;
    private Date departureTime;
    private Date boardingTime;
    private String destination;

    public OrderInformation() {
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Character getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(Character seatClass) {
        this.seatClass = seatClass;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(Date boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "FlightInformation{" +
                "bookingNo='" + bookingNo + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", seatClass=" + seatClass +
                ", departureTime=" + departureTime +
                ", boardingTime=" + boardingTime +
                ", destination='" + destination + '\'' +
                '}';
    }
}
