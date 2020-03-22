package gameoflife;

import java.awt.*;

public class ViewPort {
    private final Point position;
    private final Dimension dimension;

    public ViewPort(Point position, Dimension dimension) {
        this.position = position;
        this.dimension = dimension;
    }

    public int getX() {
        return position.x;
    }

    public int getY() {
        return position.y;
    }

    public int getWidth() {
        return dimension.width;
    }

    public int getHeight() {
        return dimension.height;
    }
}
