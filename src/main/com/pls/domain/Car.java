package com.pls.domain;

public class Car {
    private long registrationNumber;
    private String color;

    public Car(long registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }
}
