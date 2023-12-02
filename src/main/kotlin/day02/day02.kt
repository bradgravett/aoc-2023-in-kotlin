package day02

data class Round(val roundNumber: Int, val red: Int, val green: Int, val blue: Int)

data class Game(val input: String) {
    val id = input.substringBefore(':').drop(5).toInt()
    private val rounds = input.substringAfter(':').split(';').mapIndexed { index, round ->

        val results = round.split(',').associate {
            val amount = it.filter { char -> char.isDigit() }
            val color = it.filter { char -> char.isLetter() }
            color to amount.toInt()
        }

        Round(index + 1, results["red"] ?: 0, results["green"] ?: 0, results["blue"] ?: 0)
    }
    private val redMax = rounds.fold(0) { max, round -> maxOf(max, round.red) }
    private val greenMax = rounds.fold(0) { max, round -> maxOf(max, round.green) }
    private val blueMax = rounds.fold(0) { max, round -> maxOf(max, round.blue) }
    val isValid = redMax <= 12 && greenMax <= 13 && blueMax <= 14
    val power = redMax * greenMax * blueMax
}

fun part1(input: List<String>): Int {
    val allGames = input.map { Game(it) }

    val sumOfAllValidGameIds = allGames.fold(0) { sum, game -> sum + if (game.isValid) game.id else 0 }

    return sumOfAllValidGameIds
}

fun part2(input: List<String>): Int {
    val allGames = input.map { Game(it) }

    val sumOfAllGamePowers = allGames.fold(0) { sum, game -> sum + game.power}

    return sumOfAllGamePowers
}