fun sharedSquares(lines: Sequence<String>): Int {
    return lines.flatMap(::intoPositions)
            .groupBy { it }
            .count { it.value.size > 1 }
}

fun intoPositions(line: String): Sequence<Position> {
    val matches = Regex("""#(\d+) @ (\d+),(\d+): (\d+)x(\d+)""").find(line)
            ?: return emptySequence()
    val lineNumbers = matches.groupValues.drop(1).map { it.toInt() }
    val topLeft = Position(lineNumbers[1], lineNumbers[2])
    val bottomRight = Position(lineNumbers[1] + lineNumbers[3] - 1, lineNumbers[2] + lineNumbers[4] - 1)
    return rectangle(topLeft, bottomRight).asSequence()
}

private fun rectangle(topLeft: Position, bottomRight: Position): Iterable<Position> =
        (topLeft.y..bottomRight.y).flatMap { y ->
            (topLeft.x..bottomRight.x).map { x -> Position(x, y) }
        }

data class Position(val x: Int, val y: Int)