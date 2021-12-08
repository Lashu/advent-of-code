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
        var sum = 0
        input.forEach { line ->
            val leftAndRight = line.split(" | ")
            val left = leftAndRight.first().split(" ")
            val right = leftAndRight.last().split(" ")

            val jedynka = left.single { it.length == 2 }
            val czworka = left.single { it.length == 4 }
            val siodemka = left.single { it.length == 3}
            val osemka = left.single { it.length == 7}
            val szostka = left.single { it.length == 6 && it.count { char -> jedynka.contains(char) }==1 }
            val zero = left.single { it.length == 6 && !it.toList().containsAll(szostka.toList()) && !it.toList().containsAll(czworka.toList())}
            val dziewiatka = left.single { it.length == 6 && !it.toList().containsAll(szostka.toList()) && !it.toList().containsAll(zero.toList())}
            val prawaGorna = left.single { it.length == 7 }.filterNot { szostka.contains(it) }
            val piatka = left.single { it.length == 5 && !it.contains(prawaGorna) }
            val lewaDolna = left.single { it.length == 7 }.filterNot { dziewiatka.contains(it) }
            val trojka = left.single { it.length == 5 && !it.toList().containsAll(piatka.toList()) && !it.contains(lewaDolna) }
            val dwojka = left.single { it.length == 5 && !it.toList().containsAll(piatka.toList()) && !it.toList().containsAll(trojka.toList()) }

            val mapOfNumbers = mapOf(
                zero to "0",
                jedynka to "1",
                dwojka to "2",
                trojka to "3",
                czworka to "4",
                piatka to "5",
                szostka to "6",
                siodemka to "7",
                osemka to "8",
                dziewiatka to "9"
            )

            var liczba = ""
            right.map {
                liczba += mapOfNumbers[mapOfNumbers.keys.find { key -> key.toList().containsAll(it.toList()) && key.length == it.length }]
            }
            sum += liczba.toInt()
        }

        return sum
    }
}