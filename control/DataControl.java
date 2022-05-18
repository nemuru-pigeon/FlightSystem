package com.example.flight_system.control;

import com.example.flight_system.control.impl.DataControlImpl;
import com.example.flight_system.entity.Order;
import com.example.flight_system.entity.Payment;
import com.example.flight_system.entity.Shift;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public List<Map<String, String>> getAllMeals() {
        String path = filesPath + "meal.json";
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

    @Override
    public boolean updateOrder(Order order) {
        List<Map<String, String>> orderList = getAllOrders();
        String bookingNo = order.getBookingNo();
        for (Map<String, String> shiftMap : orderList) {
            if (shiftMap.get("booking_no").equals(bookingNo)) {
                shiftMap.put("check_in_status", String.valueOf(order.isCheckInStatus()));
                break;
            }
        }
        String path = filesPath + "order_test.json";
//        String path = filesPath + "order.json";
        return updateData(path, orderList);
    }

    @Override
    public boolean updatePayment(Payment payment) {
        List<Map<String, String>> shiftList = getAllShifts();
        String id = payment.getId();
        for (Map<String, String> paymentMap : shiftList) {
            if (paymentMap.get("id").equals(id)) {
                DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:MM");
                String format = dateFormat.format(payment.getDate());
                paymentMap.put("date", format);
                paymentMap.put("detail", payment.getDetail());
                paymentMap.put("price", String.valueOf(payment.getPrice()));
                break;
            }
        }
//        String path = filesPath + "payment.json";
        String path = filesPath + "payment_test.json";
        return updateData(path, shiftList);
    }
}
