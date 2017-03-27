package com.pls.domain

import spock.lang.Specification

import static com.pls.constants.Constants.*
import static java.lang.String.format

class ParkingLotsSpec extends Specification {

    ParkingLots parkingLots

    def setup() {
        parkingLots = new ParkingLots()
    }

    def "should create the parking lots of specified size"() {
        given:
        def size = 6

        when:
        def result = parkingLots.create(6)

        then:
        result == "Created a parking lot with 6 slots"
        parkingLots.allottedSize() == 0
        parkingLots.capacity() == size
    }

    def "should park the car at the nearest empty slot"() {
        given:
        parkingLots.create(6)
        def car = new Car("KA-01-HH-1234", "White")

        when:
        def result = parkingLots.park(car)

        then:
        result == "Allocated slot number: 1"
        parkingLots.allottedSize() == 1
    }

    def "should return parking lot not created when attempted to park the car without creating parking lot"() {
        given:
        def car = new Car("KA-01-HH-1234", "White")

        when:
        def result = parkingLots.park(car)

        then:
        result == PARKING_LOT_NOT_CREATED
    }

    def "should deallocate the slot for the car about to leave"() {
        given:
        parkingLots.create(6)
        def car1 = new Car("KA-01-BB-0001", "Black")
        def car2 = new Car("KA-01-BB-0002", "White")
        def car3 = new Car("KA-01-BB-0003", "Red")
        parkingLots.park(car1)
        parkingLots.park(car2)
        parkingLots.park(car3)

        when:
        def result = parkingLots.leave(2)

        then:
        result == format(LEAVE_TEMPLATE, 2)
        parkingLots.allottedSize() == 2
    }

    def "should return NO CAR message when attempted to leave the car at slot which was already empty"() {
        given:
        parkingLots.create(6)
        def car1 = new Car("KA-01-BB-0001", "Black")
        parkingLots.park(car1)

        when:
        def result = parkingLots.leave(2)

        then:
        result == format(NO_CAR_TEMPLATE, 2)
    }

    def "should return limit exceeds message when attempted to deallocate the car at slot beyond the lot capacity"() {
        given:
        parkingLots.create(6)

        when:
        def result = parkingLots.leave(7)

        then:
        result == LIMIT_EXCEEDS
    }

    def "should return parking lot not created when attempted to deallocate the car without creating parking lot"() {

        when:
        def result = parkingLots.leave(1)

        then:
        result == PARKING_LOT_NOT_CREATED
    }

}
