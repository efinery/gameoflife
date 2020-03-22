package gameoflife;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CellTest {

    @Test
    public void getNeighbours() throws Exception {
        Cell cell = new Cell(1, 1);

        Set<Cell> neighbours = cell.getNeighbours();
        assertEquals(8, neighbours.size());

        assertTrue(neighbours.contains(new Cell(0, 0)));
        assertTrue(neighbours.contains(new Cell(1, 0)));
        assertTrue(neighbours.contains(new Cell(2, 0)));

        assertTrue(neighbours.contains(new Cell(0, 1)));
        assertTrue(neighbours.contains(new Cell(2, 1)));

        assertTrue(neighbours.contains(new Cell(0, 2)));
        assertTrue(neighbours.contains(new Cell(1, 2)));
        assertTrue(neighbours.contains(new Cell(2, 2)));
    }

}