package gameoflife;

import java.util.HashSet;
import java.util.Set;

public class Cell {
    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean willSurvive(int liveNeighbours) {
        return (liveNeighbours == 2 || liveNeighbours == 3);
    }

    public Set<Cell> getLiveNeighbours(Set<Cell> liveCells) {
        Set<Cell> neighbours = getNeighbours();
        neighbours.retainAll(liveCells);
        return neighbours;
    }

    public Set<Cell> getDeadNeighbours(Set<Cell> liveCells) {
        Set<Cell> neighbours = getNeighbours();
        neighbours.removeAll(liveCells);
        return neighbours;
    }

    public Set<Cell> getNeighbours() {
        Set<Cell> neighbours = new HashSet<>();
        for (int nx = -1; nx <= 1; nx++) {
            for (int ny = -1; ny <= 1; ny++) {
                neighbours.add(new Cell(x + nx, y + ny));
            }
        }
        neighbours.remove(this);
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return x + ":" + y;
    }
}
