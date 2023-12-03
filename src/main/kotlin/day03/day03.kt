package day03

val partSymbols = "*&/@=+#%-"

fun padInput(input: List<String>): List<String> {

    if (input.isEmpty()) return input

    val linePadding = List(input.first().length) { '.' }.joinToString("")

    val verticallyPaddedInput = listOf(linePadding) + input + listOf(linePadding)

    return verticallyPaddedInput.map { ".$it." }
}