package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import kotlin.math.abs

class Day7: AdventOfCodeDay {
    override fun partOne(input: List<String>): Any? {
        var positions = input.first().split(",").map { it.toInt() }

        var left = positions.minOrNull()
        var right = positions.maxOrNull()

        var positionsToSmmaryCost = mutableMapOf<Int, Int>()

        for (i in left!!..right!!) {
            var sum = 0

            positions.forEach {
                position -> sum += abs(i - position)
            }

            positionsToSmmaryCost.put(i, sum)



        }
        return positionsToSmmaryCost.values.minOrNull()
    }

    override fun partTwo(input: List<String>): Any? {
        var positions = input.first().split(",").map { it.toInt() }

        var left = positions.minOrNull()
        var right = positions.maxOrNull()

        var positionsToSmmaryCost = mutableMapOf<Int, Int>()

        for (i in left!!..right!!) {
            var sum = 0

            positions.forEach {
                    position -> sum += ((abs(i - position) * (abs(i - position) + 1)) / 2)
            }

            positionsToSmmaryCost.put(i, sum)
        }

        return positionsToSmmaryCost.values.minOrNull()

    }
}