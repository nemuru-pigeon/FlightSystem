package com.example.flight_system.control;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InputControlTest {
    private InputControl inputControl = new InputControl();

    @Test
    void readIdCard() {
        Map<String, String> result;
        result = inputControl.readIdCard();
        if (result != null) {
            System.out.println(result.get("id"));
            System.out.println(result.get("givenName"));
            System.out.println(result.get("surname"));
            System.out.println(result.get("gender"));
        } else {
            System.out.println("null!");
        }
    }
}