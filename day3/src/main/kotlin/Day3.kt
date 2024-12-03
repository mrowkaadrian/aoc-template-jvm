fun main() {
    println(part1())
    println(part2())
}

fun part1(): Any {
    var result = 0

    Regex("mul\\(\\d+,\\d+\\)").findAll(input).forEach {
        result += executeMultiplication(it)
    }

    return result

}

fun part2(): Any {
    var result = 0
    var isEnabled = true

    Regex("(do\\(\\)|don't\\(\\)|mul\\(\\d+,\\d+\\))")
        .findAll(input)
        .forEach { operation ->
            when {
                operation.value == "do()" -> isEnabled = true
                operation.value == "don't()" -> isEnabled = false
                operation.value.startsWith("mul") ->  {
                    if (isEnabled)
                        result += executeMultiplication(operation)
                }
            }
        }

    return result
}

private fun executeMultiplication(it: MatchResult) : Int {
    return it.value
        .removeSurrounding("mul(", ")")
        .split(",")
        .map { it.toInt() }
        .reduce { a, b -> a * b }
}

private val input: String by lazy {readInput()}

private fun readInput(): String {
    return object {}.javaClass.getResource("Day3.input").readText()
}
