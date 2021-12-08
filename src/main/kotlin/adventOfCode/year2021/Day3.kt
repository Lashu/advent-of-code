package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay

class Day3: AdventOfCodeDay {
    override fun partOne(input: List<String>): Any? {

        var gammaRate = ""

        input.first().forEachIndexed { index, c ->

            gammaRate += mostCommonBit(input.map { it[index] }.joinToString ("").map { Character.getNumericValue(it) }).toString()
        }

        return gammaRate.toInt(2) * reverseBinary(gammaRate.map { Character.getNumericValue(it) }).joinToString("").toInt(2)

    }

    override fun partTwo(input: List<String>): Any? {

        return findOxygen(input).toInt(2) * findCO2(input).toInt(2)
    }

    fun findOxygen(input: List<String>): String {
        var myResult = input
        var index = 0
        while(myResult.size != 1) {
            myResult = dropLeastCommon(myResult, index++)
        }
        return myResult.first()
    }

    fun findCO2(input: List<String>): String {
        var myResult = input
        var index = 0
        while(myResult.size != 1) {
            myResult = dropLeastCommonReversed(myResult, index++)
        }
        return myResult.first()
    }

    fun dropLeastCommon(array: List<String>, index: Int): List<String> {
        val ones = array.count { it[index] == '1' }
        val zeros = array.count { it[index] == '0' }

        return if (ones > zeros || ones == zeros) {
            array.filter {
                it[index] == '1'
            }
        } else {
            array.filter {
                it[index] == '0'
            }
        }
    }

    fun dropLeastCommonReversed(array: List<String>, index: Int): List<String> {
        val ones = array.count { it[index] == '1' }
        val zeros = array.count { it[index] == '0' }

        return if (ones > zeros) {
            array.filter {
                it[index] == '0'
            }
        } else if (zeros > ones) {
            array.filter {
                it[index] == '1'
            }
        } else {
            array.filter {
                it[index] == '0'
            }
        }
    }

    fun reverseBinary(binary: List<Int>): List<Int> {
        return binary.map {
            if (it == 0) 1 else 0
        }
    }

    fun mostCommonBit(bits: List<Int>): Int {
        return if (bits.count { it == 1 } > bits.count { it == 0 }) 1 else 0
    }
}