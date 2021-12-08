package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Day5: AdventOfCodeDay {
    override fun partOne(input: List<String>): Any? {
        val bord = Bord(1000 + 1, 1000 + 1)

        input.forEach {
            bord
                .fill(it)
        }

        return bord.count()
    }

    override fun partTwo(input: List<String>): Any? {
        val bord = Bord(1000 + 1, 1000 + 1)

        input.forEach {
            bord
                .fill(it, true)
        }

        return bord.count()
    }

}

class Bord(private val maxX: Int, private val maxY: Int) {
    private val board: Array<IntArray> = Array(maxX) {IntArray(maxY) {0} }

    fun fill(line: String, considerDiagonals: Boolean = false) {
        val lineNumbers = line.split(" -> ").map {
            it.split(",")
        }.flatten().map { it.toInt() }

        if (!(lineNumbers[0] == lineNumbers[2] || lineNumbers[1] == lineNumbers[3]) && !considerDiagonals) {
            return
        }

        val xLeft = min(lineNumbers[0], lineNumbers[2])
        val xRight = max(lineNumbers[0], lineNumbers[2])

        val yLeft = min(lineNumbers[1], lineNumbers[3])
        val yRight = max(lineNumbers[1], lineNumbers[3])

        if ((lineNumbers[0] == lineNumbers[2] || lineNumbers[1] == lineNumbers[3])) {
            repeat(maxX) { i ->
                repeat(maxY) { j ->
                    if (j in xLeft..xRight && i in yLeft..yRight)
                        board[i][j]++
                }
            }
        } else {
            var xFill = 0
            var yFill = 0

            xFill = lineNumbers[0]
            yFill = lineNumbers[1]
            repeat(abs(lineNumbers[0] - lineNumbers[2]) + 1) {
                board[yFill][xFill]++
                if (lineNumbers[0] > lineNumbers[2]) {
                    xFill--
                } else {
                    xFill++
                }

                if (lineNumbers[1] > lineNumbers[3]) {
                    yFill--
                } else {
                    yFill++
                }
            }
        }

    }

    fun count(): Int {
        var result = 0
        repeat(maxX) { i ->
            repeat(maxY) { j ->
                if (board[i][j] >= 2) {
                    result++
                }
            }
        }
        return result
    }
}
