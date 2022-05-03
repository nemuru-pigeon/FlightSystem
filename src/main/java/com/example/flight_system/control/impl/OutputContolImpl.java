package com.example.flight_system.control.impl;

import java.util.Map;

public interface OutputContolImpl {
    boolean printBoardingPass(Map<String, String> passInf);
    boolean printTags(String bookingNo, String id, int num);
    boolean printTickets(String bookingNo, String id, int num);
}
