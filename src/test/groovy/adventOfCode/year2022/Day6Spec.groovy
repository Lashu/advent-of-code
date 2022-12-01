package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification
import spock.lang.Subject

class Day6Spec extends Specification {

    @Subject
    AdventOfCodeDay day6 = new Day6()

    def "should solve part one"() {
        given:
            def input =
                    [
                            inputString
                    ]
        when:
            def result = day6.partOne(input)

        then:
            result == expectedIndex

        where:
            inputString                         || expectedIndex
            "bvwbjplbgvbhsrlpgdmjqwftvncz"      || 5
            "nppdvjthqldpwncqszvftbrmjlhg"      || 6
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" || 10
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"  || 11
    }

    def "should solve part two"() {
        given:
            def input =
                    [
                            inputString
                    ]
        when:
            def result = day6.partTwo(input)

        then:
            result == expectedIndex

        where:
            inputString                         || expectedIndex
            "mjqjpqmgbljsphdztnvjfqwrcgsmlb"    || 19
            "bvwbjplbgvbhsrlpgdmjqwftvncz"      || 23
            "nppdvjthqldpwncqszvftbrmjlhg"      || 23
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" || 29
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"  || 26
    }

}
