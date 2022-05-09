package com.example.flight_system.entity.impl;

import com.example.flight_system.entity.Flight;
import com.example.flight_system.entity.ScheduledFlight;

import java.util.Date;

public interface ShiftImpl {
    String getId();
    Date getDate();
    boolean[] getFirst();
    boolean[] getBusiness();
    boolean[] getEconomy();
    boolean[] getCostlyEconomy();
    ScheduledFlight getScheduledFlight();
    Flight getFlight();
    boolean updateSeatSituation(String type, int location);
}
