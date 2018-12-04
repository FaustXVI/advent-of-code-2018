fun main(args: Array<String>) {
    println(isolatedSquare(allLines()))
}

fun allLines(): Sequence<String> {
    return generateSequence(::readLine)
}
