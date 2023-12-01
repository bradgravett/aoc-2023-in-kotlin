package day01

val digitWords = arrayListOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
val digits = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

fun day01part1(input: List<String>): Int {
    return input.fold(0) { sum, line ->
        val firstDigit = line.find { it.isDigit() } ?: '0'
        val lastDigit = line.findLast { it.isDigit() } ?: '0'
        val concat = firstDigit.toString() + lastDigit.toString()
        sum + concat.toInt()
    }
}

fun day01part2(input: List<String>): Int = input.fold(0) { sum, line ->
    val tensDigit = line.firstDigit()
    val onesDigit = line.lastDigit()
    sum + (tensDigit * 10) + onesDigit
}


fun String.firstDigit(): Int {
    val word = (findAnyOf(digitWords, 0, true) ?: (length + 1 to "0")).convertWordToDigit()
    val number = findAnyOf(digits, 0, true) ?: (length + 1 to "0")

    return when {
        word.first < number.first -> word.second.toInt()
        number.first < word.first -> number.second.toInt()
        else -> 0
    }
}

fun String.lastDigit(): Int {
    val word = (findLastAnyOf(digitWords, length, true) ?: (-1 to "0")).convertWordToDigit()
    val number = findLastAnyOf(digits, length, true) ?: (-1 to "0")

    return when {
        word.first > number.first -> word.second.toInt()
        number.first > word.first -> number.second.toInt()
        else -> 0
    }
}

fun Pair<Int, String>.convertWordToDigit(): Pair<Int, String> {
    val digit = when (second) {
        "one" -> "1"
        "two" -> "2"
        "three" -> "3"
        "four" -> "4"
        "five" -> "5"
        "six" -> "6"
        "seven" -> "7"
        "eight" -> "8"
        "nine" -> "9"
        else -> "0"
    }
    return first to digit
}