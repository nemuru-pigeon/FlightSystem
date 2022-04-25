package com.example.flightsystem.entity.impl;

import com.example.flightsystem.entity.Meal;

public interface OrderImpl {
    void selectMeal(Meal meal);
    boolean selectSeat(String type, int location);
}
