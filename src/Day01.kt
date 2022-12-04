fun main() {
    val input = readInput("Day01")
    val sums = input.split("\n\n").map { it.lines().sumOf( String::toInt) }
    val top3 = sums.sortedDescending().take(3)
    check(69883 == top3[0])
    check(207576 == top3.sum())
}

