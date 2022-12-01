package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day14Spec extends Specification {

    @Subject
    AdventOfCodeDay day14 = new Day14()

    def "should solve part one"() {
        given:
            def input = [
                    "NNCB",
                    "",
                    "CH -> B",
                    "HH -> N",
                    "CB -> H",
                    "NH -> C",
                    "HB -> C",
                    "HC -> B",
                    "HN -> C",
                    "NN -> C",
                    "BH -> H",
                    "NC -> B",
                    "NB -> B",
                    "BN -> B",
                    "BB -> N",
                    "BC -> B",
                    "CC -> N",
                    "CN -> C"
            ]

        when:
            def result = day14.partOne(input)

        then:
            result == 1588
    }

    def "should solve part two"() {
        given:
            def input = [
                    "NNCB",
                    "",
                    "CH -> B",
                    "HH -> N",
                    "CB -> H",
                    "NH -> C",
                    "HB -> C",
                    "HC -> B",
                    "HN -> C",
                    "NN -> C",
                    "BH -> H",
                    "NC -> B",
                    "NB -> B",
                    "BN -> B",
                    "BB -> N",
                    "BC -> B",
                    "CC -> N",
                    "CN -> C"
            ]

        when:
            def result = day14.partTwo(input)

        then:
            result == 2188189693529
    }


}
