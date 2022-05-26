package com.example.flight_system.entity;

import com.example.flight_system.entity.impl.MealImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meal implements MealImpl {
    private String id;
    private String name;
    private float price;

    public Meal(Map<String, String> meal) {
        id = meal.get("id");
        name = meal.get("name");
        price = Float.parseFloat(meal.get("price"));
    }

    @Override
    public String getId() {
        return id;
    }
}
