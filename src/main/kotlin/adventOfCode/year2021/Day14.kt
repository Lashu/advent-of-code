package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay

class Day14: AdventOfCodeDay {
    override fun partOne(input: List<String>): Any? {
        var start = input.first()

        val mappings = input.filter{ it.contains("->") }
            .map { it.split(" -> ") }
            .map { it.first() to it.last() }
            .toMap()

        repeat(10) {
            val newStart = start.windowed(2, 1)
                .map { joiner(it, mappings) }.joinToString("")
            start = newStart + start.last()
        }

        val freqMap = getFreqMap(start)
        val mostCommonValues = freqMap.values.sortedDescending()

        return mostCommonValues.first() - mostCommonValues.last()
    }

    private fun joiner(it: String, mappings: Map<String, String>): String {


        return it.first() + mappings[it]!!
    }

    override fun partTwo(input: List<String>): Any? {


        // ABCD
        // AB:1 BC:1 CD:1
        // A: 1, B:1, C: 1, D: 1

        // ABABAA

        // actual: A-4, B-2

        // AB: 2
        // BA: 2
        // AA: 1

        // A-2, B-2


        // NNCBCB
        //
        // [
        //  NN: 1,
        //  NC: 1,
        //  BC: 1,
        //  CB: 2
        // ]

        // NCNBCHB
        // [
        //
        //  NB : 1,
        //  BC: 1,
        // CH:  1,
        // CB: 1
        //  CN: 1
        // ]

        var start = input.first()

        val mappings = input.filter{ it.contains("->") }
            .map { it.split(" -> ") }
            .map { it.first() to it.last() }
            .toMap()

        var pairs: MutableMap<String, Long> = start.windowed(2, 1).groupingBy { it }.eachCount().mapValues { it.value.toLong() }.toMutableMap()

        var i = 1
        repeat(40) {
            val newPairs = mutableMapOf<String, Long>()

            pairs.forEach { pair ->

                val leftPair = pair.key.first() + mappings[pair.key]!!
                val rightPair = mappings[pair.key]!! + pair.key.last()

                if (newPairs[leftPair] == null) {
                    newPairs[leftPair] = pair.value
                } else {
                    newPairs[leftPair] = newPairs[leftPair]!! + pair.value
                }

                if (newPairs[rightPair] == null) {
                    newPairs[rightPair] = pair.value
                } else {
                    newPairs[rightPair] = newPairs[rightPair]!! + pair.value
                }


            }

            i++
            pairs = newPairs
        }

        val allLetters: MutableMap<Char, Long> = mutableMapOf()

        pairs.keys.forEach {
            key ->
            val left = key.first()
            val right = key.last()

            if (left == right) {
                allLetters.putIfAbsent(left, 0)
            }

            allLetters.putIfAbsent(left, 0)
            allLetters.putIfAbsent(right, 0)
        }

        pairs.forEach { pair ->
            allLetters[pair.key.first()] = allLetters[pair.key.first()]!! + pair.value
            allLetters[pair.key.last()] = allLetters[pair.key.last()]!! + pair.value
        }

        allLetters.map {
            it.key to it.value.div(2)
        }

        allLetters[start.first()] = allLetters[start.first()]!! + 1
        allLetters[start.last()] = allLetters[start.last()]!! + 1

        val mostCommonValues = allLetters.values.sortedDescending()

        return mostCommonValues.first()/2 - mostCommonValues.last()/2
    }


    fun getFreqMap(chars: String): Map<Char, Int> {
        val freq: MutableMap<Char, Int> = HashMap()
        for (c in chars)
        {
            freq.putIfAbsent(c, 0)
            freq[c] = freq[c]!! + 1
        }
        return freq
    }
}