package adventOfCode.year2022

import adventOfCode.AdventOfCodeDay
import java.util.Stack

class Day5: AdventOfCodeDay {

    private var stacks: List<Stack<Char>> = emptyList()

    private fun move(count: Int, indexFrom: Int, indexTo: Int) {
        (1..count).forEach { _ ->
            stacks[indexTo].push(stacks[indexFrom].pop())
        }
    }

    private fun moveWithOrder(count: Int, indexFrom: Int, indexTo: Int) {
        val tempStack = Stack<Char>()

        (1..count).forEach { _ ->
            tempStack.push(stacks[indexFrom].pop())
        }

        (1..count).forEach { _ ->
            stacks[indexTo].push(tempStack.pop())
        }
    }

    override fun partOne(input: List<String>): Any? {
        stacks = emptyList()
        val indexOfNewLine = input.indexOf("")
        val amountOfStacks = input[indexOfNewLine - 1].split(" ").filterNot { it.isBlank() }.last().toInt()
        stacks = List(amountOfStacks) { Stack() }

        for (i in 1..amountOfStacks) {
            input.take(indexOfNewLine - 1).reversed()
                .forEach {
                    val nextLetterIndex = (i - 1) * 4 + 1
                    if (it.length > nextLetterIndex) {
                        val char = it[nextLetterIndex]
                        if (char.toInt() != 32) stacks[i - 1].push(char)
                    }
                }
        }

        input.drop(indexOfNewLine + 1)
            .forEach {
                val splittedLine = it.split(" ")
                move(splittedLine[1].toInt(), splittedLine[3].toInt() - 1, splittedLine[5].toInt() - 1)
            }

        return stacks
            .map { stack -> stack.pop() ?: "" }
            .joinToString("")
    }

    override fun partTwo(input: List<String>): Any? {
        stacks = emptyList()

        stacks = emptyList()
        val indexOfNewLine = input.indexOf("")
        val amountOfStacks = input[indexOfNewLine - 1].split(" ").filterNot { it.isBlank() }.last().toInt()
        stacks = List(amountOfStacks) { Stack() }

        for (i in 1..amountOfStacks) {
            input.take(indexOfNewLine - 1).reversed()
                .forEach {
                    val nextLetterIndex = (i - 1) * 4 + 1
                    if (it.length > nextLetterIndex) {
                        val char = it[nextLetterIndex]
                        if (char.toInt() != 32) stacks[i - 1].push(char)
                    }
                }
        }

        input.drop(indexOfNewLine + 1)
            .forEach {
                val splittedLine = it.split(" ")
                moveWithOrder(splittedLine[1].toInt(), splittedLine[3].toInt() - 1, splittedLine[5].toInt() - 1)
            }

        return stacks
            .map { stack -> stack.pop() ?: "" }
            .joinToString("")
    }
}