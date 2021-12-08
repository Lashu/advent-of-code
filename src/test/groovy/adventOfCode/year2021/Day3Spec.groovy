package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day3Spec extends Specification {

    @Subject
    AdventOfCodeDay day3 = new Day3()

    def "should solve part one"() {
        given:
            def input = [
                    "00100",
                    "11110",
                    "10110",
                    "10111",
                    "10101",
                    "01111",
                    "00111",
                    "11100",
                    "10000",
                    "11001",
                    "00010",
                    "01010"
            ]

        when:
            def result = day3.partOne(input)

        then:
            result == 198
    }

    def "should solve part two"() {
        given:
            def input = [
                    "00100",
                    "11110",
                    "10110",
                    "10111",
                    "10101",
                    "01111",
                    "00111",
                    "11100",
                    "10000",
                    "11001",
                    "00010",
                    "01010"
            ]

        when:
            def result = day3.partTwo(input)

        then:
            result == 230
    }


}
