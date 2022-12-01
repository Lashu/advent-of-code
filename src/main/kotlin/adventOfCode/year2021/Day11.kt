package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import java.util.*

class Day11: AdventOfCodeDay {

    val YELLOW = "\u001b[0;33m"
    val RESET = "\u001b[0m"

    val octopuses: Array<IntArray> = Array(10) {IntArray(10) {0} }
    var globalInput = emptyList<String>()
    override fun partOne(input: List<String>): Any? {
        globalInput = input


        input.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, char ->
                octopuses[lineIndex][index] = Character.getNumericValue(input[lineIndex][index])
            }
        }

        var i = 1
        var sum = 0
        repeat(100) {

            val flashed = mutableListOf<Pair<Int, Int>>()
            val toFlash: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
            input.forEachIndexed { lineIndex, line ->
                line.forEachIndexed { index, char ->
                    octopuses[lineIndex][index]++
                    if (octopuses[lineIndex][index] > 9) {
                        octopuses[lineIndex][index] = 0
                        toFlash.add(lineIndex to index)
                    }
                }
            }

            while (!toFlash.isEmpty()) {
                val currentOctopus = toFlash.poll()

                if (!flashed.contains(currentOctopus)) {
                    flashed.add(currentOctopus)

                    if (currentOctopus.first + 1 < 10                                   && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second) &&  octopuses[currentOctopus.first + 1][currentOctopus.second]!=0  )      octopuses[currentOctopus.first + 1][currentOctopus.second]++
                    if (currentOctopus.first - 1 >= 0                                   && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second)   && octopuses[currentOctopus.first - 1][currentOctopus.second]!=0  )       octopuses[currentOctopus.first - 1][currentOctopus.second]++
                    if (currentOctopus.second + 1 < 10                                  && !flashed.contains(currentOctopus.first to currentOctopus.second + 1)  && octopuses[currentOctopus.first][currentOctopus.second + 1]!=0   )     octopuses[currentOctopus.first][currentOctopus.second + 1]++
                    if (currentOctopus.second - 1 >= 0                                  && !flashed.contains(currentOctopus.first to currentOctopus.second - 1) && octopuses[currentOctopus.first][currentOctopus.second - 1] !=0    )      octopuses[currentOctopus.first][currentOctopus.second - 1]++
                    if (currentOctopus.first + 1 < 10 && currentOctopus.second - 1 >= 0 && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second - 1) && octopuses[currentOctopus.first + 1][currentOctopus.second - 1] != 0 ) octopuses[currentOctopus.first + 1][currentOctopus.second - 1]++
                    if (currentOctopus.first - 1 >= 0 && currentOctopus.second + 1 < 10 && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second + 1) && octopuses[currentOctopus.first - 1][currentOctopus.second + 1] != 0 ) octopuses[currentOctopus.first - 1][currentOctopus.second + 1]++
                    if (currentOctopus.first - 1 >= 0 && currentOctopus.second - 1 >= 0 && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second - 1) && octopuses[currentOctopus.first - 1][currentOctopus.second - 1] != 0 ) octopuses[currentOctopus.first - 1][currentOctopus.second - 1]++
                    if (currentOctopus.first + 1 < 10 && currentOctopus.second + 1 < 10 && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second + 1) && octopuses[currentOctopus.first + 1][currentOctopus.second + 1] != 0 ) octopuses[currentOctopus.first + 1][currentOctopus.second + 1]++

                    if (currentOctopus.first + 1 < 10 && octopuses[currentOctopus.first + 1][currentOctopus.second] > 9 &&                                       !flashed.contains(currentOctopus.first + 1 to currentOctopus.second))    toFlash.add(currentOctopus.first + 1 to currentOctopus.second)
                    if (currentOctopus.first - 1 >= 0 && octopuses[currentOctopus.first - 1][currentOctopus.second] > 9 &&                                       !flashed.contains(currentOctopus.first - 1 to currentOctopus.second))    toFlash.add(currentOctopus.first - 1 to currentOctopus.second)
                    if (currentOctopus.second + 1 < 10 && octopuses[currentOctopus.first][currentOctopus.second + 1] > 9 &&                                      !flashed.contains(currentOctopus.first to currentOctopus.second + 1))    toFlash.add(currentOctopus.first to currentOctopus.second + 1)
                    if (currentOctopus.second - 1 >= 0 && octopuses[currentOctopus.first][currentOctopus.second - 1] > 9 &&                                      !flashed.contains(currentOctopus.first to currentOctopus.second - 1))    toFlash.add(currentOctopus.first to currentOctopus.second - 1)
                    if (currentOctopus.first + 1 < 10 && currentOctopus.second - 1 >= 0 && octopuses[currentOctopus.first + 1][currentOctopus.second - 1] > 9 && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second - 1)) toFlash.add(currentOctopus.first + 1 to currentOctopus.second - 1)
                    if (currentOctopus.first - 1 >= 0 && currentOctopus.second + 1 < 10 && octopuses[currentOctopus.first - 1][currentOctopus.second + 1] > 9 && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second + 1)) toFlash.add(currentOctopus.first - 1 to currentOctopus.second + 1)
                    if (currentOctopus.first - 1 >= 0 && currentOctopus.second - 1 >= 0 && octopuses[currentOctopus.first - 1][currentOctopus.second - 1] > 9 && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second - 1)) toFlash.add(currentOctopus.first - 1 to currentOctopus.second - 1)
                    if (currentOctopus.first + 1 < 10 && currentOctopus.second + 1 < 10 && octopuses[currentOctopus.first + 1][currentOctopus.second + 1] > 9 && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second + 1)) toFlash.add(currentOctopus.first + 1 to currentOctopus.second + 1)
                }
            }

            input.forEachIndexed { lineIndex, ints ->
                input.forEachIndexed { index, i ->
                    if (octopuses[lineIndex][index] > 9) octopuses[lineIndex][index] = 0
                }
            }

//            println("After step: ${i++}")
//            printOctopuses(octopuses, input)
            sum += flashed.size
        }




        return sum
    }

    private fun printOctopuses(octopuses: Array<IntArray>, input: List<String>) {
        input.forEachIndexed { lineIndex, ints ->
            input.forEachIndexed { index, i ->
                if (octopuses[lineIndex][index] == 0) print(YELLOW + octopuses[lineIndex][index] + RESET) else  print(octopuses[lineIndex][index])
            }
            println()
        }
        println("------------------")
    }


    override fun partTwo(input: List<String>): Any? {
        globalInput = input


        input.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, char ->
                octopuses[lineIndex][index] = Character.getNumericValue(input[lineIndex][index])
            }
        }

        var i = 1
        var sum = 0
        while(true) {

            val flashed = mutableListOf<Pair<Int, Int>>()
            val toFlash: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
            input.forEachIndexed { lineIndex, line ->
                line.forEachIndexed { index, char ->
                    octopuses[lineIndex][index]++
                    if (octopuses[lineIndex][index] > 9) {
                        octopuses[lineIndex][index] = 0
                        toFlash.add(lineIndex to index)
                    }
                }
            }

            while (!toFlash.isEmpty()) {
                val currentOctopus = toFlash.poll()

                if (!flashed.contains(currentOctopus)) {
                    flashed.add(currentOctopus)

                    if (currentOctopus.first + 1 < 10                                   && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second) &&  octopuses[currentOctopus.first + 1][currentOctopus.second]!=0  )      octopuses[currentOctopus.first + 1][currentOctopus.second]++
                    if (currentOctopus.first - 1 >= 0                                   && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second)   && octopuses[currentOctopus.first - 1][currentOctopus.second]!=0  )       octopuses[currentOctopus.first - 1][currentOctopus.second]++
                    if (currentOctopus.second + 1 < 10                                  && !flashed.contains(currentOctopus.first to currentOctopus.second + 1)  && octopuses[currentOctopus.first][currentOctopus.second + 1]!=0   )     octopuses[currentOctopus.first][currentOctopus.second + 1]++
                    if (currentOctopus.second - 1 >= 0                                  && !flashed.contains(currentOctopus.first to currentOctopus.second - 1) && octopuses[currentOctopus.first][currentOctopus.second - 1] !=0    )      octopuses[currentOctopus.first][currentOctopus.second - 1]++
                    if (currentOctopus.first + 1 < 10 && currentOctopus.second - 1 >= 0 && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second - 1) && octopuses[currentOctopus.first + 1][currentOctopus.second - 1] != 0 ) octopuses[currentOctopus.first + 1][currentOctopus.second - 1]++
                    if (currentOctopus.first - 1 >= 0 && currentOctopus.second + 1 < 10 && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second + 1) && octopuses[currentOctopus.first - 1][currentOctopus.second + 1] != 0 ) octopuses[currentOctopus.first - 1][currentOctopus.second + 1]++
                    if (currentOctopus.first - 1 >= 0 && currentOctopus.second - 1 >= 0 && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second - 1) && octopuses[currentOctopus.first - 1][currentOctopus.second - 1] != 0 ) octopuses[currentOctopus.first - 1][currentOctopus.second - 1]++
                    if (currentOctopus.first + 1 < 10 && currentOctopus.second + 1 < 10 && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second + 1) && octopuses[currentOctopus.first + 1][currentOctopus.second + 1] != 0 ) octopuses[currentOctopus.first + 1][currentOctopus.second + 1]++

                    if (currentOctopus.first + 1 < 10 && octopuses[currentOctopus.first + 1][currentOctopus.second] > 9 &&                                       !flashed.contains(currentOctopus.first + 1 to currentOctopus.second))    toFlash.add(currentOctopus.first + 1 to currentOctopus.second)
                    if (currentOctopus.first - 1 >= 0 && octopuses[currentOctopus.first - 1][currentOctopus.second] > 9 &&                                       !flashed.contains(currentOctopus.first - 1 to currentOctopus.second))    toFlash.add(currentOctopus.first - 1 to currentOctopus.second)
                    if (currentOctopus.second + 1 < 10 && octopuses[currentOctopus.first][currentOctopus.second + 1] > 9 &&                                      !flashed.contains(currentOctopus.first to currentOctopus.second + 1))    toFlash.add(currentOctopus.first to currentOctopus.second + 1)
                    if (currentOctopus.second - 1 >= 0 && octopuses[currentOctopus.first][currentOctopus.second - 1] > 9 &&                                      !flashed.contains(currentOctopus.first to currentOctopus.second - 1))    toFlash.add(currentOctopus.first to currentOctopus.second - 1)
                    if (currentOctopus.first + 1 < 10 && currentOctopus.second - 1 >= 0 && octopuses[currentOctopus.first + 1][currentOctopus.second - 1] > 9 && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second - 1)) toFlash.add(currentOctopus.first + 1 to currentOctopus.second - 1)
                    if (currentOctopus.first - 1 >= 0 && currentOctopus.second + 1 < 10 && octopuses[currentOctopus.first - 1][currentOctopus.second + 1] > 9 && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second + 1)) toFlash.add(currentOctopus.first - 1 to currentOctopus.second + 1)
                    if (currentOctopus.first - 1 >= 0 && currentOctopus.second - 1 >= 0 && octopuses[currentOctopus.first - 1][currentOctopus.second - 1] > 9 && !flashed.contains(currentOctopus.first - 1 to currentOctopus.second - 1)) toFlash.add(currentOctopus.first - 1 to currentOctopus.second - 1)
                    if (currentOctopus.first + 1 < 10 && currentOctopus.second + 1 < 10 && octopuses[currentOctopus.first + 1][currentOctopus.second + 1] > 9 && !flashed.contains(currentOctopus.first + 1 to currentOctopus.second + 1)) toFlash.add(currentOctopus.first + 1 to currentOctopus.second + 1)
                }
            }

            input.forEachIndexed { lineIndex, ints ->
                input.forEachIndexed { index, i ->
                    if (octopuses[lineIndex][index] > 9) octopuses[lineIndex][index] = 0
                }
            }

//            println("After step: ${i++}")
//            printOctopuses(octopuses, input)

            if (flashed.size == 100) return i
            i++
        }



        return 2
    }
}