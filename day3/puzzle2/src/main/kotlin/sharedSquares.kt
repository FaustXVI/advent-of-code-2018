fun isolatedSquare(lines: Sequence<String>): Int {
    val parsedLines = lines.map { intoLine(it) }.toList()
    val unsharedSquares = unsharedSquares(parsedLines)
    return parsedLines.filter { unsharedSquares.containsAll(it.positions.toList()) }.first().id
}

fun unsharedSquares(lines: List<Line>): Set<Position> {
    return lines.flatMap { it.positions }
            .groupBy { it }
            .filter { it.value.size == 1 }
            .keys
}

fun intoLine(line: String): Line {
    val matches = Regex("""#(\d+) @ (\d+),(\d+): (\d+)x(\d+)""").find(line)
            ?: return Line(-1, emptyList())
    val lineNumbers = matches.groupValues.drop(1).map { it.toInt() }
    val topLeft = Position(lineNumbers[1], lineNumbers[2])
    val bottomRight = Position(lineNumbers[1] + lineNumbers[3] - 1, lineNumbers[2] + lineNumbers[4] - 1)
    return Line(lineNumbers[0], rectangle(topLeft, bottomRight))
}

private fun rectangle(topLeft: Position, bottomRight: Position): Iterable<Position> =
        (topLeft.y..bottomRight.y).flatMap { y ->
            (topLeft.x..bottomRight.x).map { x -> Position(x, y) }
        }

data class Line(val id: Int, val positions: Iterable<Position>)

data class Position(val x: Int, val y: Int)