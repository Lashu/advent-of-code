package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification

class AllDaysAcceptanceSpec extends Specification {

    static final def YEAR = 2022

    def "should solve all days"() {
        expect:
            solveDay(new Day1()) == [partOne: 69289, partTwo: 205615]
            solveDay(new Day2()) == [partOne: 14375, partTwo: 10274]
            solveDay(new Day3()) == [partOne: 7824, partTwo: 2798]
    }

    Map<Object, Object> solveDay(AdventOfCodeDay day) {
        def input = readInput("${day.getClass().simpleName}.txt")
        return [partOne: day.partOne(input), partTwo : day.partTwo(input)]
    }

    List<String> readInput(String fileName) {
        return getClass().getResource("/year$YEAR/$fileName").readLines()
    }

}