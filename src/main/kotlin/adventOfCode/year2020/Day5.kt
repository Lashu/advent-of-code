package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay

class Day5: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        return input
            .map { Seat(it).id }
            .maxOrNull()
    }

    override fun partTwo(input: List<String>): Any? {
        return input
            .asSequence()
            .map { Seat(it).id }
            .sorted()
            .windowed(2, 1)
            .find { it.size == 2 && (it.first() - it.last() == -2) }
            ?.first()?.plus(1)
    }

    class Seat(boardingPass: String) {

        companion object {
            private const val ROW_COUNT: Int = 127
            private const val COLUMN_COUNT: Int = 7
        }

        private val row: Int = calculatePosition(boardingPass.take(7), 'F', 'B', ROW_COUNT)
        private val column: Int = calculatePosition(boardingPass.takeLast(3), 'L', 'R', COLUMN_COUNT)

        val id: Int = (row * 8) + column

        private fun calculatePosition(textToTraverse: String, lowerHalfChar: Char, upperHalfChar: Char, maxValue: Int): Int {
            var leftValue = 0
            var rightValue = maxValue
            var middleValue = 0

            textToTraverse.forEach {
                if (it == lowerHalfChar) {
                    middleValue = (leftValue + rightValue) / 2
                    rightValue = middleValue
                } else if(it == upperHalfChar) {
                    middleValue = ((leftValue + rightValue) / 2) + 1
                    leftValue = middleValue
                }
            }

            return middleValue
        }

    }

}