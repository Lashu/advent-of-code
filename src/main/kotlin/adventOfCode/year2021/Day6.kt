package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay

class Day6: AdventOfCodeDay {
    override fun partOne(input: List<String>): Any? {

        var lanternfish = input.first().split(",").map { it.toInt() }.toMutableList()

        var fishToAdd = mutableListOf<Int>()
        var pattern = mutableListOf<Int>()
        repeat(80) {
            lanternfish.forEachIndexed { index, i ->
                lanternfish[index] = lanternfish[index] - 1
                if (lanternfish[index] == -1) {
                    lanternfish[index] = 6
                    fishToAdd.add(8)
                }
            }
            lanternfish = (lanternfish + fishToAdd).toMutableList()
            pattern.add(lanternfish.count())
            fishToAdd.clear()
        }
        println(pattern.joinToString(","))
        return lanternfish.count()
    }

    override fun partTwo(input: List<String>): Any? {
        val lanternfish = input.first().split(",").map { it.toInt() }.toMutableList()

        val lanternFishMap: MutableMap<Long, Long> = lanternfish.groupBy { it.toLong() }.mapValues { it.value.count().toLong() }.toMutableMap()
        lanternFishMap[0] = 0
        lanternFishMap[6] = 0
        lanternFishMap[5] = 0
        lanternFishMap[7] = 0
        lanternFishMap[8] = 0
        var zeraNaPoczatku = 0L
        var siodemkiNaPoczatku = 0L
        repeat(256) {
            zeraNaPoczatku = lanternFishMap[0]!!
            siodemkiNaPoczatku = lanternFishMap[7]!!
            lanternFishMap[0] = lanternFishMap[1]!!
            lanternFishMap[1] = lanternFishMap[2]!!
            lanternFishMap[2] = lanternFishMap[3]!!
            lanternFishMap[3] = lanternFishMap[4]!!
            lanternFishMap[4] = lanternFishMap[5]!!
            lanternFishMap[5] = lanternFishMap[6]!!
            lanternFishMap[7] = lanternFishMap[8]!!
            lanternFishMap[6] = siodemkiNaPoczatku + zeraNaPoczatku
            lanternFishMap[8] = zeraNaPoczatku

//            println(lanternFishMap.toSortedMap())
        }
        return lanternFishMap.values.sum()
    }
}