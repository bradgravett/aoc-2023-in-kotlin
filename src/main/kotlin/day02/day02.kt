package day02

data class Round(val roundNumber: Int, val red: Int, val green: Int, val blue: Int)

data class Game(val id: Int, val rounds: List<Round>) {
    private val redMax = rounds.fold(0) { max, round -> maxOf(max, round.red) }
    private val greenMax = rounds.fold(0) { max, round -> maxOf(max, round.green) }
    private val blueMax = rounds.fold(0) { max, round -> maxOf(max, round.blue) }
    val isValid = redMax <= 12 && greenMax <= 13 && blueMax <= 14
}

fun part1(input: List<String>): Int {
    val allGames: MutableList<Game> = mutableListOf()

    input.forEach { game ->
        val gameId = game.substringBefore(':').drop(5).toInt()

        val gameRounds = game.substringAfter(':').split(';').mapIndexed { index, round ->

            val results = round.split(',').associate {
                val amount = it.filter { char -> char.isDigit() }
                val color = it.filter { char -> char.isLetter() }
                color to amount.toInt()
            }

            Round(index + 1, results["red"] ?: 0, results["green"] ?: 0, results["blue"] ?: 0)
        }

        allGames.add(Game(gameId, gameRounds))
    }

    return allGames.fold(0) { sum, game -> sum + if (game.isValid) game.id else 0 }
}

fun part2(input: List<String>): Int {
    return 0
}