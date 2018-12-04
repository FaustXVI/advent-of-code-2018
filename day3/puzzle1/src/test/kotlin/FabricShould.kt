import assertk.assertions.isEqualTo
import kotlin.test.Test
import assertk.assert
import assertk.assertions.containsExactly

class FabricShould {
    @Test
    fun giveNumberOfSharedSquares() {
        assert(sharedSquares(sequenceOf(
                "#1 @ 1,3: 4x4",
                "#2 @ 3,1: 4x4",
                "#3 @ 5,5: 2x2"))).isEqualTo(4)
    }

    @Test
    fun transformALineIntoPositions() {
        assert(intoPositions("#1 @ 0,0: 1x1").toList())
                .containsExactly(Position(0, 0))
        assert(intoPositions("#1 @ 1,0: 1x1").toList())
                .containsExactly(Position(1, 0))
        assert(intoPositions("#1 @ 0,1: 1x1").toList())
                .containsExactly(Position(0, 1))
        assert(intoPositions("#1 @ 0,0: 2x1").toList())
                .containsExactly(Position(0, 0), Position(1,0))
        assert(intoPositions("#1 @ 0,0: 2x2").toList())
                .containsExactly(Position(0, 0), Position(1,0), Position(0,1), Position(1,1))
    }

}

