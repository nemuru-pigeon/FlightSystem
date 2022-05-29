package com.example.flight_system.boundary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ui3ControllerTest {
    private boolean formatJudge(String bookingnum) {
        return bookingnum.length() == 10 && bookingnum.matches("[0-9]+");
    }

    @Test
    void tonext() {
        assertFalse(formatJudge("111111111"));
        assertTrue(formatJudge("1111111111"));
        assertFalse(formatJudge("11111111111"));

        assertFalse(formatJudge("1111a11111"));
    }
}