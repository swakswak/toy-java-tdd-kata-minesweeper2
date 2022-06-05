package swak.swak.minesweeper;

public class Cell {
    private static final int MINE_VALUE = -1;
    private static final int SPACE_VALUE = 0;
    private static final int MINIMUM_VALUE_OF_NUMBER_TYPE = 1;
    private static final int MAXIMUM_VALUE_OF_NUMBER_TYPE = 8;

    private final Type type;
    private final int value;
    private boolean isCovered;

    private Cell(Type type, int value) {
        this.type = type;
        this.value = value;
        this.isCovered = false;
    }

    public static Cell numberOf(int value) {
        validateNumberTypeCellValue(value);
        return new Cell(Type.NUMBER, value);
    }

    public static Cell getMineInstance() {
        return new Cell(Type.MINE, MINE_VALUE);
    }

    public static Cell getSpaceInstance() {
        return new Cell(Type.SPACE, SPACE_VALUE);
    }

    private static void validateNumberTypeCellValue(int value) {
        if (value < MINIMUM_VALUE_OF_NUMBER_TYPE || value > MAXIMUM_VALUE_OF_NUMBER_TYPE) {
            throw new IllegalArgumentException("Number type cell value must be between " +
                    MINIMUM_VALUE_OF_NUMBER_TYPE + " and " + MAXIMUM_VALUE_OF_NUMBER_TYPE + ".");
        }
    }

    public Type getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public void click() {
        this.isCovered = false;
    }

    public boolean isCovered() {
        return isCovered;
    }

    public boolean isMine() {
        return Type.MINE == type;
    }

    public enum Type {
        MINE,
        SPACE,
        NUMBER
    }
}
