package swak.swak.minesweeper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void should_CreateNumberTypeCell() {
        // arrange
        final int value = 1;
        Cell cell = Cell.numberOf(value);

        // act

        // assert
        assertEquals(CellType.NUMBER, cell.getType());
        assertEquals(value, cell.getValue());
    }

    @Test
    void should_CreateMineTypeCell() {
        // arrange
        final int expectedIntValue = -1;
        Cell mine = Cell.getMineInstance();

        // act

        // assert
        assertEquals(CellType.MINE, mine.getType());
        assertEquals(expectedIntValue, mine.getValue());
    }

    @Test
    void should_CreateSpaceTypeCell() {
        // arrange
        final int expectedIntValue = 0;
        Cell space = Cell.getSpaceInstance();

        // act

        // assert
        assertEquals(CellType.SPACE, space.getType());
        assertEquals(expectedIntValue, space.getValue());
    }

    @Test
    void should_ThrowsException_CellNumberValueOutOfRange() {
        // arrange
        // act

        // assert
        assertThrows(IllegalArgumentException.class, () -> Cell.numberOf(0));
        assertThrows(IllegalArgumentException.class, () -> Cell.numberOf(9));
        assertThrows(IllegalArgumentException.class, () -> Cell.numberOf(10));
    }

    @Test
    void should_Click() {
        // arrange
        Cell cell = Cell.getSpaceInstance();

        // act
        cell.click();

        // assert
        assertFalse(cell.isCovered());
    }
}