package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay

class Day2(day: Int, year: Int) : AdventOfCodeDay(day, year) {
    override fun partOne(input: List<String>): Any? {
        return input
            .filter { passwordPolicy -> isPasswordValidBasedOnOccurrences(passwordPolicy) }
            .count()
    }

    override fun partTwo(input: List<String>): Any? {
        return input
            .filter { passwordPolicy -> isPasswordValidBasedOnPositions(passwordPolicy) }
            .count()
    }

    private fun isPasswordValidBasedOnOccurrences(passwordPolicy: String): Boolean {
        val passwordParts = passwordPolicy.split(" ")

        val passwordRequiredLetterOccurrences = passwordParts[0].split("-")
            .map { it.toInt() }
            .toPair()
            .toIntRange()

        val requiredLetter = passwordParts[1][0]

        val passwordToValidate = passwordParts[2]
        val letterCount = passwordToValidate.count { it == requiredLetter }

        return passwordRequiredLetterOccurrences.contains(letterCount)
    }

    private fun isPasswordValidBasedOnPositions(passwordPolicy: String): Boolean {
        val passwordParts = passwordPolicy.split(" ")

        val passwordRequiredLetterPositions = passwordParts[0].split("-")
            .map { it.toInt() }
            .toPair()

        val requiredLetter = passwordParts[1][0]

        val passwordToValidate = passwordParts[2]

        val firstPositionMatched = passwordToValidate[passwordRequiredLetterPositions.first - 1] == requiredLetter
        val secondPositionMatched = passwordToValidate[passwordRequiredLetterPositions.second - 1] == requiredLetter

        return firstPositionMatched xor secondPositionMatched
    }

    private fun <T> List<T>.toPair(): Pair<T, T> {
        require(this.size == 2)
        return this[0] to this[1]
    }

    private fun Pair<Int, Int>.toIntRange(): IntRange {
        return IntRange(this.first, this.second)
    }
}