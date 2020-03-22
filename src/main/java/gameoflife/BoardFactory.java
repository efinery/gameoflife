package gameoflife;

import java.util.HashSet;
import java.util.Set;

public class BoardFactory {

    public Board create(int[][] seed) {
        Set<Cell> cells = new HashSet<>();

        for (int y = 0; y < seed.length; y++) {
            for (int x = 0; x < seed[y].length; x++) {
                if (seed[y][x] == 1) {
                    cells.add(new Cell(x, y));
                }
            }
        }
        return new Board(cells);
    }
}
