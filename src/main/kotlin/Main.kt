fun main(args: Array<String>) {
    if (args.isNotEmpty()) args.forEach { println("command line argument: $it") }
//    println("day 1 part 1 test: ${day01.part1(day01.part1TestInput)}")
//    println("day 1 part 1 solution: ${day01.part1(day01.puzzleInput)}")
//    println("=====")
//
//    println("day 1 part 2 test: ${day01.part2(day01.part2TestInput)}")
//    println("day 1 part 2 solution: ${day01.part2(day01.puzzleInput)}")
//    println("=====")
//
//    println("day 2 part 1 test: ${day02.part1(day02.part1TestInput)}")
//    println("day 2 part 1 solution: ${day02.part1(day02.puzzleInput)}")
//    println("=====")
//
//    println("day 2 part 2 test: ${day02.part2(day02.part1TestInput)}")
//    println("day 2 part 2 solution: ${day02.part2(day02.puzzleInput)}")
//    println("=====")

    println("day 3 part 1 test: \n${day03.padInput(day03.part1TestInput).joinToString("\n")}")
}