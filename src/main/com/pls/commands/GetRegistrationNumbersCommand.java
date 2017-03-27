package com.pls.commands;

import com.pls.domain.Car;
import com.pls.domain.ParkingLots;

import java.util.List;

public class GetRegistrationNumbersCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;

    public GetRegistrationNumbersCommand(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public String execute(String command) {
        String color = command.split(" ")[1];

        List<Car> carsWithColor = parkingLots.getCarsWithColor(color);
        StringBuilder sb = new StringBuilder();
        for(Car car : carsWithColor) {
            sb.append(car.getRegistrationNumber()).append(", ");
        }

        String result = sb.toString();

        if(result.contains(",")) {
            result = result.substring(0, result.lastIndexOf(","));
        }

        return result;
    }
}
