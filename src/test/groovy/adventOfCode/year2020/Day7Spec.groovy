package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day7Spec extends Specification {

    @Subject
    AdventOfCodeDay day7 = new Day7()

    def "should solve part one"() {
        given:
            def input = [
                    "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                    "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                    "bright white bags contain 1 shiny gold bag.",
                    "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                    "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                    "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                    "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                    "faded blue bags contain no other bags.",
                    "dotted black bags contain no other bags."
            ]

        when:
            def result = day7.partOne(input)

        then:
            result == 4
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
            def result = day7.partTwo(input)

        then:
            result == 6
    }

}
