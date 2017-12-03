package day3

val grid = HashMap<Int, HashMap<Int, Int>>()

private fun put(x: Int, y: Int, value: Int)
{
    if (!grid.containsKey(x))
    {
        grid.put(x, HashMap())
    }
    grid[x]!!.put(y, value)
}

enum class direction {
    right,
    up,
    left,
    down
}

fun main(args: Array<String>) {
    val input = 289326
    var result = 0

    var indexX = 0
    var indexY = 0
    var currentNumber = 1
    var currentDirection = direction.right
    var walkLength = 1
    var walkUntilNextCorner = walkLength
    while (currentNumber <= input) {
        val sum = calcSum(indexX, indexY)
        if (sum > input)
        {
            result = sum
        }
        put(indexX, indexY, sum);
        // walk
        currentNumber = sum
        walkUntilNextCorner --
        when (currentDirection) {
            direction.right -> {
                indexX++
            }
            direction.up -> {
                indexY--
            }
            direction.left -> {
                indexX--
            }
            direction.down -> {
                indexY++
            }
        }
        if (walkUntilNextCorner == 0) {
            when (currentDirection) {
                direction.right -> {
                    currentDirection = direction.up
                }
                direction.up -> {
                    walkLength++
                    currentDirection = direction.left
                }
                direction.left -> {
                    currentDirection = direction.down
                }
                direction.down -> {
                    walkLength++
                    currentDirection = direction.right
                }
            }
            walkUntilNextCorner = walkLength;
        }
    }
    printGrid();
    println("Result: " + result)
}

fun printGrid() {
    grid.toSortedMap().forEach() { x, yMap ->
        run {
            yMap.toSortedMap().forEach { y, value -> print("$value\t") };
            println();
        }
    }
}

fun calcSum(indexX: Int, indexY: Int): Int {
    if (indexX == 0 && indexY == 0)
        return 1;
    var result = 0
    for (x in -1..1)
    {
        for (y in -1..1)
        {
            val row = grid[indexX + x]
            if (row != null) {
                val value= row[indexY + y]
                if (value != null)
                {
                    result += value
                }
            }
        }
    }
    return result
}
