package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import adventOfCode.toPair

class Day7: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        return input.map { it.toInt() }
            .windowed(3)
            .map { it.sum() }
            .windowed(2)
            .map { it.toPair() }
            .count { it.second > it.first }
    }

    override fun partTwo(input: List<String>): Any? {
        return input.map { it.toInt() }
            .windowed(3, 1)
            .map { it.sum() }
            .windowed(2)
            .map { it.toPair() }
            .count { it.second > it.first }
    }

}
