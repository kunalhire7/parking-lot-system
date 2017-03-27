package com.pls.commands;

import com.pls.domain.ParkingLots;

public class LeaveParkingLotCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;

    public LeaveParkingLotCommand(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public String execute(String command) {
        int leaveSlot = Integer.parseInt(command.split(" ")[1]);
        return parkingLots.leave(leaveSlot);
    }
}
