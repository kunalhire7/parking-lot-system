package com.pls.domain

import spock.lang.Specification

class CarTest extends Specification {

    def "should create a car with specified details"() {

        when:
        def car = new Car(1234l, "Red")

        then:
        car.getColor() == "Red"
        car.getRegistrationNumber() == 1234l
    }

}
