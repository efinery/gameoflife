package gameoflife;

import java.util.HashSet;
import java.util.Set;

public class Board {
    private final Set<Cell> cells;

    public Board(Set<Cell> cells) {
        this.cells = cells;
    }

    public Board nextGeneration() {
        Set<Cell> survivors = new HashSet<>();

        for (Cell cell : cells) {
            processCell(cell, survivors);

        }
        return new Board(survivors);
    }

    public boolean hasCellAt(int x, int y) {
        return cells.contains(new Cell(x, y));
    }

    private void processCell(Cell cell, Set<Cell> survivors) {
        determineIfSurvives(cell, survivors);
        determineIfNeighbourRevives(cell, survivors);
    }

    private void determineIfSurvives(Cell cell, Set<Cell> survivors) {
        Set<Cell> neighbours = cell.getLiveNeighbours(cells);
        int liveNeighbours = neighbours.size();

        if (cell.willSurvive(liveNeighbours)) {
            survivors.add(cell);
        }
    }

    private void determineIfNeighbourRevives(Cell cell, Set<Cell> survivors) {
        Set<Cell> deadNeighbours = cell.getDeadNeighbours(cells);

        for (Cell deadCelll : deadNeighbours) {
            if (!survivors.contains(deadCelll)) {
                Set<Cell> liveNeighbours = deadCelll.getLiveNeighbours(cells);

                if (liveNeighbours.size() == 3) {
                    survivors.add(deadCelll);
                }
            }
        }
    }
}
