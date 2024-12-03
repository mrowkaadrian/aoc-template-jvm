import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    println(part1())
    println(part2())
}

fun part1(): Any {
    val matrix = readFileAsMatrix("Day2.input")
    var result = 0

    matrix.forEach {
        if (analyseLine(it))
            result++
    }

    return result
}

fun part2(): Any {
    val matrix = readFileAsMatrix("Day2.input")
    var result = 0

    matrix.forEach {
        if (analyseLineWithTolerance(it))
            result++
    }
    return result
}

private val input: String by lazy {readInput()}

private fun readInput(): String {
    return object {}.javaClass.getResource("Day1.input").readText()
}

private fun readFileAsMatrix(fileName: String) : List<List<Int>> {
    val resource = object {}.javaClass.getResource(fileName)
        ?: throw IllegalArgumentException("File $fileName not found in resources.")
    return Files.readAllLines(Paths.get(resource.toURI()))
        .map { line ->
            line.trim().split(" ").map(String::toInt)
        }
}

private fun analyseLine(numbers: List<Int>) : Boolean {

    val noDuplicates = numbers.distinct().size == numbers.size
    val noBigGaps = numbers.zipWithNext { a, b -> (-3 ..3).contains(b - a) }.all { it }
    val isIncreasing = numbers.zipWithNext { a, b -> b > a }.all { it }
    val isDecreasing = numbers.zipWithNext { a, b -> b < a }.all { it }

    return noDuplicates && noBigGaps && (isIncreasing || isDecreasing)
}

private fun analyseLineWithTolerance(numbers: List<Int>) : Boolean {
    if (analyseLine(numbers))
        return true

    // Try removing each element and check if the resulting list is valid
    return numbers.indices.any { index ->
        val modifiedList = numbers.toMutableList().apply { removeAt(index) }
        analyseLine(modifiedList)
    }
}
