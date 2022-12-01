package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day15Spec extends Specification {

    @Subject
    AdventOfCodeDay day15 = new Day15()

    def "should solve part one"() {
        given:
            def input = [
                    "1163751742",
                    "1381373672",
                    "2136511328",
                    "3694931569",
                    "7463417111",
                    "1319128137",
                    "1359912421",
                    "3125421639",
                    "1293138521",
                    "2311944581"
            ]

        when:
            def result = day15.partOne(input)

        then:
            result == 40
    }


    def "should solve part two"() {
        given:
            def input = [
                    "1163751742",
                    "1381373672",
                    "2136511328",
                    "3694931569",
                    "7463417111",
                    "1319128137",
                    "1359912421",
                    "3125421639",
                    "1293138521",
                    "2311944581"
            ]

        when:
            def result = day15.partTwo(input)

        then:
            result == 40
    }


}
