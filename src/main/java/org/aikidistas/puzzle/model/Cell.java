package org.aikidistas.puzzle.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    public static final int EMPTY_VALUE = 0;
    private final int x;
    private final int y;
    private int value;

    private Cell(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public static Cell fromValueAndCoordinates(int value, int x, int y) {
        return new Cell(value, x, y);
    }

    public boolean isEmpty() {
        return this.value == EMPTY_VALUE;
    }

}
