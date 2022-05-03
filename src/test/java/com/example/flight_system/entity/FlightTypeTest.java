package com.example.flight_system.entity;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class FlightTypeTest {

    @Test
    void changeFormat() {
        FlightType flightType = new FlightType();
        Class<FlightType> testedClass = FlightType.class;

        try {
            Method method = testedClass.getDeclaredMethod("changeFormat", String.class);
            method.setAccessible(true);
            Object obj = method.invoke(flightType, "000110011000000110011000002220022200002220022200002220022200002220022200002220022200002220022200004440044400003330033300");

            int[][] result = (int[][]) obj;
            System.out.println("row: " + result.length + "column: " + result[0].length);
            for (int[] ints : result) {
                for (int j = 0; j < 12; j++) {
                    System.out.print(ints[j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            fail();
        }
    }
}