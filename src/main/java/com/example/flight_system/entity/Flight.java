package com.example.flight_system.entity;

import com.example.flight_system.control.DataControl;
import com.example.flight_system.entity.impl.FlightImpl;

import java.util.List;
import java.util.Map;

public class Flight implements FlightImpl {
    private final DataControl dataControl = new DataControl();

    private String id;
    private FlightType type;

    /**
     * initialize by json data
     * @param flight the json data in Map<String, String> format
     */
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

    @Override
    public FlightType getType() {
        return type;
    }
}
