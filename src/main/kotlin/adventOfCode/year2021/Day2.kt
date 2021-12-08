package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay

class Day2: AdventOfCodeDay {
    override fun partOne(input: List<String>): Any? {
        val forwardPosition = sumUpDirection(input, "forward")
        val upPosition = sumUpDirection(input, "up")
        val downPosition = sumUpDirection(input, "down")

        return forwardPosition * (downPosition - upPosition)
    }

    private fun sumUpDirection(input: List<String>, direction: String): Int {
        return input.filter {
            it.startsWith(direction)
        }
            .map { it.split(" ")[1].toInt() }
            .sum()
    }

    override fun partTwo(input: List<String>): Any? {
        var depth = 0
        var horizontalPosition = 0
        var aim = 0
        input.forEach {
            val direction = it.split(" ").first()
            val value  = it.split(" ").last().toInt()
            if (direction == "down") aim += value
            if (direction == "up") aim -= value
            if (direction == "forward") {
                horizontalPosition += value
                depth += aim * value
            }

        }
        return depth * horizontalPosition
    }
}