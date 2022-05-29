package com.example.flight_system.control;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DataControlTest {

    @Test
    void getAllPassenger() {
        DataControl dataControl = new DataControl();
        List<Map<String, String>> result = dataControl.getAllPassengers();
        System.out.println(result);
        for (Map<String, String> map : result) {
            System.out.println(map.get("id"));
            System.out.println(map.get("surname"));
            System.out.println(map.get("givenName"));
            System.out.println(map.get("givenName").getClass());
        }
    }

    @Test
    void getAllOrders() {
        DataControl dataControl = new DataControl();
        List<Map<String, String>> result = dataControl.getAllOrders();
        System.out.println(result);
        for (Map<String, String> map : result) {
            System.out.println(map.get("class"));
            System.out.println(map.get("class").getClass());
            System.out.println(map.get("meal"));
            System.out.println(map.get("meal").getClass());
            System.out.println(map.get("check_in_status"));
            System.out.println(map.get("check_in_status").getClass());
        }
    }

    @Test
    void getAllPayment() {
        DataControl dataControl = new DataControl();
        List<Map<String, String>> result = dataControl.getAllPayments();
        for (Map<String, String> map : result) {
            System.out.println(map.get("price"));
            System.out.println(Float.parseFloat(map.get("price")));
        }
    }

    @Test
    void getAllMeals() {
        DataControl dataControl = new DataControl();
        List<Map<String, String>> result = dataControl.getAllMeals();
        for (Map<String, String> map : result) {
            System.out.println(map.get("id"));
        }
    }

    @Test
    void getAllFlightTypes() {
        DataControl dataControl = new DataControl();
        List<Map<String, String>> result = dataControl.getAllFlightTypes();
        for (Map<String, String> map : result) {
            System.out.println(map.get("structure"));
            System.out.println(map.get("structure").length());
        }
    }

    @Test
    void updateData() {
        DataControl dataControl = new DataControl();
        List<Map<String, String>> shiftList = dataControl.getAllShifts();
        for (Map<String, String> shiftMap : shiftList) {
            if (shiftMap.get("id").equals("221204WH2156")) {
                shiftMap.put("first", "11011101");
                break;
            }
        }
        String path = "src/main/resources/com/example/flight_system/data/" + "test.json";

        dataControl.updateData(path, shiftList);
    }

    @Test
    void updatePayment() {
        DecimalFormat df = new DecimalFormat("#0.00");
        float num1 = 0;
        float num2 = 10;
        float num3 = 1;
        float num4 = 15;
        assertEquals("0.00", df.format(num1));
        assertEquals("10.00", df.format(num2));
        assertEquals("1.00", df.format(num3));
        assertEquals("15.00", df.format(num4));
    }

    @Test
    void booleanArrToString() {
        DataControl dataControl = new DataControl();
        Class<DataControl> testedClass = DataControl.class;
        boolean[] input = {true, false, true, false, false};
        String answer = "10100";

        try {
            Method method = testedClass.getDeclaredMethod("booleanArrToString", boolean[].class);
            method.setAccessible(true);
            Object obj = method.invoke(dataControl, new Object[]{input});
            String result = obj.toString();
            assertEquals(answer, result);
        } catch (Exception e) {
            fail();
        }
    }
}