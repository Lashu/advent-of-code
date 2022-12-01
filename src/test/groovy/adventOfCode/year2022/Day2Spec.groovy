package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day2Spec extends Specification {

    @Subject
    AdventOfCodeDay day2 = new Day2()

    def "should solve part one"() {
        given:
            def input = [
                    "A Y",
                    "B X",
                    "C Z"
            ]

        when:
            def result = day2.partOne(input)

        then:
            result == 15
    }

    def "should solve part two"() {
        given:
            def input = [
                    "A Y",
                    "B X",
                    "C Z"
            ]

        when:
            def result = day2.partTwo(input)

        then:
            result == 12
    }

}
