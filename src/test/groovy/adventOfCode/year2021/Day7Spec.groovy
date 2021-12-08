package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day7Spec extends Specification {

    @Subject
    AdventOfCodeDay day7 = new Day7()

    def "should solve part one"() {
        given:
            def input = [
                    "16,1,2,0,4,2,7,1,2,14"
            ]

        when:
            def result = day7.partOne(input)

        then:
            result == 37
    }

    def "should solve part two"() {
        given:
            def input = [
                    "16,1,2,0,4,2,7,1,2,14"
            ]

        when:
            def result = day7.partTwo(input)

        then:
            result == 168
    }

}
