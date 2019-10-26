package com.java.model;

public class CreditCard {
    private int id;
    private long cardNumber;
    private String cardName;
    private String cardType;
    private int year;
    private int month;
    private int cvv;

    public CreditCard() {
    }

    public CreditCard(int id, int cardNumber, String cardName, String cardType, int year, int month, int cvv) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardType = cardType;
        this.year = year;
        this.month = month;
        this.cvv = cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
