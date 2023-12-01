package day01

import java.io.File

val puzzleInput = File("C:/work/AdventOfCode2023/src/main/kotlin/day01/puzzleInput.txt").bufferedReader().readLines()
val digitWords = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

fun day01part1(): Int {
    return puzzleInput.fold(0) { sum, line ->
        val firstDigit = line.first { it.isDigit() }.toString()
        val lastDigit = line.last { it.isDigit() }.toString()
        val concat = firstDigit + lastDigit
        sum + concat.toInt()
    }
}

fun day01part2(): Int = puzzleInput.fold(0) { sum, line ->
    val firstDigitWord = line.findAnyOf(digitWords, 0, true)
    val lastDigitWord = line.findLastAnyOf(digitWords, line.length, true)
    println(
        "first digit word: ${firstDigitWord?.second} at ${firstDigitWord?.first} | " +
                "last digit word: ${lastDigitWord?.second} at ${lastDigitWord?.first} | " +
                "line: $line"
    )
    val tensDigit = line.firstDigit()
    val onesDigit = line.lastDigit()

    sum
}


fun String.firstDigit(): Int {
    val firstDigitWordAndPosition = this.findAnyOf(digitWords, 0, true)
    val firstDigitNumber = this.find { it.isDigit() } ?: '0'
    val firstDigitNumberPosition = this.indexOfFirst { it == firstDigitNumber }
    val firstDigitNumberAndPosition = firstDigitNumberPosition to firstDigitNumber
    // TODO compare positions of word and number, return value with smallest position
return 0
}

fun String.lastDigit(): Int {
    val lastDigitWord = this.findLastAnyOf(digitWords, this.length, true)
    return 0
}