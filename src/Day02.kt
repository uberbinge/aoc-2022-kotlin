fun main() {
    firstProblem()
    secondProblem()
}

fun firstProblem() {
    val input = readLines("Day02")
    var sum = 0
    val newInput = input.asSequence().map { it.replace("A", "rock") }.map { it.replace("B", "paper") }.map { it ->
        it.replace("C", "scissors")
    }.map { it.replace("X", "rock") }.map { it.replace("Y", "paper") }.map {
        it.replace("Z", "scissors")
    }.toList()

    newInput.forEach {
        val first = it.split(" ")[0]
        val second = it.split(" ")[1]
        // check winLoseOrDraw
        sum += checkWinLoseOrDraw(second, first)
        // check if second is rock, paper or scissors and add to sum 1,2 or 3 respectively
        sum += when (second) {
            "rock" -> {
                1
            }

            "paper" -> {
                2
            }

            else -> {
                3
            }
        }

    }
    println(sum)
    check(13924 == sum)
}

fun secondProblem() {
    val input = readLines("Day02")
    var sum = 0
    val newInput = input.asSequence().map { it.replace("A", "rock") }.map { it.replace("B", "paper") }.map { it ->
        it.replace("C", "scissors")
    }.map { it.replace("X", "rock") }.map { it.replace("Y", "paper") }.map {
        it.replace("Z", "scissors")
    }.toList()
    newInput.forEach {
        val first = it.split(" ")[0]
        val convertedMove = when (it.split(" ")[1]) {
            "rock" -> {
                convertToLosingMove(first)
            }

            "paper" -> {
                convertToDrawMove(first)
            }

            else -> {
                convertToWinningMove(first)
            }
        }
        // check winLoseOrDraw
        sum += checkWinLoseOrDraw(convertedMove, first)
        // check if second is rock, paper or scissors and add to sum 1,2 or 3 respectively
        sum += when (convertedMove) {
            "rock" -> {
                1
            }

            "paper" -> {
                2
            }

            else -> {
                3
            }
        }

    }
    println(sum)
    check(13448 == sum)
}

fun checkWinLoseOrDraw(player1: String, player2: String): Int {
    return when {
        player1 == player2 -> 3
        player1 == "rock" && player2 == "scissors" -> 6
        player1 == "rock" && player2 == "paper" -> 0
        player1 == "paper" && player2 == "rock" -> 6
        player1 == "paper" && player2 == "scissors" -> 0
        player1 == "scissors" && player2 == "paper" -> 6
        player1 == "scissors" && player2 == "rock" -> 0
        else -> 3
    }
}

fun convertToWinningMove(input: String): String {
    return when (input) {
        "rock" -> "paper"
        "paper" -> "scissors"
        "scissors" -> "rock"
        else -> throw IllegalArgumentException("Invalid input")
    }
}

// create a function which takes a string containing rock paper or scissors and returns what is needed to draw
fun convertToDrawMove(input: String): String {
    return when (input) {
        "rock" -> "rock"
        "paper" -> "paper"
        "scissors" -> "scissors"
        else -> throw IllegalArgumentException("Invalid input")
    }
}

// create a function which takes a string containing rock paper or scissors and returns what is needed to lose
fun convertToLosingMove(input: String): String {
    return when (input) {
        "rock" -> "scissors"
        "paper" -> "rock"
        "scissors" -> "paper"
        else -> throw IllegalArgumentException("Invalid input")
    }
}

