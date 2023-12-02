package day02

data class Round(val roundNumber: Int, val red: Int, val green: Int, val blue: Int) {
    val isValid = red <= 12 && green <= 13 && blue <= 14
}

data class Game(val id: Int, val rounds: List<Round>) {
    val isValid = rounds.fold(true) { accum, round ->
        accum && round.isValid
    }
}

fun day02part1(input: String): Int {
    val allGames: MutableList<Game> = mutableListOf()

    input.lines().forEach {
        val gameId = it.substringBefore(':').drop(5)

        val gameRounds = List(it.substringAfter(':').split(';').size) { index ->

            Round(index, 0, 0, 0)
        }

        allGames.add(Game(gameId.toInt(), gameRounds))
    }
    return allGames.fold(0) { sum, game -> sum + if (game.isValid) game.id else 0 }
}