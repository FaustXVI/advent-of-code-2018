fun main(args: Array<String>) {
    println(sharedSquares(allLines()))
}

fun allLines(): List<String> {
    val result = mutableListOf<String>()
    while (true) {
        val line = readLine()
        if(line != null) {
            result.add(line)
        } else {
            break
        }
    }
    return result
}
