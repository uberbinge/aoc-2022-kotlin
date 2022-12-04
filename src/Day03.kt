val input = readInput("Day03").split("\n")
fun main() {
    part1()
    part2()
}


fun part1() {
    input.map {
        val first = it.substring(0, it.length / 2)
        val second = it.substring(it.length / 2)
        (first intersect second).single()
    }.sumOf { it.score() }.also { check(8202 == it) }
}

fun part2() {
    input.chunked(3) {
        val (a, b, c) = it
        (a intersect b intersect c).single()
    }.sumOf { it.score() }.also { check(2864 == it) }
}


private fun Char.score(): Int {
    return when (this) {
        in 'a'..'z' -> this - 'a' + 1
        in 'A'..'Z' -> this - 'A' + 27
        else -> error("Invalid character")
    }
}

infix fun String.intersect(other: String): Set<Char> = toSet() intersect other.toSet()
infix fun Set<Char>.intersect(other: String): Set<Char> = this intersect other.toSet()
