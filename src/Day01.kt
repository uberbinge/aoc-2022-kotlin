fun main() {
    val input = readInput("Day01")
    var max = Integer.MIN_VALUE
    var sum = 0
    val elvesSum  = mutableListOf<Int>()
    input.forEach {
        if (it.toIntOrNull() != null) {
            sum += it.toInt()
            if (sum > max) {
                max = sum
            }
        } else {
            elvesSum.add(sum)
            sum = 0
        }
    }
    elvesSum.sortDescending()
    println(elvesSum[0])
    elvesSum.take(3).sum().also { println(it) }
}
