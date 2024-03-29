package adventOfCode

object InputReader {
    fun readInput(resourcePath: String): List<String> {
        return javaClass.getResourceAsStream(resourcePath).bufferedReader().readLines()
    }
}

fun <T> List<T>.toPair(): Pair<T, T> {
    require(this.size == 2)
    return this[0] to this[1]
}

fun Pair<Int, Int>.toIntRange(): IntRange {
    return IntRange(this.first, this.second)
}

operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(first + other.first, second + other.second)
}
