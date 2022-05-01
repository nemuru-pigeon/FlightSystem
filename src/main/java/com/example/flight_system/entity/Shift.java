package com.example.flight_system.entity;

import com.example.flight_system.entity.impl.ShiftImpl;

import java.util.Date;

public class Shift implements ShiftImpl {
    private Date date;
    private ScheduledFlight scheduledFlight;

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public ScheduledFlight getScheduledFlight() {
        return scheduledFlight;
    }
}
