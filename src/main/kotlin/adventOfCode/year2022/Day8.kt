//package adventOfCode.year2022
//
//import adventOfCode.AdventOfCodeDay
//import java.util.TreeSet
//
//class Day8: AdventOfCodeDay {
//
//    var forest: List<List<Int>> = emptyList()
//
//    fun printForest() {TreeSet
//        forest.sort() }
//        println("--- printing forest ---")
//        forest.forEachIndexed { i, column ->
//            column.forEachIndexed { j, _ ->
//                print(forest[i][j])
//            }
//            println()
//        }
//        println("--- printing forest ---")
//    }
//
//    fun isVisibleFromLeft(row: Int, column: Int): Boolean {
//        for (treeIndex in 0 until column) {
//            if (forest[row][treeIndex] >= forest[row][column]) {
//                return false
//            }
//        }
//        return true
//    }
//
//    fun isVisibleFromRight(row: Int, column: Int): Boolean {
//        for (treeIndex in column + 1 until forest.first().size) {
//            if (forest[row][treeIndex] >= forest[row][column]) {
//                return false
//            }
//        }
//        return true
//    }
//
//    fun isVisibleFromTop(row: Int, column: Int): Boolean {
//        for (treeIndex in 0 until row) {
//            if (forest[treeIndex][column] >= forest[row][column]) {
//                return false
//            }
//        }
//        return true
//    }
//
//    fun isVisibleFromBottom(row: Int, column: Int): Boolean {
//        for (treeIndex in row + 1 until forest.size) {
//            if (forest[treeIndex][column] >= forest[row][column]) {
//                return false
//            }
//        }
//        return true
//    }
//
//    fun isVisible(row: Int, column: Int): Boolean {
//        return isVisibleFromBottom(row, column)
//                || isVisibleFromTop(row, column)
//                || isVisibleFromLeft(row, column)
//                || isVisibleFromRight(row, column)
//    }
//
//    fun countViewingDistanceFromLeft(row: Int, column: Int): Int {
//
//
//
//        when (column) {
//            0 -> return 0
//            1 -> return 1
//            else -> {
//                var viewingDistance = 1
//                for (treeIndex in column - 2 downTo  0) {
//                    if (forest[row][treeIndex] >= forest[row][treeIndex + 1]) {
//                        viewingDistance++
//                    } else {
//                        return viewingDistance
//                    }
//                }
//                return viewingDistance
//            }
//        }
//    }
//
//    fun countScenicScore(row: Int, column: Int): Int {
//        val currentTree = forest[row][column]
//        val viewingDistance = countViewingDistanceFromLeft(row, column)
//        return viewingDistance
//    }
//
//    override fun partOne(input: List<String>): Any? {
//        forest = input.map { it.toList().map { char -> Character.getNumericValue(char) } }
//
//        var visibleCount = 0
//        for (i in 1 until forest.size - 1) {
//            for (j in 1 until forest.first().size - 1) {
//
//                if (isVisible(i, j)) {
//                    visibleCount++
//                }
//
//            }
//        }
//
//        return visibleCount + (forest.first().size * 2) + (forest.size * 2) - 4
//    }
//
//    override fun partTwo(input: List<String>): Any? {
//        forest = input.map { it.toList().map { char -> Character.getNumericValue(char) } }
//
//        var maxScenicScore = 0
//        for (i in 0 until forest.size) {
//            for (j in 0 until forest.first().size) {
//
//                val scenicScore = countScenicScore(i, j)
//                if (scenicScore > maxScenicScore) {
//                    maxScenicScore = scenicScore
//                }
//
//            }
//        }
//
//        return maxScenicScore
//    }
//}