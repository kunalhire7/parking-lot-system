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

}
