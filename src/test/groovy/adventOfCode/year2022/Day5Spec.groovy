package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day5Spec extends Specification {

    @Subject
    AdventOfCodeDay day5 = new Day5()

    def "should solve part one"() {
        given:
            def input =
                    [
                            "    [D]    ",
                            "[N] [C]    ",
                            "[Z] [M] [P]",
                            " 1   2   3 ",
                            "",
                            "move 1 from 2 to 1",
                            "move 3 from 1 to 3",
                            "move 2 from 2 to 1",
                            "move 1 from 1 to 2"
                    ]
        when:
            def result = day5.partOne(input)

        then:
            result == "CMZ"
    }

    def "should solve part two"() {
        given:
            def input =
                    [
                            "    [D]    ",
                            "[N] [C]    ",
                            "[Z] [M] [P]",
                            " 1   2   3 ",
                            "",
                            "move 1 from 2 to 1",
                            "move 3 from 1 to 3",
                            "move 2 from 2 to 1",
                            "move 1 from 1 to 2"
                    ]
        when:
            def result = day5.partTwo(input)

        then:
            result == "MCD"
    }

}
