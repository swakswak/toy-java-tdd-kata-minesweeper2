package swak.swak.minesweeper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinefieldTest {
    @Test
    void should_Create() {
        // arrange
        Minefield minefield = new Minefield(3, 3, Minefield.Difficulty.EASY);

        // act

        // assert
        assertNotNull(minefield);
    }

    @Test
    void should_Difficulty() {
        // arrange
        Minefield easy = new Minefield(6, 6, Minefield.Difficulty.EASY);
        Minefield normal = new Minefield(6, 6, Minefield.Difficulty.NORMAL);
        Minefield hard = new Minefield(6, 6, Minefield.Difficulty.HARD);

        // act

        // assert
        assertTrue(easy.getNumberOfMine() < normal.getNumberOfMine());
        assertTrue(easy.getNumberOfMine() < hard.getNumberOfMine());
        assertTrue(normal.getNumberOfMine() < hard.getNumberOfMine());
    }
}