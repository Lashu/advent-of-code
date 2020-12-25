package adventOfCode

abstract class AdventOfCodeDay(private val day: Int, private val year: Int) {

    abstract fun partOne(input: List<String>): Any?

    abstract fun partTwo(input: List<String>): Any?

}