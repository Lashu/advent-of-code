package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day4Spec extends Specification {

    @Subject
    AdventOfCodeDay day4 = new Day4()

    def "should solve part one"() {
        given:
            def input = [
                    "2-4,6-8",
                    "2-3,4-5",
                    "5-7,7-9",
                    "2-8,3-7",
                    "6-6,4-6",
                    "2-6,4-8"
            ]

        when:
            def result = day4.partOne(input)

        then:
            result == 2
    }

    def "should solve part two"() {
        given:
            def input = [
                    "2-4,6-8",
                    "2-3,4-5",
                    "5-7,7-9",
                    "2-8,3-7",
                    "6-6,4-6",
                    "2-6,4-8"
            ]

        when:
            def result = day4.partTwo(input)

        then:
            result == 4
    }

}
