package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day6Spec extends Specification {

    @Subject
    AdventOfCodeDay day6 = new Day6()

    def "should solve part one"() {
        given:
            def input = [
                    "abc",
                    "",
                    "a",
                    "b",
                    "c",
                    "",
                    "ab",
                    "ac",
                    "",
                    "a",
                    "a",
                    "a",
                    "a",
                    "",
                    "b"
            ]

        when:
            def result = day6.partOne(input)

        then:
            result == 11
    }

    def "should solve part two"() {
        given:
            def input = [
                    "abc",
                    "",
                    "a",
                    "b",
                    "c",
                    "",
                    "ab",
                    "ac",
                    "",
                    "a",
                    "a",
                    "a",
                    "a",
                    "",
                    "b"
            ]

        when:
            def result = day6.partTwo(input)

        then:
            result == 6
    }

}
