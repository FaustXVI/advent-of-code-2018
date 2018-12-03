import assertk.assertions.isEqualTo
import kotlin.test.Test

class FabricShould {
    @Test
    fun giveNumberOfSharedSquares() {
        assertk.assert(sharedSquares(listOf(
                "#1 @ 1,3: 4x4",
                "#2 @ 3,1: 4x4",
                "#3 @ 5,5: 2x2"))).isEqualTo(2)
    }

}

