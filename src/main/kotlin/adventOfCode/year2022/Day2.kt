package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay
import adventOfCode.toPair
import adventOfCode.year2022.Move.PAPER
import adventOfCode.year2022.Move.ROCK
import adventOfCode.year2022.Move.SCISSORS
import adventOfCode.year2022.Strategy.DRAW
import adventOfCode.year2022.Strategy.LOSE
import adventOfCode.year2022.Strategy.WIN

class Day2: AdventOfCodeDay {

    private val wins = mapOf(
        ROCK to SCISSORS,
        SCISSORS to PAPER,
        PAPER to ROCK
    )

    private val loses = mapOf(
        SCISSORS to ROCK,
        PAPER to SCISSORS,
        ROCK to PAPER
    )

    private fun mapRawToMove(rawMove: String): Move {
        return when (rawMove) {
            "A", "X" -> ROCK
            "Y", "B" -> PAPER
            else -> SCISSORS
        }
    }

    private fun getOutput(round: Pair<Move, Move>): Int {
        val myMove = round.second
        val opponentMove = round.first

        return if (wins[myMove] == opponentMove) { // win
            myMove.score + 6
        } else if (myMove == opponentMove) {
            myMove.score + 3 // draw
        } else {
            myMove.score + 0 // lose
        }
    }

    private fun getOutputWithStrategy(moveWithStrategy: Pair<Move, Strategy>): Int {
        val opponentMove = moveWithStrategy.first
        val strategy = moveWithStrategy.second

        return when (strategy) {
            WIN -> loses[opponentMove]!!.score + 6
            DRAW -> opponentMove.score + 3
            LOSE -> wins[opponentMove]!!.score + 0
        }
    }

    override fun partOne(input: List<String>): Any? {
        return input.map {
            it.split(" ").toPair()
        }.map {
            mapRawToMove(it.first) to mapRawToMove(it.second)
        }.sumOf {
            getOutput(it)
        }
    }

    override fun partTwo(input: List<String>): Any? {
        return input.map {
            it.split(" ").toPair()
        }.map {
            mapRawToMove(it.first) to Strategy.fromRawString(it.second)
        }.sumOf {
            getOutputWithStrategy(it)
        }
    }
}

enum class Move(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}

enum class Strategy {
    WIN,
    DRAW,
    LOSE;

    companion object {
        fun fromRawString(rawStrategy: String): Strategy {
            return when (rawStrategy) {
                "X" -> LOSE
                "Y" -> DRAW
                "Z" -> WIN
                else -> throw IllegalArgumentException()
            }
        }
    }
}
