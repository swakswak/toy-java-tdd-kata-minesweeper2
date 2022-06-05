package swak.swak.minesweeper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MinefieldTest {
    @Test
    void should_Create() {
        // arrange
        Minefield minefield = new Minefield(3, 3, Minefield.Difficulty.EASY);

        // act

        // assert
        assertNotNull(minefield);
    }
}