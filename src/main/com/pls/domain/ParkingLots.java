package com.pls.domain;

import static com.pls.constants.Constants.*;
import static java.lang.String.format;

public class ParkingLots {
    private int size;
    private ParkingLot[] lots;


    public String create(int size) {
        this.size = 0;
        lots = new ParkingLot[size];
        return format(CREATED_TEMPLATE, size);
    }

    public int allottedSize() {
        return size;
    }

    public int capacity() {
        return lots.length;
    }

    public String park(Car car) {
        if (lots != null) {
            for (int i = 0; i < lots.length; i++) {
                if (lots[i] == null) {
                    lots[i] = new ParkingLot(i, car);
                    size++;
                    return format(PARKED_TEMPLATE, i + 1);
                }
            }
        }
        return PARKING_LOT_NOT_CREATED;
    }
}
