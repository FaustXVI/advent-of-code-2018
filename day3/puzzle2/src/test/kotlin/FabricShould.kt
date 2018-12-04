import assertk.assertions.isEqualTo
import kotlin.test.Test
import assertk.assert
import assertk.assertions.containsExactly

class FabricShould {
    @Test
    fun giveIsolatedSquare() {
        assert(isolatedSquare(sequenceOf(
                "#1 @ 1,3: 4x4",
                "#2 @ 3,1: 4x4",
                "#3 @ 5,5: 2x2"))).isEqualTo(3)
    }

    @Test
    fun parseALine() {
        assert(intoLine("#1 @ 0,0: 1x1").id)
                .isEqualTo(1)
        assert(intoLine("#1 @ 0,0: 1x1").positions.toList())
                .containsExactly(Position(0, 0))
        assert(intoLine("#1 @ 1,0: 1x1").positions.toList())
                .containsExactly(Position(1, 0))
        assert(intoLine("#1 @ 0,1: 1x1").positions.toList())
                .containsExactly(Position(0, 1))
        assert(intoLine("#1 @ 0,0: 2x1").positions.toList())
                .containsExactly(Position(0, 0), Position(1,0))
        assert(intoLine("#1 @ 0,0: 2x2").positions.toList())
                .containsExactly(Position(0, 0), Position(1,0), Position(0,1), Position(1,1))
    }

}

