package com.example.flight_system.entity;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {

    @Test
    void changeFormat() {
        Shift shift = new Shift();
        Class<Shift> testedClass = Shift.class;

        try {
            Method method = testedClass.getDeclaredMethod("changeFormat", String.class);
            method.setAccessible(true);
            Object obj = method.invoke(shift, "10100");

            boolean[] result = (boolean[]) obj;
            boolean[] answer = {true, false, true, false, false};
            for (int i=0; i<5; i++) {
                assertEquals(answer[i], result[i]);
            }
        } catch (Exception e) {
            fail();
        }
    }
}