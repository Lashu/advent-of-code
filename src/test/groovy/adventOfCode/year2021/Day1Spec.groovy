package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day1Spec extends Specification {

    @Subject
    AdventOfCodeDay day1 = new Day1()

    def "should solve part one"() {
        given:
            def input = ["199", "200", "208", "210", "200", "207", "240", "269", "260", "263"]

        when:
            def result = day1.partOne(input)

        then:
            result == 7
    }

    def "should solve part two"() {
        given:
            def input = ["199", "200", "208","210","200", "207", "240", "269", "260", "263"]

        when:
            def result = day1.partTwo(input)

        then:
            result == 5
    }

}
