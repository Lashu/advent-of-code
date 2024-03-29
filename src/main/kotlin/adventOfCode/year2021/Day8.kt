package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay

class Day8: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        var sum = 0
        input.forEach { line ->
            val afterPipe = line.split(" | ").last()
                sum += afterPipe.split(" ").count {
                    it.length == 2 || it.length == 3 || it.length == 4 || it.length == 7
                }
        }
        return sum
    }

    override fun partTwo(input: List<String>): Any? {
        return input.map { line ->
            val leftAndRight = line.split(" | ")
            val left = leftAndRight.first().split(" ")
            val right = leftAndRight.last().split(" ")

            val one = left.single { it.length == 2 }
            val four = left.single { it.length == 4 }
            val seven = left.single { it.length == 3}
            val eight = left.single { it.length == 7}
            val six = left.single { it.length == 6 && it.count { char -> one.contains(char) }==1 }
            val zero = left.single { it.length == 6 && it.isNot(six) && it.isNot(four)}
            val nine = left.single { it.length == 6 && it.isNot(six) && it.isNot(zero)}
            val topRight = left.single { it.length == 7 }.filterNot { six.contains(it) }
            val five = left.single { it.length == 5 && !it.contains(topRight) }
            val bottomLeft = left.single { it.length == 7 }.filterNot { nine.contains(it) }
            val three = left.single { it.length == 5 && it.isNot(five) && !it.contains(bottomLeft) }
            val two = left.single { it.length == 5 && it.isNot(five) && it.isNot(three) }

            val mapOfNumbers = mapOf(
                zero to "0",
                one to "1",
                two to "2",
                three to "3",
                four to "4",
                five to "5",
                six to "6",
                seven to "7",
                eight to "8",
                nine to "9"
            )

            var number = ""
            right.map {
                number += mapOfNumbers.entries.single { entry -> entry.key.toList().containsAll(it.toList()) && entry.key.length == it.length }.value
            }
            number.toInt()

        }.sum()

    }

    private fun String.isNot(other: String): Boolean {
        return !this.toList().containsAll(other.toList())
    }
}