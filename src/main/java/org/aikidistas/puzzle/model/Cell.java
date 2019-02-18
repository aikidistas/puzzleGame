package org.aikidistas.puzzle.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Cell {
    public static final int EMPTY_VALUE = 0;
    private final int coordinateXInBoard;
    private final int coordinateYInBoard;
    private int value;

    private Cell(int value, int coordinateXInBoard, int coordinateYInBoard) {
        this.value = value;
        this.coordinateXInBoard = coordinateXInBoard;
        this.coordinateYInBoard = coordinateYInBoard;
    }

    public static Cell fromValueAndCoordinates(int value, int coordinateXInBoard, int coordinateYInBoard) {
        return new Cell(value, coordinateXInBoard, coordinateYInBoard);
    }

    public boolean isEmpty() {
        return this.value == EMPTY_VALUE;
    }

}
