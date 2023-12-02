package day02

data class Round(val roundNumber: Int, val red: Int, val green: Int, val blue: Int)

data class Game(val id: Int, val rounds: List<Round>) {
    val redMax = rounds.fold(0) { max, round -> maxOf(max, round.red) }
    val greenMax = rounds.fold(0) { max, round -> maxOf(max, round.green) }
    val blueMax = rounds.fold(0) { max, round -> maxOf(max, round.blue) }
    val isValid = redMax <= 12 && greenMax <= 13 && blueMax <= 14
}

fun day02part1(input: String): Int {
    val allGames: MutableList<Game> = mutableListOf()

    input.lines().forEach { game ->
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

    return allGames.fold(0) { sum, game ->
        println("sum: $sum | game: ${game.id} | isValid: ${game.isValid} | red: ${game.redMax} | green: ${game.greenMax} | blue: ${game.blueMax}")
        sum + if (game.isValid) game.id else 0
    }
}