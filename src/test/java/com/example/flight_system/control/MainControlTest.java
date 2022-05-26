package com.example.flight_system.control;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainControlTest {
    private MainControl mainControl = new MainControl();

    @Test
    void loginByBookingNo() {
        assertFalse(mainControl.loginByBookingNo("3052042001"));
        assertTrue(mainControl.loginByBookingNo("0101011111"));
        assertTrue(mainControl.loginByBookingNo("3072042001"));
        assertFalse(mainControl.loginByBookingNo("0010101550"));
    }

    @Test
    void loginBySurnameAndId() {
        assertTrue(mainControl.loginBySurnameAndId("San", "305204200101015555"));
    }

    @Test
    void loginById() {
        assertTrue(mainControl.loginById("305204200101015555"));
    }

    @Test
    void showOrders() {
    }

    @Test
    void selectOrder() {
    }

    @Test
    void showSeat() {
    }

    @Test
    void selectSeat() {
    }

    @Test
    void showNormalMeal() {
    }

    @Test
    void showExtraMeal() {
    }

    @Test
    void selectMeal() {
    }

    @Test
    void showPayment() {
    }

    @Test
    void pay() {
    }

    @Test
    void verifyId() {
    }

    @Test
    void updateDate() {
    }

    @Test
    void print() {
    }

    @Test
    void exitCheckIn() {
    }
}