package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import adventOfCode.plus

class Day3: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        return solveForSlope(input, 1 to 3)
    }

    override fun partTwo(input: List<String>): Any? {
        return listOf(
            solveForSlope(input, 1 to 1),
            solveForSlope(input, 1 to 3),
            solveForSlope(input, 1 to 5),
            solveForSlope(input, 1 to 7),
            solveForSlope(input, 2 to 1)
        ).reduce(Long::times)
    }

    private fun solveForSlope(input: List<String>, slope: Pair<Int, Int>): Long {
        var currentPosition = 0 to 0
        val (height, width) = input.size to input[0].length
        var hitTrees = 0L

        while (currentPosition.first < height) {
            if (input[currentPosition.first][currentPosition.second] == '#') {
                hitTrees++
            }
            currentPosition += slope
            if (currentPosition.second >= width) {
                currentPosition = currentPosition.first to currentPosition.second % width
            }
        }

        return hitTrees
    }

}
