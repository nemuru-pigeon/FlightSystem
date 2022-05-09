package com.example.flight_system.entity;

import com.example.flight_system.entity.impl.FlightTypeImpl;

import java.util.Map;

public class FlightType implements FlightTypeImpl {
    private String type;
    private int[][] structure;

    public FlightType() {
    }

    public FlightType(Map<String, String> flightType) {
        type = flightType.get("type");
        structure = changeFormat(flightType.get("structure"));
    }

    private int[][] changeFormat(String from) {
        int length = from.length();
        int[][] to = new int[length/12][12];
        for (int i=0; i<length; i++) {
            to[i/12][i%12] = from.charAt(i);
        }
        return to;
    }

    @Override
    public int[][] getStructure() {
        return structure;
    }
}
