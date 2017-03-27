package com.pls.domain

import spock.lang.Specification

class ParkingLotsSpec extends Specification {

    def "should create the parking lots of specified size"() {
        given:
        def size = 6
        def parkingLots = new ParkingLots()

        when:
        def result = parkingLots.create(6)

        then:
        result == "Created a parking lot with 6 slots"
        parkingLots.allottedSize() == 0
        parkingLots.capacity() == size
    }

    def "should park the car at the nearest empty slot"() {
        given:
        def parkingLots = new ParkingLots()
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
        def parkingLots = new ParkingLots()
        def car = new Car("KA-01-HH-1234", "White")

        when:
        def result = parkingLots.park(car)

        then:
        result == "Parking lot is not created yet!!"
    }

}
