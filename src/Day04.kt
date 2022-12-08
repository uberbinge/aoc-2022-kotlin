fun main() {
    val input = readLines("Day04")
    val ranges = input.map { it.toRanges() }
    fun solvePart1() = ranges.count { it.first fullyOverlaps it.second || it.second fullyOverlaps it.first }
    fun solvePart2() = ranges.count { it.first overlaps it.second || it.second overlaps it.first }

    println(solvePart1())
    println(solvePart2())
    check(569 == solvePart1())
    check(936 == solvePart2())
}

private infix fun IntRange.fullyOverlaps(second: IntRange) = first <= second.first && last >= second.last

private infix fun IntRange.overlaps(second: IntRange) = first <= second.last && last >= second.first


private fun String.toRanges() =
    substringBefore(",").asIntRange() to substringAfter(",").asIntRange()

private fun String.asIntRange(): IntRange =
    substringBefore("-").toInt()..substringAfter("-").toInt()