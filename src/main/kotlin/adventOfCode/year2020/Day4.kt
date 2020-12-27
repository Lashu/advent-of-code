package adventOfCode.year2020

import adventOfCode.AdventOfCodeDay
import adventOfCode.toPair

class Day4: AdventOfCodeDay {

    override fun partOne(input: List<String>): Any? {
        return toPassports(input).count { it.isValidWeak() }
    }

    override fun partTwo(input: List<String>): Any? {
        return toPassports(input).count { it.isValidHard() }
    }

    companion object {
        private fun toPassports(lines: List<String>): List<Passport> {
            return lines.joinToString().split(", , ")
                .map { Passport.parse(it) }
        }
    }

    class Passport private constructor(private val fields: Map<String, String>) {

        companion object {
            fun parse(data: String): Passport {
                val fields = data.split(", ", " ")
                    .map { field -> field.split(":").toPair() }
                    .toMap()

                return Passport(fields)
            }
        }

        fun isValidWeak(): Boolean {
            return when (fields.size) {
                8 -> true
                7 -> !fields.containsKey("cid")
                else -> false
            }
        }

        fun isValidHard(): Boolean {
            return when (fields.size) {
                8 -> fieldsAreHardValidExcludingCid()
                7 -> !fields.containsKey("cid") && fieldsAreHardValidExcludingCid()
                else -> false
            }
        }

        private fun fieldsAreHardValidExcludingCid(): Boolean {

            return isByrValid(fields.getValue("byr").toInt()) &&
                    isIyrValid(fields.getValue("iyr").toInt()) &&
                    isEyrValid(fields.getValue("eyr").toInt()) &&
                    isHgtValid(fields.getValue("hgt")) &&
                    isHclValid(fields.getValue("hcl")) &&
                    isEclValid(fields.getValue("ecl")) &&
                    isPidValid(fields.getValue("pid"))
        }

        private fun isByrValid(byr: Int): Boolean {
            return byr in 1920..2002
        }

        private fun isIyrValid(iyr: Int): Boolean {
            return iyr in 2010..2020
        }

        private fun isEyrValid(eyr: Int): Boolean {
            return eyr in 2020..2030
        }

        private fun isHgtValid(hgt: String): Boolean {
            val (value, unit) = hgt.dropLast(2).toIntOrNull() to hgt.takeLast(2)

            return when (unit) {
                "cm" -> value in 150..193
                "in" -> value in 59..76
                else -> false
            }
        }

        private fun isHclValid(hcl: String): Boolean {
            return hcl.length == 7 &&
                    hcl.first() == '#' &&
                    hcl.substring(1).all { it.isLetterOrDigit() }
        }

        private fun isEclValid(ecl: String): Boolean {
            return setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(ecl)
        }

        private fun isPidValid(pid: String): Boolean {
            return pid.length == 9 && pid.all { it.isDigit() }
        }

    }

}
