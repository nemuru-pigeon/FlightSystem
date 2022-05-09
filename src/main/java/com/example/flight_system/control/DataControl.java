package com.example.flight_system.control;

import com.example.flight_system.control.impl.DataControlImpl;
import com.example.flight_system.entity.Shift;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
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

    @Override
    public boolean updateData(String path, List<Map<String, String>> newData) {
        File file = new File(path);
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writer(new DefaultPrettyPrinter()).writeValue(file, newData);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String booleanArrToString(boolean[] array) {
        StringBuilder resultBuilder = new StringBuilder();
        for (boolean entry : array) {
            if (entry) {
                resultBuilder.append(1);
            } else {
                resultBuilder.append(0);
            }
        }
        return resultBuilder.toString();
    }

    @Override
    public boolean updateShift(Shift shift) {
        List<Map<String, String>> shiftList = getAllShifts();
        String id = shift.getId();
        for (Map<String, String> shiftMap : shiftList) {
            if (shiftMap.get("id").equals(id)) {
                shiftMap.put("first", booleanArrToString(shift.getFirst()));
                shiftMap.put("business", booleanArrToString(shift.getBusiness()));
                shiftMap.put("economy", booleanArrToString(shift.getEconomy()));
                shiftMap.put("costlyEconomy", booleanArrToString(shift.getCostlyEconomy()));
                break;
            }
        }
        String path = filesPath + "shift.json";
        return updateData(path, shiftList);
    }
}
