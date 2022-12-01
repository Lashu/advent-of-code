package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay

class Day1: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        return readElves(input).maxOfOrNull {
            it.getTotalCalories()
        }
    }

    override fun partTwo(input: List<String>): Any? {
        return readElves(input).map {
            it.getTotalCalories()
        }
            .sorted()
            .takeLast(3)
            .sum()
    }

    private fun readElves(input: List<String>): List<Elve> {
        var tempElve = Elve()

        val elves = mutableListOf<Elve>()

        input.forEachIndexed { index, line ->
            if (line.isNotEmpty()) {
                tempElve.addCalories(line.toInt())
                if (index == input.size - 1) {
                    elves.add(tempElve)
                }
            } else {
                elves.add(tempElve)
                tempElve = Elve()
            }
        }

        return elves
    }

}

class Elve {
    private var totalCalories = 0

    fun addCalories(calories: Int) {
        totalCalories += calories
    }

    fun getTotalCalories() = totalCalories
}