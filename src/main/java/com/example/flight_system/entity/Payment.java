package com.example.flight_system.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Payment {
    private String id;
    private String detail;
    private Date date;
    private int price;

    public Payment(Map<String, String> payment) {
        id = payment.get("id");
        detail = payment.get("detail");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(payment.get("date"));
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        price = Integer.parseInt(payment.get("price"));
    }
    public String getDate() {
        return date;
}

public String getPrice() {
        return price;
}

public String getDetail() {
        return detail;
}

public String getpaymentId() {
        return id;
}
    
}
