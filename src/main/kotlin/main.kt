import adventOfCode.AdventOfCodeDay
import adventOfCode.InputReader
import org.reflections.Reflections
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

const val DEFAULT_YEAR = 2022

@ExperimentalTime
fun main(args: Array<String>) {
    val (day, year) = getTaskDate(args)
    val adventOfCodeDay = getAdventOfCodeTask(day, year)

    val input = InputReader.readInput("/year$year/Day$day.txt")

    println("Solving Day $day of Advent of Code $year")

    val partOneMeasured = measureTimedValue { adventOfCodeDay.partOne(input) }
    val partTwoMeasured = measureTimedValue { adventOfCodeDay.partTwo(input) }

    println("Part one: ${partOneMeasured.value}, duration: ${partOneMeasured.duration}")
    println("Part two: ${partTwoMeasured.value}, duration: ${partTwoMeasured.duration}")
}

private fun getTaskDate(args: Array<String>): Pair<Int, Int> {
    return if (args.isEmpty()) {
        defaultTaskDate()
    } else {
        requestedTaskDate(args)
    }
}

private fun getAdventOfCodeTask(day: Int, year: Int): AdventOfCodeDay {
    val reflections = Reflections("adventOfCode.year$year")
    val allDays = reflections.getSubTypesOf(AdventOfCodeDay::class.java)

    val requestedDay = allDays.find { getDayNumber(it.simpleName) == day}

    require(requestedDay != null) { "Could not find day $day for year $year"}

    return requestedDay.getDeclaredConstructor().newInstance()
}

private fun defaultTaskDate(): Pair<Int, Int> {
    val reflections = Reflections("adventOfCode.year$DEFAULT_YEAR")
    val allDays = reflections.getSubTypesOf(AdventOfCodeDay::class.java)
    val latestDay = allDays.map { getDayNumber(it.simpleName) }.maxOrNull()

    require(latestDay != null) { "Could not find any days for default year $DEFAULT_YEAR" }

    return latestDay to DEFAULT_YEAR
}

private fun requestedTaskDate(args: Array<String>): Pair<Int, Int> {
    require(args.size == 2) { "Please enter two arguments first being day and year as second" }

    val day = args[0].toInt()
    val year = args[1].toInt()

    return day to year
}

private fun getDayNumber(day: String): Int {
    return day.replace("Day", "").toInt()
}
