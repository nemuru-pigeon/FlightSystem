package com.example.flight_system.entity;

import com.example.flight_system.entity.impl.ScheduledFlightImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ScheduledFlight implements ScheduledFlightImpl {
    private String flightNo;
    private Date departureTime;
    private Date boardingTime;
    private String destination;

    public ScheduledFlight(Map<String, String> scheduledFlight) {
        flightNo = scheduledFlight.get("flight_no");

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            departureTime = sdf.parse(scheduledFlight.get("departure_time"));
            boardingTime = sdf.parse(scheduledFlight.get("boarding_time"));
        } catch (ParseException e) {
            e.printStackTrace();
            departureTime = null;
            boardingTime = null;
        }

        destination = scheduledFlight.get("destination");
    }

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
