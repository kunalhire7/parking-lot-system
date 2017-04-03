package com.pls.commands;

import com.pls.domain.ParkingLots;

public class GetSlotForRegistrationNumberCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;

    public GetSlotForRegistrationNumberCommand(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public String execute(String command) {
        String registrationNumber = command.split(" ")[1];
        return parkingLots.getSlotForRegistrationNumber(registrationNumber);
    }
}
