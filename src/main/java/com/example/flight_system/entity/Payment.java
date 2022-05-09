package com.example.flight_system.entity;

import com.example.flight_system.entity.impl.PaymentImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Payment implements PaymentImpl {
    private String id;
    private String detail;
    private Date date;
    private float price;

    public Payment(Map<String, String> payment) {
        id = payment.get("id");
        detail = payment.get("detail");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            date = sdf.parse(payment.get("date"));
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        price = Float.parseFloat(payment.get("price"));
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDetail() {
        return detail;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
