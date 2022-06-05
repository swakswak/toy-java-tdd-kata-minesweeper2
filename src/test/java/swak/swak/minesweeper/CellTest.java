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
        assertEquals(Cell.Type.NUMBER, cell.getType());
        assertEquals(value, cell.getValue());
    }

    @Test
    void should_CreateMineTypeCell() {
        // arrange
        final int expectedIntValue = -1;
        Cell mine = Cell.getMineInstance();

        // act

        // assert
        assertEquals(Cell.Type.MINE, mine.getType());
        assertEquals(expectedIntValue, mine.getValue());
    }

    @Test
    void should_CreateSpaceTypeCell() {
        // arrange
        final int expectedIntValue = 0;
        Cell space = Cell.getSpaceInstance();

        // act

        // assert
        assertEquals(Cell.Type.SPACE, space.getType());
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

    @Test
    void should_Mine() {
        // arrange
        Cell mine = Cell.getMineInstance();
        Cell space = Cell.getSpaceInstance();
        Cell five = Cell.numberOf(5);

        // act

        // assert
        assertTrue(mine.isMine());
        assertFalse(space.isMine());
        assertFalse(five.isMine());
    }
}