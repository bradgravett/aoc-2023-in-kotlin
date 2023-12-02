import day01.day01part1
import day01.day01part2
import day02.day02part1
import day02.puzzleInput
import java.io.File

fun main(args: Array<String>) {
    if (args.isNotEmpty()) args.forEach { println("command line argument: $it") }
//    val puzzleInput = File("C:/work/AdventOfCode2023/src/main/kotlin/day01/puzzleInput.txt").bufferedReader().readLines()
//    val part1TestInput = File("C:/work/AdventOfCode2023/src/main/kotlin/day01/part1TestInput.txt").bufferedReader().readLines()
//    val part2TestInput = File("C:/work/AdventOfCode2023/src/main/kotlin/day01/part2TestInput.txt").bufferedReader().readLines()
//    println("day 1 part 1 test: ${day01part1(part1TestInput)}")
//    println("day 1 part 1 solution: ${day01part1(puzzleInput)}")
//    println("day 1 part 2 test: ${day01part2(part2TestInput)}")
//    println("day 1 part 2 solution: ${day01part2(puzzleInput)}")
    println("day 2 part 1 test: ${day02part1(day02.part1TestInput)}")
    println("day 2 part 1 solution: ${day02part1(day02.puzzleInput)}")
}