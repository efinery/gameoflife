package gameoflife;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CellStateTransitionTest {
    private final int liveNeighbours;
    private final boolean expected;

    public CellStateTransitionTest(int liveNeighbours, boolean expected) {
        this.liveNeighbours = liveNeighbours;
        this.expected = expected;
    }

    @Test
    public void should_transtion_cell_to_correct_state() {
        Cell cell = new Cell(1, 1);

        boolean willSurvive = cell.willSurvive(liveNeighbours);

        assertEquals(expected, willSurvive);
    }

    @Parameterized.Parameters(name = "Live cell with {0} neighbours should survive({1})")
    public static List<Object[]> parameters() {
        return Arrays.asList(
                new Object[][]{
                        {0, false},
                        {1, false},
                        {2, true},
                        {3, true},
                        {4, false},
                        {5, false},
                        {6, false},
                        {7, false},
                        {8, false}
                }
        );
    }
}