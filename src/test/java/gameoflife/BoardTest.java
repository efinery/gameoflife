package gameoflife;

import org.junit.Test;

import static gameoflife.BoardBuilder.newBoard;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void should_die_when_no_neighbours() throws Exception {
        Board board = newBoard()
                .withCell(1, 1)
                .build();

        Board newBoard = board.nextGeneration();

        assertFalse(newBoard.hasCellAt(1, 1));
    }

    @Test
    public void should_die_when_one_neighbour() throws Exception {
        Board board = newBoard()
                .withCell(1, 1)
                .withCell(1, 2)
                .build();

        Board newBoard = board.nextGeneration();

        assertFalse(newBoard.hasCellAt(1, 1));
    }

    @Test
    public void should_survive_when_two_neighbours() throws Exception {
        Board board = newBoard()
                .withCell(1, 1)
                .withCell(1, 2)
                .withCell(1, 0)
                .build();

        Board newBoard = board.nextGeneration();

        assertTrue(newBoard.hasCellAt(1, 1));
    }

    @Test
    public void should_survive_when_three_neighbours() throws Exception {
        Board board = newBoard()
                .withCell(0, 0)
                .withCell(1, 1)
                .withCell(1, 2)
                .withCell(1, 0)
                .build();

        Board newBoard = board.nextGeneration();

        assertTrue(newBoard.hasCellAt(1, 1));
    }

    @Test
    public void should_die_when_four_neighbours() throws Exception {
        Board board = newBoard()
                .withCell(0, 0)
                .withCell(1, 0)
                .withCell(2, 0)
                .withCell(0, 1)
                .build();

        Board newBoard = board.nextGeneration();

        assertFalse(newBoard.hasCellAt(1, 1));
    }

    @Test
    public void should_revive_cell_with_three_neighbours() throws Exception {
        int[][] seed = {
                {1, 1, 0},
                {1, 0, 0},
                {0, 0, 0},
        };
        Board board = new BoardFactory().create(seed);

        assertFalse(board.hasCellAt(1, 1));

        Board newBoard = board.nextGeneration();

        assertTrue(newBoard.hasCellAt(1, 1));
    }
}
