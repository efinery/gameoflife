package gameoflife;

public class GameOfLife {

    private final int[][] seed;
    private final ViewPort viewPort;
    private final BoardRenderer renderer = new BoardRenderer();

    public GameOfLife(int[][] seed, ViewPort viewPort) {
        this.seed = seed;
        this.viewPort = viewPort;
    }

    public void run(int generations) {
        Board board = new BoardFactory().create(seed);
        renderer.render(board, viewPort);

        for (int i = 0; i < generations; i++) {
            board = board.nextGeneration();
            renderer.render(board, viewPort);
        }
    }
}
