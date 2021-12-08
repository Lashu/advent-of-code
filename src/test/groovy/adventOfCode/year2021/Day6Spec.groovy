package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day6Spec extends Specification {

    @Subject
    AdventOfCodeDay day6 = new Day6()

    def "should solve part one"() {
        given:
            def input = [
                    "3,4,3,1,2"
            ]

        when:
            def result = day6.partOne(input)

        then:
            result == 5934
    }

    def "should solve part two"() {
        given:
            def input = [
                    "3,4,3,1,2"
            ]

        when:
            def result = day6.partTwo(input)

        then:
            result == 26984457539
    }


}
