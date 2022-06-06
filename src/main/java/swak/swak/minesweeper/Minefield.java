package swak.swak.minesweeper;

import org.junit.platform.commons.util.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Minefield {
    private final int width;
    private final int height;
    private final Difficulty difficulty;
    private final int numberOfMine;
    private final List<List<Cell>> mineTable;

    public Minefield(int width, int height, Difficulty difficulty) {
        this.width = width;
        this.height = height;
        this.difficulty = difficulty;
        this.numberOfMine = this.generateNumberOfMines(difficulty);

        Set<Integer> mineIndexSet = ThreadLocalRandom.current()
                .ints(0, width * height)
                .distinct()
                .limit(numberOfMine)
                .boxed()
                .collect(Collectors.toUnmodifiableSet());

        List<Cell> cellList = Stream.iterate(0, n -> n + 1)
                .limit((long) width * height)
                .map(n -> {
                    if (mineIndexSet.contains(n)) {
                        return Cell.getMineInstance();
                    }

                    int currentRow = n / width;
                    int currentColumn = n % width;
                    int countOfNearbyMines = 0;

                    for (int i = currentRow - 1; i <= currentRow + 1; i++) {
                        for (int j = currentColumn - 1; j <= currentColumn + 1; j++) {
                            if (i < 0 || j < 0 || i > (height - 1) || j > (width - 1)) {
                                continue;
                            }

                            int indexOfNearby = (i * width + j);
                            if (indexOfNearby >= 0 && mineIndexSet.contains(i * width + j)) {
                                countOfNearbyMines++;
                            }
                        }
                    }

                    return countOfNearbyMines > 0 ? Cell.numberOf(countOfNearbyMines) : Cell.getSpaceInstance();
                })
                .toList();

        int i = 0;
        List<Cell> cells = new ArrayList<>();
        this.mineTable = new ArrayList<>();
        for (Cell cell : cellList) {
            cells.add(cell);

            if (i % width == width - 1) {
                this.mineTable.add(cells);
                cells = new ArrayList<>();
            }

            i++;
        }
    }

    private int generateNumberOfMines(Difficulty difficulty) {
        final int maximumNumberOfMine = (width - 1) * (height - 1);
        final int unit = (maximumNumberOfMine - 1) / 3;

        return switch (difficulty) {
            case EASY -> 1 == unit ? 1 : ThreadLocalRandom.current().nextInt(1, unit);
            case NORMAL -> 1 == unit ? 2 : ThreadLocalRandom.current().nextInt(unit + 1, unit * 2);
            case HARD -> 1 == unit ? 3 : ThreadLocalRandom.current().nextInt(unit * 2 + 1, unit * 3);
        };
    }

    public int getNumberOfMine() {
        return this.numberOfMine;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        mineTable.forEach(cells -> {
            cells.forEach(cell -> stringBuilder.append(cell.toString()).append(" "));
            stringBuilder.append("\n");
        });

        return stringBuilder.toString();
    }

    public enum Difficulty {
        EASY,
        NORMAL,
        HARD
    }
}
