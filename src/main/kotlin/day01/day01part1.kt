package day01

import java.io.File

fun day01part1(): Int {
    val puzzleInput =
        File("C:/work/AdventOfCode2023/src/main/kotlin/day01/puzzleInput.txt").bufferedReader().readLines()

    return puzzleInput.fold(0) { sum, line ->
        val firstDigit = line.first { it.isDigit() }.toString()
        val lastDigit = line.last { it.isDigit() }.toString()
        val concat = firstDigit + lastDigit
        sum + concat.toInt()
    }
}