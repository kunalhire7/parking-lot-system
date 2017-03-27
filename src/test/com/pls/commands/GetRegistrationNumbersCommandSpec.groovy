package com.pls.commands

import com.pls.domain.Car
import com.pls.domain.ParkingLots
import spock.lang.Specification

class GetRegistrationNumbersCommandSpec extends Specification {

    ParkingLots parkingLots
    ParkingLotSystemCommand command

    def setup() {
        parkingLots = new ParkingLots()
        parkingLots.create(6)
        command = new GetRegistrationNumbersCommand(parkingLots)
    }

    def "should execute the command to get the registration numbers of all cars of the given color"() {
        given:
        parkingLots.create(4)
        def car1 = new Car("KA-01-BB-0001", "Black")
        def car2 = new Car("KA-01-BB-0002", "White")
        def car3 = new Car("KA-01-BB-0003", "White")
        parkingLots.park(car1)
        parkingLots.park(car2)
        parkingLots.park(car3)
        def commandStr = "registration_numbers_for_cars_with_colour White"

        when:
        def result = command.execute(commandStr)

        then:
        result == "KA-01-BB-0002, KA-01-BB-0003"
    }

    def "should return blank when co car found for given color"() {
        given:
        parkingLots.create(4)
        def car1 = new Car("KA-01-BB-0001", "Black")
        def car2 = new Car("KA-01-BB-0002", "White")
        def car3 = new Car("KA-01-BB-0003", "White")
        parkingLots.park(car1)
        parkingLots.park(car2)
        parkingLots.park(car3)
        def commandStr = "registration_numbers_for_cars_with_colour Red"

        when:
        def result = command.execute(commandStr)

        then:
        result == ""
    }

}
