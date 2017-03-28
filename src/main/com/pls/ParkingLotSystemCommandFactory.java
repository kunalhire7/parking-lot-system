package com.pls;

import com.pls.commands.*;
import com.pls.domain.ParkingLots;

import java.util.IllegalFormatException;

import static com.pls.constants.Constants.*;

public class ParkingLotSystemCommandFactory {

    private ParkingLotSystemCommandFactory() {

    }

    public static ParkingLotSystemCommand getCommand(String commandStr, ParkingLots parkingLots) throws IllegalFormatException {
        String currentCommand = commandStr.split(" ")[0];
        switch (currentCommand) {
            case CREATE_COMMAND:
                return new CreateParkingLotCommand(parkingLots);
            case PARK_COMMAND:
                return new ParkCommand(parkingLots);
            case LEAVE_COMMAND:
                return new LeaveParkingLotCommand(parkingLots);
            case STATUS_COMMAND:
                return new StatusCommand(parkingLots);
            case GET_REGISTRATION_NUMBERS_COMMAND:
                return new GetRegistrationNumbersCommand(parkingLots);
            case GET_SLOT_NUMBERS_FOR_COLOR_COMMAND:
                return new GetSlotsForColorCommand(parkingLots);
            case GET_SLOT_NUMBER_FOR_REGISTRATION_NO_COMMAND:
                return new GetSlotForRegistrationNumberCommand(parkingLots);
            default:
                throw new IllegalStateException("The command format is not correct.");
        }
    }
}
