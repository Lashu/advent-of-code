package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import java.lang.Character.*
import java.util.*

class Day9: AdventOfCodeDay {

    var globalInput: List<List<Int>> = emptyList()
    override fun partOne(input: List<String>): Any? {
        globalInput = input.map { it.map { char -> getNumericValue(char) } }

        var sum = 0
        input.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { numberIndex, _ ->
                if (isLowPoint(lineIndex, numberIndex)
                ) {
                    sum += globalInput[lineIndex][numberIndex] + 1
                }
            }
        }

        return sum
    }

    override fun partTwo(input: List<String>): Any? {
        globalInput = input.map { it.map { char -> getNumericValue(char) } }

        val basins = mutableListOf<Int>()
        input.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { numberIndex, _ ->
                if (isLowPoint(lineIndex, numberIndex)
                ) {
                    
                    basins.add(calculateBasinSize(lineIndex, numberIndex))
                    
                }
            }
        }

        return basins.sortedDescending().take(3).reduce { acc, i -> acc * i }
    }


    private fun isLowPoint(lineIndex: Int, numberIndex: Int) = checkRightNeighbor(lineIndex, numberIndex) &&
            checkLeftNeighbor(lineIndex, numberIndex) &&
            checkBottomNeighbor(lineIndex, numberIndex) &&
            checkTopNeighbor(lineIndex, numberIndex)

    private fun calculateBasinSize(lineIndex: Int, numberIndex: Int): Int {

//        println("-----------")
        var visitedPoints = mutableListOf<Pair<Int, Int>>()
        var toVisitPoints: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()

        toVisitPoints.add(lineIndex to numberIndex)

        do {

            val currentPoint = toVisitPoints.poll()!!
            visitedPoints.add(currentPoint)
//            println("Current point: " + globalInput[currentPoint.first][currentPoint.second].toString() + " " + currentPoint)

            if (currentPoint.first + 1 <= globalInput.size - 1 && !toVisitPoints.contains(currentPoint.first + 1 to currentPoint.second) && !visitedPoints.contains(currentPoint.first + 1 to currentPoint.second) && shouldBeVisited(currentPoint, currentPoint.first + 1 to currentPoint.second)) toVisitPoints.add(currentPoint.first + 1 to currentPoint.second)
            if (currentPoint.first - 1 >= 0 && !toVisitPoints.contains(currentPoint.first - 1 to currentPoint.second) && !visitedPoints.contains(currentPoint.first - 1 to currentPoint.second) && shouldBeVisited(currentPoint, currentPoint.first - 1 to currentPoint.second)) toVisitPoints.add(currentPoint.first - 1 to currentPoint.second)
            if (currentPoint.second + 1 <= globalInput.first().size - 1 && !toVisitPoints.contains(currentPoint.first to currentPoint.second + 1) && !visitedPoints.contains(currentPoint.first to currentPoint.second + 1) && shouldBeVisited(currentPoint, currentPoint.first to currentPoint.second + 1)) toVisitPoints.add(currentPoint.first to currentPoint.second + 1)
            if (currentPoint.second - 1 >= 0 && !toVisitPoints.contains(currentPoint.first to currentPoint.second - 1) && !visitedPoints.contains(currentPoint.first to currentPoint.second - 1) && shouldBeVisited(currentPoint, currentPoint.first to currentPoint.second - 1)) toVisitPoints.add(currentPoint.first to currentPoint.second - 1)

//            println("To visit: $toVisitPoints")
        } while (toVisitPoints.isNotEmpty())

//        println("size: ${visitedPoints.size}")
        return visitedPoints.size
    }

    private fun shouldBeVisited(currentPoint: Pair<Int, Int>, pointToVisit: Pair<Int, Int>): Boolean {
        return globalInput[pointToVisit.first][pointToVisit.second] != 9 && globalInput[pointToVisit.first][pointToVisit.second] - globalInput[currentPoint.first][currentPoint.second] == 1
    }

    private fun checkTopNeighbor(
        lineIndex: Int,
        numberIndex: Int
    ): Boolean {
        return if (lineIndex < globalInput.size - 1) {
            globalInput[lineIndex][numberIndex] < globalInput[lineIndex + 1][numberIndex]
        } else {
            true
        }
    }

    private fun checkBottomNeighbor(
        lineIndex: Int,
        numberIndex: Int
    ): Boolean {
        return if (lineIndex > 0) {
            globalInput[lineIndex][numberIndex] < globalInput[lineIndex - 1][numberIndex]
        } else {
            true
        }
    }

    private fun checkLeftNeighbor(
        lineIndex: Int,
        numberIndex: Int
    ): Boolean {
        return if (numberIndex > 0) {
            globalInput[lineIndex][numberIndex] < globalInput[lineIndex][numberIndex - 1]
        } else {
            true
        }
    }

    private fun checkRightNeighbor(
        lineIndex: Int,
        numberIndex: Int
    ): Boolean {
        return if (numberIndex < globalInput.first().size - 1) {
            globalInput[lineIndex][numberIndex] < globalInput[lineIndex][numberIndex + 1]
        } else {
            true
        }
    }

}