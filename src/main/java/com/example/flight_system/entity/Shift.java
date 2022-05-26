package com.example.flight_system.entity;

import com.example.flight_system.control.DataControl;
import com.example.flight_system.entity.impl.ShiftImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Shift implements ShiftImpl {
    private final DataControl dataControl = new DataControl();

    private String id;
    private Date date;
    private boolean[] first;
    private boolean[] business;
    private boolean[] economy;
    private boolean[] costlyEconomy;
    private ScheduledFlight scheduledFlight;
    private Flight flight;
    private String changedType;
    private boolean[] oldSeat;

    public Shift() {
    }

    public Shift(Map<String, String> shift) {
        id = shift.get("id");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(shift.get("date"));
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }

        first = changeFormat(shift.get("first"));
        business = changeFormat(shift.get("business"));
        economy = changeFormat(shift.get("economy"));
        costlyEconomy = changeFormat(shift.get("costly_economy"));

        String flightNo = shift.get("flight_no");
        List<Map<String, String>> scheduledFlightList = dataControl.getAllScheduledFlights();
        for (Map<String, String> scheduledFlightMap : scheduledFlightList) {
            if (scheduledFlightMap.get("flight_no").equals(flightNo)) {
                scheduledFlight = new ScheduledFlight(scheduledFlightMap);
                break;
            }
        }
        String flightId = shift.get("flight_id");
        List<Map<String, String>> flightList = dataControl.getAllFlights();
        for (Map<String, String> flightMap : flightList) {
            if (flightMap.get("id").equals(flightId)) {
                flight = new Flight(flightMap);
                break;
            }
        }
    }

    private boolean[] changeFormat(String from) {
        int length = from.length();
        boolean[] to = new boolean[length];
        for (int i=0; i<length; i++) {
            to[i] = from.charAt(i) != '0';
        }
        return to;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public boolean[] getFirst() {
        return first;
    }

    @Override
    public boolean[] getBusiness() {
        return business;
    }

    @Override
    public boolean[] getEconomy() {
        return economy;
    }

    @Override
    public boolean[] getCostlyEconomy() {
        return costlyEconomy;
    }

    @Override
    public ScheduledFlight getScheduledFlight() {
        return scheduledFlight;
    }

    @Override
    public Flight getFlight() {
        return flight;
    }

    @Override
    public boolean updateSeatSituation(String type, int location) {
        changedType = type;
        switch (type) {
            case "first":
                oldSeat = first;
                first[location-1] = true;
                break;
            case "business":
                oldSeat = business;
                business[location-1] = true;
                break;
            case "economy":
                oldSeat = economy;
                economy[location-1] = true;
                break;
            case "costlyEconomy":
                oldSeat = costlyEconomy;
                costlyEconomy[location-1] = true;
                break;
            default:
                return false;
        }

        // keep the seat occupied to avoid that people choose the same seat at the same time
        return dataControl.updateShift(this);
    }

    @Override
    public boolean cancelSeatSelection() {
        if (changedType == null) {
            return true;
        }

        switch (changedType) {
            case "first":
                first = oldSeat;
                break;
            case "business":
                business = oldSeat;
                break;
            case "economy":
                economy = oldSeat;
                break;
            case "costlyEconomy":
                costlyEconomy = oldSeat;
                break;
            default:
                return false;
        }

        // cancel the seat selection
        return dataControl.updateShift(this);
    }
}
