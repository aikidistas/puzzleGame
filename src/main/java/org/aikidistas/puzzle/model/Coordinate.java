package org.aikidistas.puzzle.model;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate getNeighbourUp() {
        return new Coordinate(x - 1, y);
    }

    public Coordinate getNeighbourDown() {
        return new Coordinate(x + 1, y);
    }

    public Coordinate getNeighbourLeft() {
        return new Coordinate(x, y - 1);
    }

    public Coordinate getNeighbourRight() {
        return new Coordinate(x, y + 1);
    }
}
