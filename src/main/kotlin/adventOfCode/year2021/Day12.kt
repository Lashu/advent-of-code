package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay

class Day12: AdventOfCodeDay {

    val links: MutableMap<String, MutableList<String>> = mutableMapOf()

    override fun partOne(input: List<String>): Any? {
        initializeLinks(input)

        return countPaths(mutableSetOf("start"), "start")
    }

    private fun initializeLinks(input: List<String>) {
        input.forEach {
            val splitted = it.split("-")

            val a = splitted.first()
            val b = splitted.last()

            if (links.containsKey(a)) {
                links[a]!! += b
            } else {
                links[a] = mutableListOf(b)
            }

            if (links.containsKey(b)) {
                links[b]!! += a
            } else {
                links[b] = mutableListOf(a)
            }
        }
    }

    fun isSmallNode(node: String): Boolean {
        return node.all { it.isLowerCase() }
    }

    fun countPaths(visitedSmallNodes: MutableSet<String>, currentNode: String): Int {
        if (currentNode == "end") {
            return 1
        }

        var generatedPaths = 0
        links[currentNode]!!.forEach { node ->
            if (!visitedSmallNodes.contains(node)) {
                val newVisitedNodes = if (isSmallNode(node)) {
                    visitedSmallNodes + node
                } else {
                    visitedSmallNodes
                }
                generatedPaths += countPaths(newVisitedNodes.toMutableSet(), node)
            }
        }
        return generatedPaths
    }

    fun countPathsTwo(visitedSmallNodes: MutableSet<String>, currentNode: String): Int {
        if (currentNode == "end") {
            return 1
        }

        var generatedPaths = 0
        links[currentNode]!!.forEach { node ->
            if (!hasVisitedNode(visitedSmallNodes, node)) {
                generatedPaths += countPathsTwo(getVisitedNodes(visitedSmallNodes, node), node)
            }
        }
        return generatedPaths
    }

    fun hasVisitedNode(visitedNodes: MutableSet<String>, node: String): Boolean {
        if (node == "start") return true
        return visitedNodes.contains(node) && visitedNodes.contains("twice")
    }

    fun getVisitedNodes(visitedNodes: MutableSet<String>, node: String): MutableSet<String> {
        val isSmall = isSmallNode(node)
        if (!isSmall) return visitedNodes
        if (visitedNodes.contains(node)) return (visitedNodes + "twice").toMutableSet()
        return (visitedNodes + node).toMutableSet()
    }

    override fun partTwo(input: List<String>): Any? {
        initializeLinks(input)
        return countPathsTwo(mutableSetOf("start"), "start")
    }
}

data class Node(val name: String, val neighbors: List<String>)