package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import spock.lang.Specification

class AllDaysAcceptanceSpec extends Specification {

    static final def YEAR = 2020

    def "should solve all days"() {
        expect:
            solveDay(new Day1()) == [partOne: 1015476, partTwo: 200878544]
            solveDay(new Day2()) == [partOne: 586, partTwo: 352]
            solveDay(new Day3()) == [partOne: 284, partTwo: 3510149120]
            solveDay(new Day4()) == [partOne: 192, partTwo: 101]
            solveDay(new Day5()) == [partOne: 913, partTwo: 717]
            solveDay(new Day6()) == [partOne: 6587, partTwo: 3235]
    }

    Map<Object, Object> solveDay(AdventOfCodeDay day) {
        def input = readInput("${day.getClass().simpleName}.txt")
        return [partOne: day.partOne(input), partTwo : day.partTwo(input)]
    }

    List<String> readInput(String fileName) {
        return getClass().getResource("/year$YEAR/$fileName").readLines()
    }

}
