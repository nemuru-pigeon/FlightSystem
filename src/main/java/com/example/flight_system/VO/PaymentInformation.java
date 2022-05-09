package com.example.flight_system.VO;

import java.io.Serializable;
import java.util.Date;

public class PaymentInformation implements Serializable {
    private String id;
    private String detail;
    private Date date;
    private float price;

    public PaymentInformation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PaymentInformation{" +
                "id='" + id + '\'' +
                ", detail='" + detail + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
