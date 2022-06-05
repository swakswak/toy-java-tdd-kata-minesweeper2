package swak.swak.minesweeper;

public class Cell {
    private final CellType cellType;
    private final int value;

    private Cell(CellType cellType, int value) {
        this.cellType = cellType;
        this.value = value;
    }

    public static Cell numberOf(int value) {
        return new Cell(CellType.NUMBER, value);
    }

    public static Cell getMineInstance() {
        return new Cell(CellType.MINE, -1);
    }

    public CellType getType() {
        return cellType;
    }

    public int getValue() {
        return value;
    }
}
