package com.example.flight_system.control;

import com.example.flight_system.control.impl.DataControlImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

public class DataControl implements DataControlImpl {
    private final String filesPath = "src/main/resources/com/example/flight_system/data/";

    @Override
    public List<Map<String, String>> getMaps(String path) {
        List<Map<String, String>> result;

        File file = new File(path);
        ObjectMapper mapper=new ObjectMapper();
        TypeReference<List<Map<String, String>>> typeRef = new TypeReference<>() {};
        try {
            result = mapper.readValue(file, typeRef);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }

    @Override
    public List<Map<String, String>> getAllPassengers() {
        String path = filesPath + "passenger.json";
        return getMaps(path);
    }

    @Override
    public List<Map<String, String>> getAllOrders() {
        String path = filesPath + "order.json";
        return getMaps(path);
    }

    @Override
    public List<Map<String, String>> getAllPayments() {
        String path = filesPath + "payment.json";
        return getMaps(path);
    }

    @Override
    public List<Map<String, String>> getAllShifts() {
        String path = filesPath + "shift.json";
        return getMaps(path);
    }

    @Override
    public List<Map<String, String>> getAllScheduledFlights() {
        String path = filesPath + "scheduled_flight.json";
        return getMaps(path);
    }

    @Override
    public List<Map<String, String>> getAllFlights() {
        String path = filesPath + "flight.json";
        return getMaps(path);
    }

    @Override
    public List<Map<String, String>> getAllFlightTypes() {
        String path = filesPath + "flight_type.json";
        return getMaps(path);
    }
}
