package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification

class AllDaysAcceptanceSpec extends Specification {

    static final def YEAR = 2021

    def "should solve all days"() {
        expect:
            solveDay(new Day1()) == [partOne: 1752, partTwo: 1781]
    }

    Map<Object, Object> solveDay(AdventOfCodeDay day) {
        def input = readInput("${day.getClass().simpleName}.txt")
        return [partOne: day.partOne(input), partTwo : day.partTwo(input)]
    }

    List<String> readInput(String fileName) {
        return getClass().getResource("/year$YEAR/$fileName").readLines()
    }

}