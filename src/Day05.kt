fun main() {
// Read the input and store the initial configuration of the stacks in a list
    val input = readInput("Day05")
    val initialStacks = readLine()!!.split(" ").map { it.toInt() }

// Read the instructions and apply each step to the stacks
    val instructions = readLine()!!.split(" ")
    while (instructions.isNotEmpty()) {
        // Parse the instruction
        val from = instructions[1].toInt()
        val to = instructions[3].toInt()
        val count = instructions[4].toInt()

        // Move the crates
        val crates = initialStacks[from - 1].takeLast(count)
        initialStacks[from - 1] = initialStacks[from - 1].dropLast(count)
        initialStacks[to - 1] += crates
        instructions.drop(5)
    }

// Print the resulting configuration of the stacks
    println(initialStacks.map { it.last() }.joinToString(""))

}

private infix fun IntRange.fullyOverlaps(second: IntRange) = first <= second.first && last >= second.last

private infix fun IntRange.overlaps(second: IntRange) = first <= second.last && last >= second.first


private fun String.toRanges() =
    substringBefore(",").asIntRange() to substringAfter(",").asIntRange()

private fun String.asIntRange(): IntRange =
    substringBefore("-").toInt()..substringAfter("-").toInt()