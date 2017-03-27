package com.pls.domain;

class ParkingLot {
    private int lotNumber;
    private Car car;

    ParkingLot(int lotNumber, Car car) {
        this.lotNumber = lotNumber;
        this.car = car;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public Car getCar() {
        return car;
    }
}
