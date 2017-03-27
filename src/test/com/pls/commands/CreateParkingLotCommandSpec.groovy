package com.pls.commands

import com.pls.domain.ParkingLots
import spock.lang.Specification

class CreateParkingLotCommandSpec extends Specification {

    ParkingLots parkingLots
    ParkingLotSystemCommand command

    def setup() {
        parkingLots = new ParkingLots()
        command = new CreateParkingLotCommand(parkingLots)
    }

    def "should invoke the command to create the parking lot"() {
        given:
        def commandStr = "create_parking_lot 6"

        when:
        def result = command.execute(commandStr)

        then:
        result == "Created a parking lot with 6 slots"
    }

}
