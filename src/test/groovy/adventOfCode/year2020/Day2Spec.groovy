package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day2Spec extends Specification {

    @Subject
    AdventOfCodeDay day2 = new Day2(2, 2020)

    def "should solve part one"() {
        given:
        def input = [
                "1-4 a: dsdsaaba",
                "2-10 c: dksajcasodjcadjosadjc",
                "11-13 h: asdxxxxxxxxxxxxxxxxxxx",
                "1-8 b: sabdjasbbbb"
        ]

        when:
        def result = day2.partOne(input)

        then:
        result == 3
    }

    def "should solve part two"() {
        given:
        def input = [
                "1-4 a: dsdsaaba",
                "2-10 c: dksajcasocjcadjosadjc",
                "11-13 h: asdxxxxxxxxxxxxxxxxxxx",
                "1-8 b: sabdjasbbbb",
                "1-3 a: aaadjasbbbb",
                "2-5 g: acadjasbbbb",
        ]

        when:
        def result = day2.partTwo(input)

        then:
        result == 2
    }

}
