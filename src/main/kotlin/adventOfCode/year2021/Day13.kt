//package adventOfCode.year2021
//
//import adventOfCode.AdventOfCodeDay
//
//class Day13: AdventOfCodeDay {
//
//    var paper: Array<CharArray> = emptyArray()
//    val YELLOW = "\u001b[0;33m"
//    val RESET = "\u001b[0m"
//
//    override fun partOne(input: List<String>): Any? {
//        val points = input.filter { it.contains(',') }
//            .map { it.split(",") }
//            .map { it.last().toInt() to it.first().toInt() }
//
//        val maxX = points.map { it.first }.max()!!
//        val maxY = points.map { it.second }.max()!!
//
//        paper = Array(maxX + 1) {CharArray(maxY + 1) {'.'} }
//
//        points.forEach {
//            paper[it.first][it.second] = '#'
//        }
//
//        val x = input.first { it.contains("fold along x") }.split("=").last().toInt()
//
//        foldAlongX(x)
//        return countDots()
//    }
//
//    private fun printPaper(paper: Array<CharArray>) {
//        paper.forEachIndexed { index, chars ->
//            chars.forEachIndexed { charIndex, char ->
//                if (char == '#') print(YELLOW + '█' + RESET) else print(' ')
//            }
//            println()
//        }
//    }
//
//    override fun partTwo(input: List<String>): Any? {
//        val points = input.filter { it.contains(',') }
//            .map { it.split(",") }
//            .map { it.last().toInt() to it.first().toInt() }
//
//        val maxX = points.map { it.first }.max()!!
//        val maxY = points.map { it.second }.max()!!
//
//        paper = Array(maxX + 1) {CharArray(maxY + 1) {'.'} }
//
//        points.forEach {
//            paper[it.first][it.second] = '#'
//        }
//
//
//        val x = input.first { it.contains("fold along x") }.split("=").last().toInt()
//
//        input.filter { it.contains("fold") }
//            .forEach {
//                if (it.contains('y')) {
//                    foldAlongY(it.split("=").last().toInt())
//                } else {
//                    foldAlongX(it.split("=").last().toInt())
//                }
//            }
//
//
//        printPaper(paper)
//        return countDots()
//
//        return 2
//    }
//
//    private fun foldAlongX(x: Int) {
//        paper.forEachIndexed { lineIndex, line ->
//            paper[lineIndex][x] = '|'
//
//            var reversedLeft = line.take(x).reversed()
//
//            reversedLeft.forEachIndexed { index, char ->
//                if (char == '#') paper[lineIndex][index + x + 1] = char
//            }
//
//        }
//
//        paper.forEachIndexed { index, line ->
//            paper[index] = paper[index].takeLast(line.size - x - 1).toCharArray()
//        }
//    }
//
//    private fun foldAlongY(y: Int) {
//        paper.forEachIndexed { lineIndex, line ->
//            for (i in 0 until line.size) {
//                paper[y][i] = '-'
//            }
//        }
//
//        var last = paper.takeLast(paper.size - y - 1)
//
//        last.forEachIndexed { lineIndex, line ->
//            line.forEachIndexed { index, char ->
//                if (char == '#') {
//                    try {
//                        paper[y - 1 - lineIndex][index] = last[lineIndex][index] // 6, 5, 4, 3, 2, 1, 0
//                    } catch(ex: ArrayIndexOutOfBoundsException) {
//                        val a =2
//                    }
//                }
//            }
//        }
//
//
//        paper = paper.take(y).toTypedArray()
//    }
//
//    private fun countDots(): Long {
//        return paper.map { it.count { char -> char == '#' } }.sum().toLong()
//    }
//
////    private fun printPaper()
//}