package swak.swak.minesweeper;

public class Minefield {
    private final int width;
    private final int height;
    private final Difficulty difficulty;

    public Minefield(int width, int height, Difficulty difficulty) {
        this.width = width;
        this.height = height;
        this.difficulty = difficulty;
    }

    public enum Difficulty {
        EASY,
        NORMAL,
        HARD
    }
}
