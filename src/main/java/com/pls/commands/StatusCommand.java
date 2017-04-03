package com.pls.commands;

import com.pls.domain.ParkingLot;
import com.pls.domain.ParkingLots;

import static com.pls.constants.Constants.LINE_SEPARATOR;
import static com.pls.constants.Constants.TAB;

public class StatusCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;

    public StatusCommand(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public String execute(String command) {
        ParkingLot[] lots = parkingLots.getLots();
        StringBuilder sb = new StringBuilder();
        sb.append("Slot No.").append(TAB).append("Registration No").append(TAB).append("Colour");
        sb.append(LINE_SEPARATOR);

        for (ParkingLot lot : lots) {
            if (lot != null) {
                sb.append(lot.getLotNumber()).append(TAB).append(lot.getCar().getRegistrationNumber()).append(TAB).append(lot.getCar().getColor());
                sb.append(LINE_SEPARATOR);
            }
        }
        return sb.toString();
    }
}
