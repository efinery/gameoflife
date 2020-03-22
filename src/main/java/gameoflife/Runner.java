package gameoflife;

import java.awt.*;

public class Runner {

    public static void main(String[] args) {
        ViewPort viewPort = new ViewPort(new Point(0, 0), new Dimension(5, 5));
        int[][] blinkerSeed = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
        };

        GameOfLife gameOfLife = new GameOfLife(blinkerSeed, viewPort);
        gameOfLife.run(10);
    }
}
