package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay

class Day6: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        return input.joinToString().split(", , ")
            .map { AnswerGroup.parse(it).calculateUniqueAnswers() }
            .sum()
    }

    override fun partTwo(input: List<String>): Any? {
        return input.joinToString().split(", , ")
            .map {AnswerGroup.parse(it).calculateCommonAnswers()}
            .sum()
    }

    class AnswerGroup private constructor(private val answers: List<String>) {

        companion object {
            fun parse(data: String): AnswerGroup {
                return AnswerGroup(data.split(", "))
            }
        }

        fun calculateUniqueAnswers(): Int {
            return answers.joinToString("").toSet().size
        }

        fun calculateCommonAnswers(): Int {
            return answers
                .map { it.toSet() }
                .reduce { acc, set -> acc.intersect(set) }
                .size
        }
    }

}
