package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day2Spec extends Specification {

    @Subject
    AdventOfCodeDay day2 = new Day2()

    def "should solve part one"() {
        given:
            def input = [
                    "forward 5",
                    "down 5",
                    "forward 8",
                    "up 3",
                    "down 8",
                    "forward 2"
            ]

        when:
            def result = day2.partOne(input)

        then:
            result == 150
    }

    def "should solve part two"() {
        given:
            def input = [
                    "forward 5",
                    "down 5",
                    "forward 8",
                    "up 3",
                    "down 8",
                    "forward 2"
            ]

        when:
            def result = day2.partTwo(input)

        then:
            result == 900
    }


}
