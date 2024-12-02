import kotlin.math.abs

fun main() {
    println(part1())
    println(part2())
}

fun part1(): Any {
    var result = 0
    val (column1, column2) = read2Columns(input)

    column1.sorted().zip(column2.sorted()).forEach { (x, y) ->
        result += (abs(x - y))
    }

    return result
}

fun part2(): Any {
    var result = 0
    val (column1, column2) = read2Columns(input)

    column1.sorted().forEach { x ->
        result += x * column2.count { it == x }
    }

    return result
}

private val input: String by lazy {readInput()}

private fun readInput(): String {
    return object {}.javaClass.getResource("Day1.input").readText()
}

private fun read2Columns(data: String): Pair<List<Int>, List<Int>> {
    val columns = data
        .split("\n")
        .map { line -> line
            .trim()
            .split("\\s{3}".toRegex())
            .map(String::toInt)
        }

    return Pair(columns.map { it[0] }, columns.map { it[1] })
}
