package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day9Spec extends Specification {

    @Subject
    AdventOfCodeDay day9 = new Day9()

    def "should solve part one"() {
        given:
            def input = [
                    "2199943210",
                    "3987894921",
                    "9856789892",
                    "8767896789",
                    "9899965678"
            ]

        when:
            def result = day9.partOne(input)

        then:
            result == 15
    }
    def "should solve part two"() {
        given:
            def input = [
                    "2199943210",
                    "3987894921",
                    "9856789892",
                    "8767896789",
                    "9899965678"
            ]

        when:
            def result = day9.partTwo(input)

        then:
            result == 1134
    }

}
