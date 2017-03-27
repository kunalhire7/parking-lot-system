package com.pls.domain;

import com.pls.constants.Constants;

public class ParkingLots {
    private int size;
    private ParkingLot[] lots;


    public String create(int size) {
        this.size = 0;
        lots = new ParkingLot[size];
        return String.format(Constants.CREATED_TEMPLATE, size);
    }

    public int allottedSize() {
        return size;
    }

    public int capacity() {
        return lots.length;
    }
}
