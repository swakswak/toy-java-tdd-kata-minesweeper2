package swak.swak.minesweeper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void should_createMine() {
        // arrange
        Cell cell = Cell.numberOf(1);

        // act

        // assert
        assertEquals(CellType.NUMBER, cell.getType());
    }
}