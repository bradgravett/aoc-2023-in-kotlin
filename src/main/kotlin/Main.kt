import day01.day01part1
import day01.day01part2

fun main(args: Array<String>) {
    if (args.isNotEmpty()) args.forEach { println("command line argument: $it") }
    println("day 1 part 1 result: ${day01part1()}")
    println("day 1 part 2 result: ${day01part2()}")
}