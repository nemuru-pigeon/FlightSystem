package com.example.flight_system.entity;

import java.util.Map;

public class Meal {
    private String mealName;
    private String bookingNo;
    //1是收费，0免费
    private int isFree;
    private double price;

    public Meal() {
    }

    public Meal(Map<String, String> meal) {
        mealName = meal.get("meal_name");
        bookingNo = meal.get("booking_no");
        price = Double.parseDouble(meal.get("price"));
        isFree = Double.parseDouble(meal.get("price")) <= 0 ? 0 : 1;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getIsFree() {
        return isFree;
    }

    public void setIsFree(int isFree) {
        this.isFree = isFree;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }
}
