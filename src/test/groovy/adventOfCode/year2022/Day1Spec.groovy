package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day1Spec extends Specification {

    @Subject
    AdventOfCodeDay day1 = new Day1()

    def "should solve part one"() {
        given:
            def input = [
                    "1000",
                    "2000",
                    "3000",
                    "",
                    "4000",
                    "",
                    "5000",
                    "6000",
                    "",
                    "7000",
                    "8000",
                    "9000",
                    "",
                    "10000",
            ]

        when:
            def result = day1.partOne(input)

        then:
            result == 24000
    }

    def "should solve part two"() {
        given:
            def input = [
                    "1000",
                    "2000",
                    "3000",
                    "",
                    "4000",
                    "",
                    "5000",
                    "6000",
                    "",
                    "7000",
                    "8000",
                    "9000",
                    "",
                    "10000",
            ]

        when:
            def result = day1.partTwo(input)

        then:
            result == 45000
    }

}
