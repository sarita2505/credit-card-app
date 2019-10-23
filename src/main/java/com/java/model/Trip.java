package com.java.model;

public class Trip {
    private String souece;
    private String destination;
    public Trip() {
    }

    public Trip(String souece, String destination) {
        this.souece = souece;
        this.destination = destination;
    }

    public String getSouece() {
        return souece;
    }

    public void setSouece(String souece) {
        this.souece = souece;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
