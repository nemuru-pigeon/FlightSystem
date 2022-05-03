package com.example.flight_system.control;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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
    void getAllFlightTypes() {
        DataControl dataControl = new DataControl();
        List<Map<String, String>> result = dataControl.getAllFlightTypes();
        for (Map<String, String> map : result) {
            System.out.println(map.get("structure"));
            System.out.println(map.get("structure").length());
        }
    }
}