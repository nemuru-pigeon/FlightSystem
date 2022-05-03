package com.example.flight_system.entity;

import com.example.flight_system.control.DataControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Flight {
    private final DataControl dataControl = new DataControl();

    private String id;
    private FlightType type;

    public Flight(Map<String, String> flight) {
        id = flight.get("id");

        String flightType = flight.get("type");
        List<Map<String, String>> flightTypeList = dataControl.getAllFlightTypes();
        for (Map<String, String> flightTypeMap : flightTypeList) {
            if (flightTypeMap.get("type").equals(flightType)) {
                type = new FlightType(flightTypeMap);
                break;
            }
        }
    }
}
