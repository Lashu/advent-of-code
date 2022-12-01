package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay

class Day3: AdventOfCodeDay {

    private fun getCharPriority(char: Char): Int {
        val offset = if (char.isUpperCase()) 38 else 96
        return char.toInt() - offset
    }

    private fun getCommonChar(first: String, second: String): Char {
        return first.toSet().intersect(second.toSet()).first()
    }

    private fun getCommonChar(first: String, second: String, third: String): Char {
        return first.toSet().intersect(second.toSet()).intersect(third.toSet()).first()
    }

    override fun partOne(input: List<String>): Any? {

        return input
            .map { getCommonChar(it.substring(0, it.length / 2), it.substring(it.length / 2)) }
            .sumOf { getCharPriority(it) }
    }

    override fun partTwo(input: List<String>): Any? {
        return input.windowed(3, 3)
            .map { getCommonChar(
                it[0],
                it[1],
                it[2]
            ) }
            .sumOf { getCharPriority(it) }
    }

}
