package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import adventOfCode.toPair

class Day1: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        return input.map { it.toInt() }
            .windowed(2)
            .map { it.toPair() }
            .count { it.second > it.first }
    }

    override fun partTwo(input: List<String>): Any? {
        return input.asSequence().map { it.toInt() }
            .windowed(3, 1)
            .map { it.sum() }
            .windowed(2)
            .map { it.toPair() }
            .count { it.second > it.first }
    }

}
