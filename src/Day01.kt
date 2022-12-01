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
    elvesSum.sortDescending()
    assert(69883 == elvesSum[0])
    assert(207576 == elvesSum.take(3).sum())
}
