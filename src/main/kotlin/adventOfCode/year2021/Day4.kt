package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay

class Day4: AdventOfCodeDay {
    override fun partOne(input: List<String>): Any? {
        val numbersToMark: List<Int> = input.first().split(",").map { it.toInt() }
        val boards: List<Board> = readBoards(input.toMutableList())

        var result = 0
        numbersToMark.forEach { numberToMark ->
            boards.forEach {
                it.markNumber(numberToMark)
                if (it.bingo) {
                    return it.calculateResult(numberToMark)
                }
            }
        }

        return null
    }

    override fun partTwo(input: List<String>): Any? {
        val numbersToMark: List<Int> = input.first().split(",").map { it.toInt() }
        val boards: List<Board> = readBoards(input.toMutableList()).toMutableList()

        var result = 0
        numbersToMark.forEach { numberToMark ->
            boards.forEach {
                it.markNumber(numberToMark)
                if (it.bingo) {
                    if (boards.count { it.bingo } == boards.size) {
                        return it.calculateResult(numberToMark)
                    }
                }
            }
        }

        return null
    }

    private fun readBoards(input: MutableList<String>): List<Board> {
        input.removeFirst()
        input.removeFirst()

        return input.windowed(5, 6)
            .map { board ->
                board.map { lineOfBoard ->
                    lineOfBoard.split(" ").filterNot { it == "" }
                }.flatten()
                    .map { it.toInt() }
            }.map {
                Board(it)
            }
    }
}

class Board(numbers: List<Int>) {
    private val markedNumbers: MutableList<MarkedNumber> = numbers.map { MarkedNumber(it, false) }.toMutableList()
    var bingo: Boolean = false

    fun markNumber(number: Int) {
        markedNumbers.forEachIndexed { index, markedNumber ->
            if (markedNumber.number == number) {
                markedNumbers[index] = MarkedNumber(number, true)
            }
        }
        if (hasBingo()) bingo = true
    }

    private fun hasBingo(): Boolean {
        if (markedNumbers.count { it.marked } < 5) return false

        return hasBingoHorizontally() || hasBingoVertically()
    }

    fun calculateResult(winningNumber: Int): Int {
        return markedNumbers
            .filter { !it.marked }
            .map { it.number }
            .sum() * winningNumber
    }

    private fun hasBingoHorizontally(): Boolean {
        return markedNumbers.windowed(5, 5)
            .any {
                it.all { element -> element.marked }
            }
    }

    private fun hasBingoVertically(): Boolean {
        return (markedNumbers[0].marked && markedNumbers[5].marked && markedNumbers[10].marked && markedNumbers[15].marked && markedNumbers[20].marked ) ||
                (markedNumbers[1].marked && markedNumbers[6].marked && markedNumbers[11].marked && markedNumbers[16].marked && markedNumbers[21].marked ) ||
                (markedNumbers[2].marked && markedNumbers[7].marked && markedNumbers[12].marked && markedNumbers[17].marked && markedNumbers[22].marked ) ||
                (markedNumbers[3].marked && markedNumbers[8].marked && markedNumbers[13].marked && markedNumbers[18].marked && markedNumbers[23].marked ) ||
                (markedNumbers[4].marked && markedNumbers[9].marked && markedNumbers[14].marked && markedNumbers[19].marked && markedNumbers[24].marked )
    }

}

data class MarkedNumber(
    val number: Int,
    val marked: Boolean
)