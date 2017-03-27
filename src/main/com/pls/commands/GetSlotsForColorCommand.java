package com.pls.commands;

import com.pls.domain.ParkingLot;
import com.pls.domain.ParkingLots;

import java.util.List;

import static com.pls.constants.Constants.NOT_FOUND;

public class GetSlotsForColorCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;

    public GetSlotsForColorCommand(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public String execute(String command) {
        String color = command.split(" ")[1];
        List<ParkingLot> lotsWithColor = parkingLots.getLotsWithColor(color);
        StringBuilder sb = new StringBuilder();
        for(ParkingLot lot : lotsWithColor) {
            sb.append(lot.getLotNumber()).append(", ");
        }

        String result = sb.toString();

        if(result.contains(",")) {
            result = result.substring(0, result.lastIndexOf(","));
        }

        return result.isEmpty() ? NOT_FOUND : result;
    }
}
