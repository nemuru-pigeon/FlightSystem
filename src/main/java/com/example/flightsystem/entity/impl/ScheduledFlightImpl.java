package com.example.flightsystem.entity.impl;

import java.util.Date;

public interface ScheduledFlightImpl {
    String getFlightNo();
    Date getDepartureTime();
    Date getBoardingTime();
    String getDestination();
}
