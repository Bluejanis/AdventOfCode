package day3


fun main(args: Array<String>) {
    val input = 289326

    var result = 0

    var minusWalks: Int
    var currentIntervall = 1
    var currentNumber = 2
    while (currentNumber <= input) {
        for (i in 1..2) {
            minusWalks = currentIntervall / 2
            var tempIntervall = currentIntervall
            while (tempIntervall > 0 && currentNumber <= input) {
                if (minusWalks > 0) {
                    result--
                    minusWalks--
                } else {
                    result++
                }
                currentNumber++
                tempIntervall--
            }
        }
        currentIntervall++
    }
    println("Result: " + result)
}
