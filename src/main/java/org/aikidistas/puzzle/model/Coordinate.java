package org.aikidistas.puzzle.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Coordinate {
    private int x;
    private int y;

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
