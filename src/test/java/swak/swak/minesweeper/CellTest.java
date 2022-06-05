package swak.swak.minesweeper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void should_createNumber() {
        // arrange
        final int value = 1;
        Cell cell = Cell.numberOf(value);

        // act

        // assert
        assertEquals(CellType.NUMBER, cell.getType());
        assertEquals(value, cell.getValue());
    }
}