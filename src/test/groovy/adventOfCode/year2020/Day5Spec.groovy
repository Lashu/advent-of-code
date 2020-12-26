package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day5Spec extends Specification {

    @Subject
    AdventOfCodeDay day5 = new Day5()

    def "should solve part one"() {
        given:
            def input = [
                    "BFFFBBFRRR",
                    "FFFBBBFRRR",
                    "BBFFBBFRLL",
                    "BBFFBBFRLL",
                    "BBFFBBFRLL",
                    "BBFFBBFRLL"
            ]

        when:
            def result = day5.partOne(input)

        then:
            result == 820
    }

    def "should solve part two"() {
        given:
            def input = [
                    "FBBFBFFLRR",
                    "FBBFBFFRLR",
                    "FBBFBFFRRL"
            ]

        when:
            def result = day5.partTwo(input)

        then:
            result == 420
    }

}
