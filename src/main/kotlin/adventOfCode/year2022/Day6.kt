package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay

class Day6: AdventOfCodeDay {

    private fun findIndexOfFirstUnique(text: String, firstUnique: Int): Int {
        val indexOfFirstUnique = text
            .windowed(firstUnique, 1)
            .first {
                it.toSet().size == firstUnique
            }

        return text.indexOf(indexOfFirstUnique) + firstUnique
    }

    override fun partOne(input: List<String>): Any? {
        return findIndexOfFirstUnique(input.first(), 4)
    }

    override fun partTwo(input: List<String>): Any? {
        return findIndexOfFirstUnique(input.first(), 14)
    }
}