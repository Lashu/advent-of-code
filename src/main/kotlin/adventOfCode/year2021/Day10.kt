package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import java.util.*

class Day10: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        val incorrectCharactersScores = mutableMapOf(
            ')' to 3,
            ']' to 57,
            '}' to 1197,
            '>' to 25137
        )

        var sum = 0

        input.forEach { line ->
            val illegalCharacter = getIllegalCharacter(line)
            if (illegalCharacter != null) {
                sum += incorrectCharactersScores[illegalCharacter]!!
            }
        }

        return sum
    }

    override fun partTwo(input: List<String>): Any? {
        val scores = mutableListOf<Long>()
        input.forEach { line ->
            if (!isLineCorrupted(line)) {
                val remainingBrackets = getRemainingBrackets(line)
                scores.add(calculateScore(remainingBrackets))
            }
        }

        return scores.sorted()[scores.size / 2]
    }

    private fun calculateScore(remainingBrackets: List<Char>): Long {
        val scores = mutableMapOf(
            ')' to 1,
            ']' to 2,
            '}' to 3,
            '>' to 4
        )
        var score: Long = 0
        remainingBrackets.forEach {
            score = score * 5 + scores[it]!!
        }
        return score
    }

    private fun getIllegalCharacter(line: String): Char? {
        val charactersInLine: Stack<Char> = Stack()

        for (char in line) {
            if (char.isClosingBracket()) {
                if (charactersInLine.size == 0) return char
                val lastChar = charactersInLine.pop()
                if (lastChar.getOpposingBracket() != char) {
                    return char
                }
            } else {
                charactersInLine.push(char)
            }
        }
        return null
    }

    private fun isLineCorrupted(line: String): Boolean {
        return getIllegalCharacter(line) != null
    }

    private fun getRemainingBrackets(line: String): List<Char> {
        val charactersInLine: Stack<Char> = Stack()

        for (char in line) {
            if (char.isClosingBracket()) {
                charactersInLine.pop()
            } else {
                charactersInLine.push(char)
            }
        }

        val bracketsToReturn = mutableListOf<Char>()
        while (charactersInLine.isNotEmpty()) {
            bracketsToReturn.add(charactersInLine.pop().getOpposingBracket())
        }

        return bracketsToReturn
    }

    private fun Char.isClosingBracket(): Boolean {
        return this == '>' || this == ']' || this == '}' || this == ')'
    }

    private fun Char.getOpposingBracket(): Char {
        return when (this) {
            '>' -> '<'
            '<' -> '>'
            '(' -> ')'
            ')' -> '('
            '{' -> '}'
            '}' -> '{'
            ']' -> '['
            '[' -> ']'
            else -> '.'
        }
    }
}