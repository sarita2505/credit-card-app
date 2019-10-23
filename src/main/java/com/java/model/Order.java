package com.java.model;

public class Order {
    private int orderId;
    private String item;
    public Order() {
    }

    public Order(int orderId, String item) {
        this.orderId = orderId;
        this.item = item;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
