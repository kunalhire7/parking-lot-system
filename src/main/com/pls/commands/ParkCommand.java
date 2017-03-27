package com.pls.commands;

import com.pls.domain.ParkingLots;

public class ParkCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;

    public ParkCommand(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public String execute(String command) {
        return null;
    }
}
