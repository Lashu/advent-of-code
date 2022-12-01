package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day12Spec extends Specification {

    @Subject
    AdventOfCodeDay day12 = new Day12()

    def "should solve part one"() {
        given:
            def input = [
                    "start-A",
                    "start-b",
                    "A-c",
                    "A-b",
                    "b-d",
                    "A-end",
                    "b-end"
            ]

        when:
            def result = day12.partOne(input)

        then:
            result == 1656
    }


}
