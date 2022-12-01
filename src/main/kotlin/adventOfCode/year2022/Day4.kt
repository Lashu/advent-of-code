package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay
import adventOfCode.toPair

class Day4: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        return input
            .map { it.split(",")}
            .map { it.toPair() }
            .count { isContained(it) }
    }

    private fun isContained(pair: Pair<String, String>): Boolean {


        val first = pair.first.split("-").map { it.toInt() }.toPair()
        val second = pair.second.split("-").map { it.toInt() }.toPair()
        return (second.first <= first.first && second.second >= first.second) || (first.first <= second.first && first.second >= second.second)
    }

    private fun isOverlaping(pair: Pair<String, String>): Boolean {
        val first = pair.first.split("-")
        val firstSet = (first[0].toInt()..first[1].toInt()).toSet()


        val second = pair.second.split("-")
        val secondSet = (second[0].toInt()..second[1].toInt()).toSet()

        return firstSet.intersect(secondSet).isNotEmpty()

    }

    override fun partTwo(input: List<String>): Any? {
        return input
            .map { it.split(",")}
            .map { it.toPair() }
            .count { isOverlaping(it) }
    }

}
