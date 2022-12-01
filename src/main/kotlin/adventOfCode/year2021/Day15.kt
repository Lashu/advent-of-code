package adventOfCode.year2021

import adventOfCode.AdventOfCodeDay
import java.util.*
import kotlin.collections.HashMap

class Day15: AdventOfCodeDay {

    data class IndexedNode(
        val index: Int,
        val weight: Int
    )

    var inputAsInts: List<List<Int>> = emptyList()

    override fun partOne(input: List<String>): Any? {
        return 2

        val timesInput: Array<Array<Int>> = Array(input.size * 5) {Array(input.first().length * 5) {0} }

        input.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, char ->
                timesInput[lineIndex][index] = Character.getNumericValue(char)
            }
        }

        for (i in 1..4) {
            print(i)
            timesInput.forEachIndexed { lineIndex, line ->
                line.forEachIndexed { index, int ->
                    timesInput[lineIndex][index] = (timesInput[lineIndex][index] + i) % 10
                }
            }
        }

        timesInput.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, int ->
                print(timesInput[lineIndex][index])
            }
            println()
        }

        inputAsInts = input.map { it.map { char -> Character.getNumericValue(char) } }




        var indexedNodes: Array<Array<IndexedNode>> = Array(timesInput.size) {Array(timesInput.first().size) {IndexedNode(0, 0)} }


        var i = 0
        timesInput.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, int ->
                indexedNodes[lineIndex][index] = IndexedNode(i, int)
                i++
            }
        }

//        indexedNodes.forEachIndexed { lineIndex, line ->
//            line.forEachIndexed { index, int ->
//                print("(${int.index} ${int.weight}) ")
//
//            }
//            println()
//        }

        var GRAPH = mutableListOf<Edge>()

        indexedNodes.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, int ->
                if (lineIndex < indexedNodes.size - 1) GRAPH.add( Edge(int.index.toString(), indexedNodes[lineIndex + 1][index].index.toString(),int.weight + indexedNodes[lineIndex + 1][index].weight))
                if (lineIndex > 0) GRAPH.add( Edge(int.index.toString(), indexedNodes[lineIndex - 1][index].index.toString(),int.weight + indexedNodes[lineIndex - 1][index].weight))
                if (index > indexedNodes.first().size - 1) GRAPH.add( Edge(int.index.toString(), indexedNodes[lineIndex][index + 1].index.toString(),int.weight + indexedNodes[lineIndex][index + 1].weight))
                if (index > 0) GRAPH.add( Edge(int.index.toString(), indexedNodes[lineIndex][index - 1].index.toString(),int.weight + indexedNodes[lineIndex][index - 1].weight))
            }
        }


        with (Graph(GRAPH, false)) {  //undirected
            dijkstra("0")
            printPath((i - 1).toString())
        }

//        val shortestPathTree = dijkstra(Graph(weights), 0)
//
//        val shortestPath = shortestPath(shortestPathTree, 0, i - 1)
//
//        val indexedNodesFlattened = indexedNodes.flatten()
//
//        return shortestPath.map {
//            indexedNodesFlattened.find { node -> node.index == it }!!.weight
//        }.sum() - indexedNodesFlattened.find { it.index == 0 }!!.weight

        return 2
    }

    private fun printInts() {
        inputAsInts.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, int ->
                print(int)
            }
            println()
        }
    }

    override fun partTwo(input: List<String>): Any? {

        val multipliedInput: Array<Array<Int>> = Array(input.size * 5) {Array(input.first().length * 5) {0} }

        input.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, char ->
                multipliedInput[lineIndex][index] = Character.getNumericValue(char)
            }
        }

        for (i in 1..4) {
            input.forEachIndexed { lineIndex, line ->
                line.forEachIndexed { index, int ->
                    multipliedInput[lineIndex + (input.size * i)][index] = mapIt(multipliedInput[lineIndex][index] + i)
                }
            }
        }

        for (i in 1..4) {
            multipliedInput.forEachIndexed { lineIndex, line ->
                input.forEachIndexed { index, int ->
                    multipliedInput[lineIndex][index + (input.first().length * i)] = mapIt(multipliedInput[lineIndex][index] + i)
                }
            }
        }

        var indexedNodes: Array<Array<IndexedNode>> = Array(multipliedInput.size) {Array(multipliedInput.first().size) {IndexedNode(0, 0)} }

        var i = 0
        multipliedInput.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, int ->
                indexedNodes[lineIndex][index] = IndexedNode(i, int)
                i++
            }
        }

//        indexedNodes.forEachIndexed { lineIndex, line ->
//            line.forEachIndexed { index, int ->
//                print("(${int.index} ${int.weight}) ")
//
//            }
//            println()
//        }

        var GRAPH = mutableListOf<Edge>()

        indexedNodes.forEachIndexed { lineIndex, line ->
            line.forEachIndexed { index, int ->
                if (lineIndex < indexedNodes.size - 1) GRAPH.add( Edge(int.index.toString(), indexedNodes[lineIndex + 1][index].index.toString(),int.weight + indexedNodes[lineIndex + 1][index].weight))
                if (lineIndex > 0) GRAPH.add( Edge(int.index.toString(), indexedNodes[lineIndex - 1][index].index.toString(),int.weight + indexedNodes[lineIndex - 1][index].weight))
                if (index > indexedNodes.first().size - 1) GRAPH.add( Edge(int.index.toString(), indexedNodes[lineIndex][index + 1].index.toString(),int.weight + indexedNodes[lineIndex][index + 1].weight))
                if (index > 0) GRAPH.add( Edge(int.index.toString(), indexedNodes[lineIndex][index - 1].index.toString(),int.weight + indexedNodes[lineIndex][index - 1].weight))
            }
        }


        with (Graph(GRAPH, false)) {  //undirected
            dijkstra("0")
            printPath((i - 1).toString())
        }

//        val shortestPathTree = dijkstra(Graph(weights), 0)
//
//        val shortestPath = shortestPath(shortestPathTree, 0, i - 1)
//
//        val indexedNodesFlattened = indexedNodes.flatten()
//
//        return shortestPath.map {
//            indexedNodesFlattened.find { node -> node.index == it }!!.weight
//        }.sum() - indexedNodesFlattened.find { it.index == 0 }!!.weight

        return 2
    }

    private fun mapIt(i: Int): Int {
        return if (i >= 10) {
            i % 9
        } else {
            i
        }
    }
}

//version 1.1.51


class Edge(val v1: String, val v2: String, val dist: Int)

/** One vertex of the graph, complete with mappings to neighbouring vertices */
class Vertex(val name: String) : Comparable<Vertex> {

    var dist = Int.MAX_VALUE  //MAX_VALUE assumed to be infinity
    var previous: Vertex? = null
    val neighbours = HashMap<Vertex, Int>()

    fun printPath() {
        if (this == previous) {
            print(name)
        }
        else if (previous == null) {
            print("$name(unreached)")
        }
        else {
            previous!!.printPath()
            if (name == "249999") print(" -> $name($dist)")
        }
    }

    override fun compareTo(other: Vertex): Int {
        if (dist == other.dist) return name.compareTo(other.name)
        return dist.compareTo(other.dist)
    }

    override fun toString() = "($name, $dist)"
}

class Graph(
    val edges: List<Edge>,
    val directed: Boolean,
    val showAllPaths: Boolean = false
) {
    //mapping of vertex names to Vertex objects, built from a set of Edges
    private val graph = HashMap<String, Vertex>(edges.size)

    init {
        //one pass to find all vertices
        for (e in edges) {
            if (!graph.containsKey(e.v1)) graph.put(e.v1, Vertex(e.v1))
            if (!graph.containsKey(e.v2)) graph.put(e.v2, Vertex(e.v2))
        }

        //another pass to set neighbouring vertices
        for (e in edges) {
            graph[e.v1]!!.neighbours.put(graph[e.v2]!!, e.dist)
            //also do this for an undirected graph if applicable
            if (!directed) graph[e.v2]!!.neighbours.put(graph[e.v1]!!, e.dist)
        }
    }

    /** Runs dijkstra using a specified source vertex */
    fun dijkstra(startName: String) {
        if (!graph.containsKey(startName)) {
            println("Graph doesn't contain start vertex '$startName'")
            return
        }
        val source = graph[startName]
        val q = TreeSet<Vertex>()

        //set-up vertices
        for (v in graph.values) {
            v.previous = if (v == source) source else null
            v.dist = if (v == source)  0 else Int.MAX_VALUE
            q.add(v)
        }

        dijkstra(q)
    }

    /** Implementation of dijkstra's algorithm using a binary heap */
    private fun dijkstra(q: TreeSet<Vertex>) {
        while (!q.isEmpty()) {
            //vertex with shortest distance (first iteration will return source)
            val u = q.pollFirst()
            //if distance is infinite we can ignore 'u' (and any other remaining vertices)
            //since they are unreachable
            if (u.dist == Int.MAX_VALUE) break

            //look at distances to each neighbour
            for (a in u.neighbours) {
                val v = a.key //the neighbour in this iteration

                val alternateDist = u.dist + a.value
                if (alternateDist < v.dist) { //shorter path to neighbour found
                    q.remove(v)
                    v.dist = alternateDist
                    v.previous = u
                    q.add(v)
                }
            }
        }
    }

    /** Prints a path from the source to the specified vertex */
    fun printPath(endName: String) {
        if (!graph.containsKey(endName)) {
            println("Graph doesn't contain end vertex '$endName'")
            return
        }
        print(if (directed) "Directed   : " else "Undirected : ")
        graph[endName]!!.printPath()
        println()
        if (showAllPaths) printAllPaths() else println()
    }

    /** Prints the path from the source to every vertex (output order is not guaranteed) */
    private fun printAllPaths() {
        for (v in graph.values) {
            v.printPath()
            println()
        }
        println()
    }
}

//fun <T> dijkstra(graph: Graph<T>, start: T): Map<T, T?> {
//    val S: MutableSet<T> = mutableSetOf() // a subset of vertices, for which we know the true distance
//
//    val delta = graph.vertices.map { it to Int.MAX_VALUE }.toMap().toMutableMap()
//    delta[start] = 0
//
//    val previous: MutableMap<T, T?> = graph.vertices.map { it to null }.toMap().toMutableMap()
//
//    while (S != graph.vertices) {
//        val v: T = delta
//            .filter { !S.contains(it.key) }
//            .minBy { it.value }!!
//            .key
//
//        graph.edges.getValue(v).minus(S).forEach { neighbor ->
//            val newPath = delta.getValue(v) + graph.weights.getValue(Pair(v, neighbor))
//
//            if (newPath < delta.getValue(neighbor)) {
//                delta[neighbor] = newPath
//                previous[neighbor] = v
//            }
//        }
//
//        S.add(v)
//    }
//
//    return previous.toMap()
//}
//
//fun <T> shortestPath(shortestPathTree: Map<T, T?>, start: T, end: T): List<T> {
//    fun pathTo(start: T, end: T): List<T> {
//        if (shortestPathTree[end] == null) return listOf(end)
//        return listOf(pathTo(start, shortestPathTree[end]!!), listOf(end)).flatten()
//    }
//
//    return pathTo(start, end)
//}
//
//fun <T> List<Pair<T, T>>.getUniqueValuesFromPairs(): Set<T> = this
//    .map { (a, b) -> listOf(a, b) }
//    .flatten()
//    .toSet()
//
//fun <T> List<Pair<T, T>>.getUniqueValuesFromPairs(predicate: (T) -> Boolean): Set<T> = this
//    .map { (a, b) -> listOf(a, b) }
//    .flatten()
//    .filter(predicate)
//    .toSet()
//
//data class Graph<T>(
//    val vertices: Set<T>,
//    val edges: Map<T, Set<T>>,
//    val weights: Map<Pair<T, T>, Int>
//) {
//    constructor(weights: Map<Pair<T, T>, Int>): this(
//        vertices = weights.keys.toList().getUniqueValuesFromPairs(),
//        edges = weights.keys
//            .groupBy { it.first }
//            .mapValues { it.value.getUniqueValuesFromPairs { x -> x !== it.key } }
//            .withDefault { emptySet() },
//        weights = weights
//    )
//}