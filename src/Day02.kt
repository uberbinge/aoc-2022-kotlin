fun firstProblem() {

    val input = readInput("Day02")
    var sum = 0
    input.forEach {
        val a = it.split(" ")[0]
        val b = it.split(" ")[1]
        val first = convertToRockPaperScissors(a)
        val second = convertToRockPaperScissors(b)
        // check winLoseOrDraw
        val result = checkWinLoseOrDraw(second, first)
        sum += when (result) {
            Result.Win -> {
                6
            }

            Result.Lose -> {
                0
            }

            else -> {
                3
            }
        }
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

fun main() {
    firstProblem()
    secondProblem()
}

fun secondProblem() {
    val input = readInput("Day02")
    var sum = 0
    input.forEach {
        val a = it.split(" ")[0]
        val b = it.split(" ")[1]
        val first = convertToRockPaperScissors(a)
        val convertedMove = when (convertToRockPaperScissors(b)) {
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
        val result = checkWinLoseOrDraw(convertedMove, first)
        sum += when (result) {
            Result.Win -> {
                6
            }

            Result.Lose -> {
                0
            }

            else -> {
                3
            }
        }
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

fun checkWinLoseOrDraw(player1: String, player2: String): Result {
    return when {
        player1 == player2 -> Result.Draw
        player1 == "rock" && player2 == "scissors" -> Result.Win
        player1 == "rock" && player2 == "paper" -> Result.Lose
        player1 == "paper" && player2 == "rock" -> Result.Win
        player1 == "paper" && player2 == "scissors" -> Result.Lose
        player1 == "scissors" && player2 == "paper" -> Result.Win
        player1 == "scissors" && player2 == "rock" -> Result.Lose
        else -> Result.Draw
    }
}

// write the Result class
sealed class Result {
    object Win : Result()
    object Lose : Result()
    object Draw : Result()
}

// create a function which takes a String containing A or B or C and returns rock paper or scissors
fun convertToRockPaperScissors(input: String): String {
    return when (input) {
        "A" -> "rock"
        "B" -> "paper"
        "C" -> "scissors"
        "X" -> "rock"
        "Y" -> "paper"
        "Z" -> "scissors"
        else -> throw IllegalArgumentException("Invalid input")
    }
}

// create a function which takes a string containing rock paper or scissors and returns what is needed to win
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

