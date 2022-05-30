package com.example.flight_system.control;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InputControlTest {
    private final InputControl inputControl = new InputControl();

    @Test
    void readIdCard() {
        Map<String, String> result;
        result = inputControl.readIdCard();
        if (result != null) {
            assertEquals("305204200101015555", result.get("id"));
            assertEquals("San", result.get("givenName"));
            assertEquals("Zhang", result.get("surname"));
            assertEquals("M", result.get("gender"));
        } else {
            fail();
        }
    }
}