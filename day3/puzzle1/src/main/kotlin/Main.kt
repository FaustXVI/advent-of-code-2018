fun main(args: Array<String>) {
    println(sharedSquares(allLines()))
}

fun allLines(): Sequence<String> {
    return generateSequence(::readLine)
}
