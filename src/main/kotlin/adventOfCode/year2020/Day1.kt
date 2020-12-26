package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import com.google.common.collect.Sets

class Day1: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        val numbers = input
            .map { it.toInt() }
            .sorted()

        var leftIndex = 0
        var rightIndex = numbers.size - 1
        val expectedResult = 2020
        do  {
            val currentResult = numbers[leftIndex] + numbers[rightIndex]
            if (currentResult < expectedResult) {
                leftIndex++
            } else if (currentResult > expectedResult) {
                rightIndex--
            }
        }
        while (currentResult != expectedResult)

        return numbers[leftIndex] * numbers[rightIndex]
    }

    override fun partTwo(input: List<String>): Any? {
        val numbers = input
            .map { it.toInt() }
            .toSet()

        val expectedResult = 2020

        return Sets.combinations(numbers, 3)
            .find { it.sum() == expectedResult }
            ?.reduce(Int::times)
    }

}