package gameoflife;

import java.util.HashSet;
import java.util.Set;

public class BoardBuilder {
    private final Set<Cell> cells = new HashSet<>();

    private BoardBuilder() {
    }

    public static BoardBuilder newBoard() {
        return new BoardBuilder();
    }

    public Board build() {
        return new Board(cells);
    }

    public BoardBuilder withCell(int x, int y) {
        cells.add(new Cell(x, y));
        return this;
    }

}
