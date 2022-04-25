package com.example.flightsystem.entity;

import com.example.flightsystem.entity.impl.ScheduledFlightImpl;

import java.util.Date;

public class ScheduledFlight implements ScheduledFlightImpl {
    private String flightNo;
    private Date departureTime;
    private Date boardingTime;
    private String destination;

    @Override
    public String getFlightNo() {
        return flightNo;
    }

    @Override
    public Date getDepartureTime() {
        return departureTime;
    }

    @Override
    public Date getBoardingTime() {
        return boardingTime;
    }

    @Override
    public String getDestination() {
        return destination;
    }
}
