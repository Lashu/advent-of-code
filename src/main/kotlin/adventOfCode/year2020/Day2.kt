package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import adventOfCode.toIntRange
import adventOfCode.toPair

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

        val requiredLetter = passwordParts[1].first()

        val passwordToValidate = passwordParts[2]
        val letterCount = passwordToValidate.count { it == requiredLetter }

        return letterCount in passwordRequiredLetterOccurrences
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

}