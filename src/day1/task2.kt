package day1

import java.lang.Integer.parseInt

fun main(args: Array<String>) {
    if (args.size != 1)
    {
        println("Wrong number of parameters, expected exactly 1, but got " +  args.size)
        return
    }

    val string = args[0]
    var result = 0
    val stepSize = string.length / 2
    for (index in 0 until string.length) {
        val current : Int = parseInt(string[index].toString())
        val compareToIndex = (index + stepSize) % string.length
        val compareTo : Int = parseInt(string[compareToIndex].toString())
        if (current == compareTo)
        {
            result += current
        }
    }
    println("Result: " + result)
}
