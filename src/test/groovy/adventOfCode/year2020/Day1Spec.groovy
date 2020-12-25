package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day1Spec extends Specification {

    @Subject
    AdventOfCodeDay day1 = new Day1(1, 2020)

    def "should solve part one"() {
        given:
            def input = ["123", "2017", "421", "3", "99999"]

        when:
            def result = day1.partOne(input)

        then:
            result == 2017 * 3
    }

    def "should solve part two"() {
        given:
        def input = ["123", "2015", "421", "3", "99999", "2"]

        when:
        def result = day1.partTwo(input)

        then:
        result == 2015 * 3 * 2
    }

}
