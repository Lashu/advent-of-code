package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day11Spec extends Specification {

    @Subject
    AdventOfCodeDay day11 = new Day11()

    def "should solve part one"() {
        given:
            def input = [
                    "5483143223",
                    "2745854711",
                    "5264556173",
                    "6141336146",
                    "6357385478",
                    "4167524645",
                    "2176841721",
                    "6882881134",
                    "4846848554",
                    "5283751526"
            ]

        when:
            def result = day11.partOne(input)

        then:
            result == 1656
    }

    def "should solve part two"() {
        given:
            def input = [
                    "5483143223",
                    "2745854711",
                    "5264556173",
                    "6141336146",
                    "6357385478",
                    "4167524645",
                    "2176841721",
                    "6882881134",
                    "4846848554",
                    "5283751526"
            ]

        when:
            def result = day11.partTwo(input)

        then:
            result == 195
    }
}
