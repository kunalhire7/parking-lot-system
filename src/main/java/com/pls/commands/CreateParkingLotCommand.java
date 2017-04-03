package com.pls.commands;

import com.pls.domain.ParkingLots;

public class CreateParkingLotCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;

    public CreateParkingLotCommand(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public String execute(String command) {
        int size = Integer.parseInt(command.split(" ")[1]);
        return parkingLots.create(size);
    }
}
