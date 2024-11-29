fun main() {
    println(part1())
    println(part2())
}

fun part1(): Any {
    return input

}

fun part2(): Any {
    return input.reversed()
}

private val input: String by lazy {readInput()}

private fun readInput(): String {
    return object {}.javaClass.getResource("Day7.input").readText()
}
