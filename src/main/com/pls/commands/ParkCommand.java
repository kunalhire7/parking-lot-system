package com.pls.commands;

import com.pls.domain.Car;
import com.pls.domain.ParkingLots;

public class ParkCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;

    public ParkCommand(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public String execute(String command) {
        String[] tokens = command.split(" ");
        String registrationNumber = tokens[1];
        String color = tokens[2];
        Car car = new Car(registrationNumber, color);
        return parkingLots.park(car);
    }
}
