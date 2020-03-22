package gameoflife;

public class BoardRenderer {

    public void render(Board board, ViewPort viewPort) {
        System.out.println();
        for (int y = 0; y < viewPort.getHeight(); y++) {
            for (int x = 0; x < viewPort.getWidth(); x++) {
                boolean alive = board.hasCellAt(viewPort.getX() + x, viewPort.getY() + y);
                System.out.print(alive ? "X" : ".");
            }
            System.out.println();
        }
    }
}
