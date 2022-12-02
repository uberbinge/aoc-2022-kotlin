fun main() {
    val input = readInput("Day01")
    var sum = 0
    val elvesSum = mutableListOf<Int>()
    input.forEach {
        if (it.toIntOrNull() != null) {
            sum += it.toInt()
        } else {
            elvesSum.add(sum)
            sum = 0
        }
    }
    val top3 =  elvesSum.sortedDescending().take(3)
    check(69883 == top3[0])
    check(207576 == top3.sum())
}

