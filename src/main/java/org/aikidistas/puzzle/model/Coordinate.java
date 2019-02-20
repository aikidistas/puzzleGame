package org.aikidistas.puzzle.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
